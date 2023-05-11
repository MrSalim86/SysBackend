package dtos;

import java.util.ArrayList;

public class JokeDTO {
    private String id;
    private ArrayList<String> joke;

    public JokeDTO(ChuckNorrisDto Cnd) {
        this.id = Cnd.getId();
        joke = new ArrayList<>();
        addJoke(Cnd.getValue());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getJoke() {
        return joke;
    }

    public void addJoke(String joke) {
        this.joke.add(joke);
    }

    @Override
    public String toString() {
        return "JokeDTO{" +
                "id='" + id + '\'' +
                ", joke=" + joke +
                '}';
    }
}
