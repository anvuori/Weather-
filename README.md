# WeatherDemo with Spring Boot

An application to check the weather in the wanted location and save your favourite locations.
The app uses weather data from [OpenWeatherMap](https://openweathermap.org/current).

## How to build
React test build ```npm start```


## How to use


## What it contains

### API documentation

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

### Server side

REST api can be accessed in `localhost:8080/api/`

### Client side

Client is built with React and runs in port `localhost:3000`.
