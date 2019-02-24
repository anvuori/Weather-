package eu.pyprincess.weatherapp;

import org.junit.Assert;
import org.junit.Test;

public class CityTest {

    /**
     * Tests creating a city.
     */
    @Test
    public void createCity() {
        City city = new City("Tampere",  634964L, new Country("FI"), 123, 122);
        Assert.assertEquals("Tampere", city.getName());
        Assert.assertEquals("FI", city.getCountry().getName());
        Assert.assertEquals((Long) 634964L, city.getCityCode());
        // todo: check if delta is good
        Assert.assertEquals(123, city.getLon(), 0);
        Assert.assertEquals(122, city.getLat(), 0);
    }
}
