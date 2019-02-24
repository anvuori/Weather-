package eu.pyprincess.weatherapp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City {

    /* Class variables */
    private String name;
    private int cityCode;
    @ManyToOne
    private Country country;
    private double lon;
    private double lat;
    @Id
    @GeneratedValue
    private Long id;

    public City(){}

    public City(String name, int cityCode, Country country, double lon, double lat) {
        this.name = name;
        this.cityCode = cityCode;
        this.country = country;
        this.lon = lon;
        this.lat = lat;
    }


    /* GETTERS AND SETTERS */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }


    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }


}
