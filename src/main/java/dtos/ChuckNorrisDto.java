package dtos;

//hallo
//hell
public class ChuckNorrisDto {
    private String id;
    private String value;

    public ChuckNorrisDto(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ChuckNorrisDto{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getJoke(String joke) {
        return joke;
    }
}
