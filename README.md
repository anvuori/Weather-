# WeatherApp with Spring Boot and React

An application to check the weather in the wanted location and save your favourite locations.
The app uses weather data from [OpenWeatherMap](https://openweathermap.org/current). The app has GitHub OAuth.

## How to build

Clone repository and run

`mvn clean package`


## How to use

Weatherapp UI runs in `http://localhost:8080/`. First, you need to authenticate using a GitHub profile.

The front page contains two columns; first one lists the weather data of your favourite locations (you have none at first).

In the second column you can search locations writing a part of the city name to the textfield. There will be buttons of locations containing your search and by pressing them you see their weather data and can add it to your favourites.


## What it contains

### API documentation

REST api can be accessed in `localhost:8080/api/`

#### GET /api/location

* Parameters: search

Returns a json containing the locations that match the search

`https://localhost:8080/api/location?search=Tampe`

#### GET /api/favourites/weather

* Parameters: none

Returns a json containing all the user's favourited locations' weather data

`https://localhost:8080/api/favourites/weather`

#### GET /api/weather

* Parameters: cityCode

Returns a json containing the given location's weather data

`https://localhost:8080/api/weather?cityCode=634964`

#### GET /api/location/add

* Parameters: city

`https://localhost:8080/api/location/add?city=634964`

#### GET /api/location/remove

* Parameters: city

`https://localhost:8080/api/location/remove?city=634964`

### Tests

Unit and integration tests.

### Test data

Demo loads automatically in-memory location data from [json](http://bulk.openweathermap.org/sample/city.list.json.gz).
