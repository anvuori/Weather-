package eu.pyprincess.weatherapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class WeatherService {
    // API key from the property file
    @Value("${weather.api.key}")
    private String apiKey;

    @PostConstruct
    public void Yää(){
        System.out.println(apiKey);
    }

    /* Makes an api call to get weather data by city code */
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



}
