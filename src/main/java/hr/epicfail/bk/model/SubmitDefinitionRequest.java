package hr.epicfail.bk.model;

/**
 * @author tdubravcevic
 */
public class SubmitDefinitionRequest {

	private Long sessionId;
	private Long definitionId;
	private String text;

	public Long getDefinitionId() {

		return definitionId;
	}

	public void setDefinitionId(Long definitionId) {

		this.definitionId = definitionId;
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
}
