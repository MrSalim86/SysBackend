package entities;

import javax.persistence.*;
@Entity
@Table(name = "joke", schema = "CA2", catalog = "")
public class Joke {

    public Joke() {
    }


    @Basic
    @Column(name = "ChuckNorris")
    private String chuckNorris;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    public String getChuckNorris() {
        return chuckNorris;
    }

    public void setChuckNorris(String chuckNorris) {
        this.chuckNorris = chuckNorris;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Joke that = (Joke) o;

        if (id != that.id) return false;
        if (chuckNorris != null ? !chuckNorris.equals(that.chuckNorris) : that.chuckNorris != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chuckNorris != null ? chuckNorris.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}
