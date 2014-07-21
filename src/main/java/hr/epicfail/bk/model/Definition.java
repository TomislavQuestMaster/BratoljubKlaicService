package hr.epicfail.bk.model;

import hr.epicfail.bk.model.scholar.Scholar;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * @author tdubravcevic
 */
@Entity
@Proxy(lazy = false)
@Table(name = "definitions")
public class Definition {

	@Id
	@GeneratedValue
	private long id;

	private String text;
	@ManyToOne
	private Scholar owner;
	private int grade;

	public String getText() {

		return text;
	}

	public void setText(String text) {

		this.text = text;
	}

	public Scholar getOwner() {

		return owner;
	}

	public void setOwner(Scholar owner) {

		this.owner = owner;
	}

	public int getGrade() {

		return grade;
	}

	public void setGrade(int grade) {

		this.grade = grade;
	}

	public long getId() {

		return id;
	}

	public void setId(long id) {

		this.id = id;
	}
}
