package eu.pyprincess.weatherapp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WeatherUser {
    @Id
    private String name;
    @OneToMany
    private List<City> favouriteCities = new ArrayList<>();

    public WeatherUser(){}

    /**
     * Constructor
     * @param name - username of the user
     */
    public WeatherUser(String name) {
        this.name = name;
    }

    /**
     * Checks if the user has the given city as a favourite
     * @param city
     * @return true if has, false if not
     */
    public boolean hasCity(City city){
      return favouriteCities.contains(city);
    }

    /**
     * Adds a favourite city to the user
     * @param city
     */
    public void addCity(City city){
        favouriteCities.add(city);
    }

    /**
     * Removes the city from the user
     * @param city
     */
    public void removeCity(City city){
        favouriteCities.remove(city);
    }

    /* GETTERS AND SETTERS */

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

}
