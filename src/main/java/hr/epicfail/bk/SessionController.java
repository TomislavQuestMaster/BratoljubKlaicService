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

import java.util.List;
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
    public String getRandomWord() {

        long randomId = (long) (new Random().nextInt(2) + 1);
        Word randomWord = wordRepository.findOne(randomId);
        return randomWord.getValue();
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
	@ResponseBody
    public Long startSession(@RequestBody SessionStartRequest request) {

        Session session = new Session();
        session.setWord(request.getWord());
        session.setState(SessionState.ACTIVE);
        session.setCreator(scholarRepository.findOne(request.getScholarId()));
        return sessionRepository.save(session).getId();
    }

	@RequestMapping(value = "/define", method = RequestMethod.POST)
	@ResponseBody
	public String submitDefinition(@RequestBody SubmitDefinitionRequest request) {

		Scholar scholar = scholarRepository.findOne(request.getScholarId());
		Session session = sessionRepository.findOne(request.getSessionId());

		Definition definition = new Definition();
		definition.setOwner(scholar);
		definition.setText(request.getText());
		definition = definitionRepository.save(definition);

		session.getDefinitions().add(definition);
		sessionRepository.save(session);

		return "SUCCESS";
	}

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    @ResponseBody
    public String joinSession(long id) {

        Session session = sessionRepository.findOne(id);

        return "SUCCESS";
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Session> getActiveSessions() {

        return sessionRepository.findAll(session.state.eq(SessionState.ACTIVE));
    }


}
