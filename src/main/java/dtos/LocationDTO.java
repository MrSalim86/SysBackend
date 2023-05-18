package dtos;

import entities.Location;

import java.util.ArrayList;

public class LocationDTO {
    private long id;
    private String ipaddress;
    private String country;

    private static ArrayList<Location> locations;

    public LocationDTO(long id, String ipaddress, String country) {
        this.id = id;
        this.ipaddress = ipaddress;
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

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
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
                ", ip='" + ipaddress + '\'' +
                ", country=" + country +
                '}';
    }
}
