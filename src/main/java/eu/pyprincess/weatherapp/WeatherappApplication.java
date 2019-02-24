package eu.pyprincess.weatherapp;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableOAuth2Sso
public class WeatherappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherappApplication.class, args);
	}

}

@Component
class DataGenerator implements CommandLineRunner{

    @Autowired
    private CityRepository cityrepo;

    @Autowired
    private CountryRepository countryrepo;

    @Override
    public void run(String... args) throws Exception {
        readCitiesFromJson();

    }


    /* Loads location data from the json-file in resources-directory. */
    public void readCitiesFromJson() {
        JSONTokener parser = new JSONTokener(Thread.currentThread().getContextClassLoader().getResourceAsStream("city.list.json"));
        JSONArray locations = new JSONArray(parser);
        for(Object o : locations){
            JSONObject obj = (JSONObject) o;
            JSONObject coord = ((JSONObject) o).getJSONObject("coord");
            double lon = ((Number)coord.get("lon")).doubleValue();
            double lat = ((Number)coord.get("lat")).doubleValue();
            Country country = new Country(obj.get("country").toString());
            countryrepo.save(country);
            City city = new City(obj.get("name").toString(), Long.valueOf((int)obj.get("id")), country, lon, lat);
            cityrepo.save(city);
        }
    }

}


