package eu.pyprincess.weatherapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherappApplicationTests {

    @Autowired
    private WeatherService service;

	@Test
	public void contextLoads() {
	}


	@Test
	public void testWeatherApiCall(){
		City city = new City("Tampere", 634964L, new Country("FI"), 123, 122);
		String response;
		try {
			System.out.println("try");
			response = service.askWeatherByCityCode(city);
		} catch (Exception e){
			e.printStackTrace();
			response = "Cannot find data!";
		}
		Assert.assertNotNull(response);
		System.out.println(response);
	}

    @Test
    public void testWeatherApiCallList(){
        City city = new City("Tampere", 634964L, new Country("FI"), 123, 122);
        City city2 = new City("Turku", 633679L, new Country("FI"), 123, 122);
        String response;
        try {
            System.out.println("try");
            response = service.askWeatherByList(Arrays.asList(city, city2));
        } catch (Exception e){
            e.printStackTrace();
            response = "Cannot find data!";
        }
        Assert.assertNotNull(response);
        System.out.println(response);
    }

}
