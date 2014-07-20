package hr.epicfail.bk;

import hr.epicfail.bk.model.Word;
import hr.epicfail.bk.model.WordRepository;
import hr.epicfail.bk.model.scholar.Scholar;
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

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseBody
    public String getRandomWord() {

        long randomId = (long) (new Random().nextInt(2) + 1);
        Word randomWord = wordRepository.findOne(randomId);
        return randomWord.getValue();
    }

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    @ResponseBody
    public String startSession(@RequestBody SessionStartRequest request) {

        Session session = new Session();
        session.setWord(request.getWord());
        session.setState(SessionState.ACTIVE);
        session.getScholars().add(new Scholar(request.getUser()));
        sessionRepository.save(session);

        return "SUCCESS";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    @ResponseBody
    public String joinSession(long id) {

        Session session = sessionRepository.findOne(id);
        session.getScholars().add(new Scholar());

        return "SUCCESS";
    }

    @RequestMapping(value = "/sessions", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Session> getActiveSessions() {

        return sessionRepository.findAll(session.state.eq(SessionState.ACTIVE));
    }
}
