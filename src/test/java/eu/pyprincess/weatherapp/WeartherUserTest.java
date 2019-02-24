package eu.pyprincess.weatherapp;

import org.junit.Assert;
import org.junit.Test;

public class WeartherUserTest {
    @Test
    public void addFavouriteCity() {
        City city = new City("Tampere",  634964L, new Country("FI"), 123, 122);
    }

    @Test
    public void removeFavouriteCity() {
        City city = new City("Tampere",  634964L, new Country("FI"), 123, 122);
    }
}
