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
    this.favourite = this.favourite.bind(this);
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

  favourite(cityCode){
    fetch("/api/favourites/add?city=" + cityCode);
    window.location.reload();
  }

  render() {
    const locat = this.state.locations.map((currentLocation) => (
    <button onClick={() => this.loadWeather(currentLocation)} key={currentLocation.cityCode}> {currentLocation.name} <br/></button>
  )
  );
    const city = this.state.currentLocation;
    return (
      <div className="App">

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
              <WeatherBlock  cityCode={city.id} cityName={city.name} pressure={city.main.pressure}
              humidity={city.main.humidity} description={city.weather[0].description}
              temperature={city.main.temp} weather={city.weather[0].main} />
            }
            {city.name &&
              <p>
              <button onClick={() => this.favourite(city.id)} >Favourite</button>
              </p>
            }

      </div>
    );
  }
}

export default App;
