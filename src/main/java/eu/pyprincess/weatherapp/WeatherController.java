package eu.pyprincess.weatherapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    /* Return the user info from GitHub Authentication */
    @RequestMapping("/user")
    public Principal user(Principal principal) {
        System.out.println(principal.getName());
        return principal;
    }

    // Give weather data of the favourite cities



    // Search location
    @RequestMapping(value="/api/location", method= RequestMethod.GET, produces="application/json")
    public List<City> searchLocation(@RequestParam(value = "search", required = true) String search){
        List<City> cities = cityrepo.findAll();
        // Filter all the cities that contain the search
        // todo: make custom database query
        cities.stream().filter(x -> x.getName().toLowerCase().contains(search.toLowerCase())).collect(Collectors.toList());
        return cities;
    }

    // Search weather data of the location

    // Search weather data by the favourite city code

    // Add a new favourite city
    @RequestMapping(value="/api/favourites/add", method= RequestMethod.GET, produces="application/json")
    public void addCity(@RequestParam(value = "city", required = true) Long cityCode, Principal principal){
        String username = principal.getName();
        City city = cityrepo.getOne(cityCode);
        if(userrepo.existsById(username)){
            WeatherUser user = userrepo.getOne(username);
            user.addCity(city);
            userrepo.save(user);
        }
        else{
            WeatherUser user = new WeatherUser(username);
            user.addCity(city);
            userrepo.save(user);
        }
    }

    // Remove favourite city
    @RequestMapping(value="/api/favourites/remove", method= RequestMethod.GET, produces="application/json")
    public void removeCity(@RequestParam(value = "city", required = true) Long cityCode, Principal principal){
        String username = principal.getName();
        City city = cityrepo.getOne(cityCode);
        WeatherUser user = userrepo.getOne(username);
        user.removeCity(city);
        userrepo.save(user);
    }
}
