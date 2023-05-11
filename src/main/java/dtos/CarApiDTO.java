package dtos;

public class CarApiDTO {
    private int make_id;
    private String make_name;
    private int model_id;
    private String model_name;

    public CarApiDTO(int make_id, String make_name, int model_id, String model_name) {
        this.make_id = make_id;
        this.make_name = make_name;
        this.model_id = model_id;
        this.model_name = model_name;
    }

    public int getMake_id() {
        return make_id;
    }

    public void setMake_id(int make_id) {
        this.make_id = make_id;
    }

    public String getMake_name() {
        return make_name;
    }

    public void setMake_name(String make_name) {
        this.make_name = make_name;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }
}
