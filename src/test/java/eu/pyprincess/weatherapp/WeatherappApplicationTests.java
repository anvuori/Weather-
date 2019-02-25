package eu.pyprincess.weatherapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherappApplicationTests {

    @Autowired
    private WeatherService service;

    @Autowired
    private HomeController controller;

    @Autowired
    private WeatherController wcontroller;

    /**
     * Tests HomeController
     * @throws Exception
     */
    @Test
    public void contextLoads() throws Exception{
        Assert.assertNotNull(controller);
    }

    /**
     * Tests making an api call to one location weather data in WeatherService
     * @throws Exception
     */
	@Test
	public void testWeatherApiCall() throws Exception{
		City city = new City("Tampere", 634964L, new Country("FI"), 123, 122);
		String response;
		response = service.askWeatherByCityCode(city);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.contains("\"weather\":"));
	}

    /**
     * Tests making an api call to several location weather data in WeatherService
     * @throws Exception
     */
    @Test
    public void testWeatherApiCallList() throws Exception{
        City city = new City("Tampere", 634964L, new Country("FI"), 123, 122);
        City city2 = new City("Turku", 633679L, new Country("FI"), 123, 122);
        String response;
        response = service.askWeatherByList(Arrays.asList(city, city2));
        Assert.assertNotNull(response);
        Assert.assertTrue(response.contains("\"list\":"));
    }

    /**
     * Tests WeatherController /api/location
     * @throws Exception
     */
    @Test
    public void testRestApiLocation() throws Exception{
        List<City> cities = wcontroller.searchLocation("Tampe");
        List<City> result = cities.stream().filter(x ->x.getName().contains("Tampere")).collect(Collectors.toList());
        Assert.assertEquals(2, result.size());
    }

}