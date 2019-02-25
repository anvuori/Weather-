package eu.pyprincess.weatherapp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * City represents one location/city
 */
@Entity
public class City {

    /* Class variables */
    private String name;
    @Id
    private Long cityCode;
    @ManyToOne
    private Country country;
    private double lon;
    private double lat;

    public City(){}

    /**
     * Constructor
     * @param name
     * @param cityCode - city id
     * @param country
     * @param lon - coordinate longitude
     * @param lat - coordinate latitude
     */
    public City(String name, Long cityCode, Country country, double lon, double lat) {
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

    public Long getCityCode() {
        return cityCode;
    }

    public void setCityCode(Long cityCode) {
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
