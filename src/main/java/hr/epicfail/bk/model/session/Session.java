package hr.epicfail.bk.model.session;

import hr.epicfail.bk.model.Definition;
import hr.epicfail.bk.model.scholar.Scholar;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomo on 20.7.2014
 */
@Entity
@Proxy(lazy = false)
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue
    private long id;

    private String word;

	@ManyToOne
	private Scholar creator;

	@OneToMany(fetch = FetchType.EAGER)
    private List<Definition> definitions;

	@Enumerated(EnumType.STRING)
    private SessionState state;

	public Session() {
		definitions = new ArrayList<>();
	}

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

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
    }

    public SessionState getState() {
        return state;
    }

    public void setState(SessionState state) {
        this.state = state;
    }

	public Scholar getCreator() {

		return creator;
	}

	public void setCreator(Scholar creator) {

		this.creator = creator;

	}
}
