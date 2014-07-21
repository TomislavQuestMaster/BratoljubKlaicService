package hr.epicfail.bk.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * Created by Tomo.
 */
@Entity
@Proxy(lazy=false)
@Table(name="words")
public class Word {

    @Id
    @GeneratedValue
    private long id;

    private String value;

    @OneToOne
    private Definition meaning;

    public Word() {
    }

    public Word(String value) {
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Definition getMeaning() {
        return meaning;
    }

    public void setMeaning(Definition meaning) {
        this.meaning = meaning;
    }
}
