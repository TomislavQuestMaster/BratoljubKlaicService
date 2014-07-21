package hr.epicfail.bk.model.session;

/**
 * Created by Tomo on 20.7.2014
 */
public class SessionStartRequest {

    private Long wordId;
    private String user;
	private Long scholarId;

    public Long getWordId() {
        return wordId;
    }

    public void setWordId(Long wordId) {
        this.wordId = wordId;
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
