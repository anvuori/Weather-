package eu.pyprincess.weatherapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    //todo: docs!!!

    // API key from the property file
    @Value("${weather.api.key}")
    private String apiKey;

    /**
     *  Makes an api call to get weather data by city code
     * @param city
     * @return Weather data json as a string
     * @exception Exception
     */
    public String askWeatherByCityCode(City city) throws Exception{
        HttpURLConnection connection = null;
        String stringurl = "https://api.openweathermap.org/data/2.5/weather?id=" + city.getCityCode() + "&appid=" + this.apiKey;
        URL url = new URL(stringurl);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        // Read the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            response.append(line);
        }
        return response.toString();
    }

    /**
     *  Makes an api call to get weather data by several city codes
     * @param cityList - list of cities
     * @return Weather data json as a string
     * @exception Exception
     */
    public String askWeatherByList(List<City> cityList) throws Exception{

        HttpURLConnection connection = null;
        String cityCodes = cityList.stream().map(City::getCityCode).map(String::valueOf).collect(Collectors.joining(","));
        String stringurl = "http://api.openweathermap.org/data/2.5/group?id=" + cityCodes + "&units=metric&appid=" + this.apiKey;
        URL url = new URL(stringurl);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        // Read the response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            response.append(line);
        }
        return response.toString();
    }
}
