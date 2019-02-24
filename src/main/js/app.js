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
    console.table(this.state);
    const locat = this.state.locations.map((currentLocation) => (
    <button onClick={() => this.loadWeather(currentLocation)}> {currentLocation.name} <br/></button>
  )
  );
    console.table(this.state.currentLocation);
    const city = this.state.currentLocation;
    return (
      <div className="App">
        <header className="App-header">
          <h1>Weather!</h1>
            <div>
              <label for="cities">Search for a location </label>
              <input type="text" id="location" /><br/>
              <input type="button" onClick={this.search} value="Search" />
              <p id="locationTarget">
                {locat}
              </p>
            </div>
            {city.name &&
            <WeatherBlock cityName={city.name} temperature={city.main.temp} weather={city.weather[0].main} />
            }
        </header>
      </div>
    );
  }
}

export default App;
