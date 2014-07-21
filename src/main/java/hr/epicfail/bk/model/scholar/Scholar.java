package hr.epicfail.bk.model.scholar;

import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Tomo on 20.7.2014
 */
@Entity
@Proxy(lazy=false)
@Table(name = "scholars")
public class Scholar {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String password;

    private int rank;

    public Scholar() {
    }

    public Scholar(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
