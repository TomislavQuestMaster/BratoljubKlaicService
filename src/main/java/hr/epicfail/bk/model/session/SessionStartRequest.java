package hr.epicfail.bk.model.session;

/**
 * Created by Tomo on 20.7.2014
 */
public class SessionStartRequest {

    private String word;
    private String user;
	private Long scholarId;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

	public Long getScholarId() {

		return scholarId;
	}

	public void setScholarId(Long scholarId) {

		this.scholarId = scholarId;
	}
}
