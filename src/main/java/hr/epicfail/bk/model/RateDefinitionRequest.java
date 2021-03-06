package hr.epicfail.bk.model;

/**
 * @author tdubravcevic
 */
public class RateDefinitionRequest {

    private Long definitionId;
	private Long sessionId;
	private Long scholarId;
	private String text;

	public Long getScholarId() {

		return scholarId;
	}

	public void setScholarId(Long scholarId) {

		this.scholarId = scholarId;
	}

	public String getText() {

		return text;
	}

	public void setText(String text) {

		this.text = text;
	}

	public Long getSessionId() {

		return sessionId;
	}

	public void setSessionId(Long sessionId) {

		this.sessionId = sessionId;
	}

    public Long getDefinitionId() {
        return definitionId;
    }

    public void setDefinitionId(Long definitionId) {
        this.definitionId = definitionId;
    }
}
