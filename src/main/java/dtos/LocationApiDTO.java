package dtos;

public class LocationApiDTO {

    private String ip;

    private String country;

    public LocationApiDTO(String ip, String country) {
        this.ip = ip;
        this.country = country;
    }

    public LocationApiDTO() {
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

    @Override
    public String toString() {
        return "LocationApiDTO{" +
                "ip='" + ip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
