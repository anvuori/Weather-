package eu.pyprincess.weatherapp;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class WeartherUserTest {
    /**
     * Tests adding a city to the favourite city list
     *
     */
    @Test
    public void addFavouriteCity() {
        City city = new City("Tampere",  634964L, new Country("FI"), 123, 122);
        WeatherUser user = new WeatherUser("TestUser");
        user.addCity(city);
        Assert.assertEquals(user.getFavouriteCities(), Arrays.asList(city));
    }

    /**
     * Tests hasCity()
     *
     */
    @Test
    public void testHasCity() {
        City city = new City("Tampere",  634964L, new Country("FI"), 123, 122);
        WeatherUser user = new WeatherUser("TestUser");
        user.addCity(city);
        Assert.assertEquals(user.hasCity(city), true);
    }

    /**
     * Tests removing a favourite city from the city list
     */
    @Test
    public void removeFavouriteCity() {
        City city = new City("Tampere",  634964L, new Country("FI"), 123, 122);
        WeatherUser user = new WeatherUser("TestUser");
        user.addCity(city);
        Assert.assertEquals(user.getFavouriteCities(), Arrays.asList(city));
        user.removeCity(city);
        Assert.assertEquals(user.getFavouriteCities(), Collections.emptyList());
    }
}
