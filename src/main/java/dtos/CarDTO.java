package dtos;

import entities.Car;

import java.util.ArrayList;

public class CarDTO {
    private long id;
    private String make;
    private String model;
    private int year;
    private ArrayList<Car> cars;


    public CarDTO(long id, String make, String model, int year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
    }
}
