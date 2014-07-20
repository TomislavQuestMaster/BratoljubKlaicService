package hr.epicfail.bk.model.session;

import hr.epicfail.bk.model.scholar.Scholar;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Tomo on 20.7.2014
 */
@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue
    private long id;

    private String word;

    @Column
    @ElementCollection(targetClass=Scholar.class)
    private List<Scholar> scholars;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> definitions;

    private SessionState state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Scholar> getScholars() {
        return scholars;
    }

    public void setScholars(List<Scholar> scholars) {
        this.scholars = scholars;
    }

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    public SessionState getState() {
        return state;
    }

    public void setState(SessionState state) {
        this.state = state;
    }
}
