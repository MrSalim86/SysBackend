package dtos;

public class CarApiDTO {
    private int Make_ID;
    private String Make_Name;
    private int Model_ID;
    private String Model_Name;

    public CarApiDTO(int Make_ID, String make_name, int model_id, String Model_Name) {
        this.Make_ID = Make_ID;
        this.Make_Name = make_name;
        this.Model_ID = model_id;
        this.Model_Name = Model_Name;
    }

    public int getMake_ID() {
        return Make_ID;
    }

    public void setMake_ID(int make_ID) {
        this.Make_ID = make_ID;
    }

    public String getMake_Name() {
        return Make_Name;
    }

    public void setMake_Name(String make_Name) {
        this.Make_Name = make_Name;
    }

    public int getModel_ID() {
        return Model_ID;
    }

    public void setModel_ID(int model_ID) {
        this.Model_ID = model_ID;
    }

    public String getModel_Name() {
        return Model_Name;
    }

    public void setModel_Name(String model_Name) {
        this.Model_Name = model_Name;
    }

    @Override
    public String toString() {
        return "CarApiDTO{" +
                "make_id=" + Make_ID +
                ", make_name='" + Make_Name + '\'' +
                ", model_id=" + Model_ID +
                ", model_name='" + Model_Name + '\'' +
                '}';
    }
}
