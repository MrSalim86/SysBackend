package entities;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Double year;

    @Column(name = "location")
    private String location;

    @Column(name = "price")
    private Double price;

    @Column(name = "username")
    private String username;

    public Car() {
    }

    public Car(String make, String model, Double year, String location, Double price, String username) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.location = location;
        this.price = price;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getYear() {
        return year;
    }

    public void setYear(Double year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}