package dtos;

import entities.Location;

import java.util.ArrayList;

public class LocationDTO {
    private long id;
    private String ip;
    private String country;

    private static ArrayList<Location> locations;

    public LocationDTO(long id, String ip, String country) {
        this.id = id;
        this.ip = ip;
        this.country = country;

    }

    public LocationDTO(Location location) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static ArrayList<Location> getLocations() {
        return locations;
    }
    @Override
    public String toString() {
        return "LocationDTO{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", country=" + country +
                '}';
    }
}
