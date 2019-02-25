# WeatherApp with Spring Boot and React

An application to check the weather in the wanted location and save your favourite locations.
The app uses weather data from [OpenWeatherMap](https://openweathermap.org/current). The app uses GitHub OAuth.

## How to build

Clone repository and run

`mvn clean spring-boot:run`


## How to use

Weatherapp UI runs in `http://localhost:8080/`. First, you need to authenticate using a GitHub profile.

The front page contains two columns; first one lists the weather data of your favourite locations (you have none at first).

In the second column you can search locations writing a part of the city name to the textfield. There will be buttons of locations containing your search and by pressing them you see their weather data and can add it to your favourites.

Favouriting and removing a favourite reloads the page.


## What it contains

### API documentation

REST api can be accessed in `localhost:8080/api/`

#### GET /api/location

* Parameters: search

Returns a json array containing the locations that match the search

`http://localhost:8080/api/location?search=Tampe`

Example of response
```
[{"name":"Tampere","cityCode":634963,"country":{"name":"FI"},"lon":23.787121,"lat":61.499111},{"name":"Tampere","cityCode":634964,"country":{"name":"FI"},"lon":23.75,"lat":61.5},{"name":"Poiana Stampei","cityCode":670028,"country":{"name":"RO"},"lon":25.133329,"lat":47.316669},{"name":"Stampe","cityCode":2829573,"country":{"name":"DE"},"lon":10.01667,"lat":54.333328},{"name":"Etampes-sur-Marne","cityCode":3019458,"country":{"name":"FR"},"lon":3.41893,"lat":49.034641},{"name":"Etampes","cityCode":3019459,"country":{"name":"FR"},"lon":2.15,"lat":48.433331},{"name":"Étampes","cityCode":6446136,"country":{"name":"FR"},"lon":2.15,"lat":48.433331},{"name":"Arrondissement d'Étampes","cityCode":6457365,"country":{"name":"FR"},"lon":2.165,"lat":48.436699},{"name":"Tampekan","cityCode":7084557,"country":{"name":"ID"},"lon":114.973396,"lat":-8.2021},{"name":"Lendangtampel Daya","cityCode":7339616,"country":{"name":"ID"},"lon":116.287498,"lat":-8.6128}]
```

#### GET /api/favourites/weather

* Parameters: none

Returns a json object containing all the user's favourited locations' weather data. If there is none, returns an empty object.

`http://localhost:8080/api/favourites/weather`

Example of response
```
{"cnt":2,"list":[{"coord":{"lon":23.75,"lat":61.5},"sys":{"type":1,"id":1360,"message":0.0047,"country":"FI","sunrise":1551073159,"sunset":1551109079},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"main":{"temp":3.64,"pressure":1015,"humidity":69,"temp_min":3,"temp_max":4},"visibility":10000,"wind":{"speed":6.2,"deg":280},"clouds":{"all":0},"dt":1551075313,"id":634964,"name":"Tampere"},{"coord":{"lon":22.27,"lat":60.45},"sys":{"type":1,"id":1364,"message":0.0034,"country":"FI","sunrise":1551073350,"sunset":1551109595},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"main":{"temp":4,"pressure":1018,"humidity":69,"temp_min":4,"temp_max":4},"visibility":10000,"wind":{"speed":7.2,"deg":300,"gust":12.3},"clouds":{"all":0},"dt":1551075313,"id":633679,"name":"Turku"}]}
```


#### GET /api/weather

* Parameters: cityCode

Returns a json object containing the given location's weather data. If the cityCode is invalid, returns an empty object.

`http://localhost:8080/api/weather?cityCode=634964`

Example of response
```
{"coord":{"lon":23.75,"lat":61.5},"weather":[{"id":800,"main":"Clear","description":"clear sky","icon":"01d"}],"base":"stations","main":{"temp":3.64,"pressure":1015,"humidity":69,"temp_min":3,"temp_max":4},"visibility":10000,"wind":{"speed":6.2,"deg":280},"clouds":{"all":0},"dt":1551073800,"sys":{"type":1,"id":1360,"message":0.0036,"country":"FI","sunrise":1551073158,"sunset":1551109080},"id":634964,"name":"Tampere","cod":200}
```

#### GET /api/location/add

* Parameters: city

Adds the current user a new favourite city by city id.

Returns status code 200 (OK) if the city was added to the list or already exists on the list. Returns status code 400 (bad request) if the city did not exist.

`http://localhost:8080/api/location/add?city=634964`



#### GET /api/location/remove

* Parameters: city

Removes the current user a new favourite city by city id.

Returns status code 200 (OK) if the city was removed or didn't already exists. Returns status code 400 (bad request) if the city did not exist.

`http://localhost:8080/api/location/remove?city=634964`

### Tests

**Citytest** - Unit tests to the class City

**WeatherUserTest** - Unit tests to the class WeatherUser.

**WeatherappApplicationTests** - Tests controllers and WeatherService

### Test data

Demo loads automatically in-memory location data from [city.list.json](http://bulk.openweathermap.org/sample/city.list.json.gz).

## Future improvements and insights

[developer-diary.md](https://github.com/anvuori/Weather-/blob/master/developer-diary.md)
