package eu.pyprincess.weatherapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WeatherController {
    @Autowired
    private WeatherUserRepository userrepo;
    @Autowired
    private CityRepository cityrepo;
    @Autowired
    private WeatherService weatherservice;

    /**
     * Return weather data of user's favourite cities
     * @param principal
     * @return Weather data json of several cities as a string
     */
    @RequestMapping(value="/api/favourites/weather", method= RequestMethod.GET, produces="application/json")
    public String favouriteCityData(Principal principal){
        WeatherUser user = getUser(principal);
        List<City> cities = user.getFavouriteCities();
        String response;
        try {
            response = weatherservice.askWeatherByList(cities);
        } catch (Exception e){
            response = "{\"list\":[]}";
        }
        return response;
    }


    /**
     * Search locations by a substring
     * @param search - substring of the wanted location
     * @return List of cities that has the substring
     */
    @RequestMapping(value="/api/location", method= RequestMethod.GET, produces="application/json")
    public List<City> searchLocation(@RequestParam(value = "search", required = true) String search){
        List<City> cities = cityrepo.findAll();
        // Filter all the cities that contain the search
        // todo: make custom database query
        List<City> result = cities.stream().filter(x -> x.getName().toLowerCase().contains(search.toLowerCase())).collect(Collectors.toList());
        return result;
    }

    /**
     * Returns weather json data of the wanted location
     * @param cityCode - the city id
     * @return Weather data json of the city as a string
     */
    @RequestMapping(value="/api/weather", method= RequestMethod.GET, produces="application/json")
    public String getWeather(@RequestParam(value = "cityCode", required = true) Long cityCode){
        City city = cityrepo.getOne(cityCode);
        String response;
        try {
            response = weatherservice.askWeatherByCityCode(city);
        } catch (Exception e){
            response = "{}";
        }
        return response;
    }

    // todo: Search weather data by the favourite city code

    /**
     * Adds the user a new favourite city
     * @param cityCode - the city id
     * @param principal
     */
    @RequestMapping(value="/api/favourites/add", method= RequestMethod.GET, produces="application/json")
    public ResponseEntity addCity(@RequestParam(value = "city", required = true) Long cityCode, Principal principal){
        if(cityrepo.existsById(cityCode)) {
            City city = cityrepo.getOne(cityCode);
            WeatherUser user = getUser(principal);
            if(!user.hasCity(city)) {
                user.addCity(city);
                userrepo.save(user);
            }
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    /**
     * Removes the city id from the user
     * @param cityCode -the city id
     * @param principal
     */
    @RequestMapping(value="/api/favourites/remove", method= RequestMethod.GET, produces="application/json")
    public ResponseEntity removeCity(@RequestParam(value = "city", required = true) Long cityCode, Principal principal){
        if(cityrepo.existsById(cityCode)) {
            String username = principal.getName();
            City city = cityrepo.getOne(cityCode);
            WeatherUser user = userrepo.getOne(username);
            if(user.hasCity(city)) {
                user.removeCity(city);
                userrepo.save(user);
            }
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    /**
     * Returns the username of the user if it exists. Creates the user if doesn't.
     * @param principal
     * @return WeatherUser
     */
    public WeatherUser getUser(Principal principal){
        String username = principal.getName();
        WeatherUser user;
        if(userrepo.existsById(username)){
            user = userrepo.getOne(username);
            userrepo.save(user);
        }
        else{
            user = new WeatherUser(username);
            userrepo.save(user);
        }
        return user;
    }

}
