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

#### GET /api/favourites

* Parameters: username (required)

Returns a json containing all the given user's favourited locations' weather data

#### GET /api/weather

* Parameters: location (required)

Returns a json containing the given location's weather data

#### POST /api/location/weather

* Payload: location (required)

Returns a json containing the given location's weather data

### Tests

Unit and integration tests.

### Test data

Demo loads automatically location data from [json](http://bulk.openweathermap.org/sample/city.list.json.gz).

### Server side

REST api can be accessed in ```localhost:8080/api/```

### Client side

Client is built with React and runs in port ```localhost:3000```.
