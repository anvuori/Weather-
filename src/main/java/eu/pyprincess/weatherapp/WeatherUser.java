package eu.pyprincess.weatherapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class WeatherUser {
    private String name;
    private List<City> favouriteCities;
    @Id
    @GeneratedValue
    private Long id;

    public WeatherUser(){}

    public WeatherUser(String name) {
        this.name = name;
    }

    public void addCity(City city){
        favouriteCities.add(city);
    }

    public void removeCity(City city){
        favouriteCities.remove(city);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getFavouriteCities() {
        return favouriteCities;
    }

    public void setFavouriteCities(List<City> favouriteCities) {
        this.favouriteCities = favouriteCities;
    }

    public Long getId() {
        return id;
    }


}
