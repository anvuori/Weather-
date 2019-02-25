package eu.pyprincess.weatherapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Represents Country
 */
@Entity
public class Country {
    @Id
    @Column(unique=true)
    private String name;

    public Country(){}

    /**
     * Constructor
     * @param name - The name of the country
     */
    public Country(String name) {
        this.name = name;
    }

    /* GETTERS AND SETTERS */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
