import React, { Component } from 'react';
import './App.css';
import WeatherBlock from "./WeatherBlock"

class App extends Component {

  constructor() {
    super();
    this.state = {
      locations: [],
      currentLocation: {}
    };
    this.search = this.search.bind(this);
    this.loadWeather = this.loadWeather.bind(this);
  }

search(){
    let param = document.getElementById("location").value
    fetch("/api/location?search=" + param)
    .then(response => response.json())
    .then(locations => this.setState({locations}))
  }

loadWeather(currentLocation){
  fetch("/api/weather?cityCode=" + currentLocation.cityCode)
  .then(response => response.json())
  .then(cities => this.setState({currentLocation: cities}))

}

  render() {
    const locat = this.state.locations.map((currentLocation) => (
    <button onClick={() => this.loadWeather(currentLocation)} key={currentLocation.cityCode}> {currentLocation.name} <br/></button>
  )
  );
    const city = this.state.currentLocation;
    const query = "/api/favourites/add?city=" + city.id;
    return (
      <div className="App">
        <header className="App-header">
          <h1>Weather!</h1>
            <div>
              <label htmlFor="cities">Search for a location </label>
              <input type="text" id="location" /><br/>
              <input type="button" onClick={this.search} value="Search" />
              <p id="locationTarget">
                {locat}
              </p>
            </div>
            {city.name &&
              <WeatherBlock cityName={city.name} pressure={city.main.pressure} humidity={city.main.humidity} description={city.weather[0].description} temperature={city.main.temp} weather={city.weather[0].main} />
            }
            {city.name &&
            <a href={query} >Favourite</a>
            }
        </header>
      </div>
    );
  }
}

export default App;
