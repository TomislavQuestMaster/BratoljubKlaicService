package hr.epicfail.bk;

import hr.epicfail.bk.model.*;
import hr.epicfail.bk.model.scholar.Scholar;
import hr.epicfail.bk.model.scholar.ScholarRepository;
import hr.epicfail.bk.model.session.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

import static hr.epicfail.bk.model.session.QSession.*;

/**
 * Created by Tomo.
 */
@Controller
public class SessionController {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private SessionRepository sessionRepository;

	@Autowired
	private ScholarRepository scholarRepository;

	@Autowired
	private DefinitionRepository definitionRepository;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Long register(@RequestBody Scholar scholar) {

		return scholarRepository.save(scholar).getId();
	}

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseBody
    public Word getRandomWord() {

        long randomId = (long) (new Random().nextInt(2) + 1);
        return wordRepository.findOne(randomId);
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
	@ResponseBody
    public Long startSession(@RequestBody SessionStartRequest request) {

        Word word = wordRepository.findOne(request.getWordId());
        Scholar creator = scholarRepository.findOne(request.getScholarId());

        Session session = new Session();
        session.setWord(word);
        session.setState(SessionState.ACTIVE);
        session.setCreator(creator);

        session.getDefinitions().add(word.getMeaning());

        Definition definition = new Definition();
        definition.setOwner(creator);
        definition = definitionRepository.save(definition);

        session.getDefinitions().add(definition);

        return sessionRepository.save(session).getId();
    }

	@RequestMapping(value = "/define", method = RequestMethod.POST)
	@ResponseBody
	public String submitDefinition(@RequestBody SubmitDefinitionRequest request) {

        Definition definition = definitionRepository.findOne(request.getDefinitionId());
        definition.setText(request.getText());
        definitionRepository.save(definition);

		return "SUCCESS";
	}

    @RequestMapping(value = "/rate", method = RequestMethod.POST)
    @ResponseBody
    public String rateDefinition(@RequestBody RateDefinitionRequest request) {

        Scholar scholar = scholarRepository.findOne(request.getScholarId());
        gradeDefinition(request.getDefinitionId(), scholar);

        return "SUCCESS";
    }

    private synchronized void gradeDefinition(Long id, Scholar scholar) {

        Definition definition = definitionRepository.findOne(id);
        if(definition.getOwner() == null){
            scholar.setRank(scholar.getRank()+1);
            scholarRepository.save(scholar);
            return;
        }
        Scholar owner = definition.getOwner();
        owner.setRank(owner.getRank()+1);
        scholarRepository.save(owner);
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    @ResponseBody
    public String joinSession(@RequestBody JoinSessionRequest request) {

        Session session = sessionRepository.findOne(request.getSessionId());

        Scholar scholar = scholarRepository.findOne(request.getScholarId());

        Definition definition = new Definition();
        definition.setOwner(scholar);
        definition = definitionRepository.save(definition);

        session.getDefinitions().add(definition);
        sessionRepository.save(session);

        return "SUCCESS";
    }

    @RequestMapping(value = "/definitions", method = RequestMethod.POST)
    @ResponseBody
    public Iterable<Definition> getDefinitions(@RequestBody Long sessionId) {

        return sessionRepository.findOne(sessionId).getDefinitions();
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Session> getActiveSessions() {

        return sessionRepository.findAll(session.state.eq(SessionState.ACTIVE));
    }


}
