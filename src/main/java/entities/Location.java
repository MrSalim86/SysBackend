package entities;
import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = true)
    private Integer id;

    @Column(name = "ipaddress")
    private String ipaddress;

    @Column(name = "country")
    private String country;



    public Location(String ipaddress, String country) {
    }

    public Location(Integer id, String ipaddress, String country) {
        this.id = id;
        this.ipaddress = ipaddress;
        this.country = country;

    }

    public Location() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}

