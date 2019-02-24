import React, { Component } from 'react';
import WeatherBlock from './WeatherBlock';
import './App.css';

class WeatherBlockList extends Component {
  constructor() {
    super();
    this.state = {
      cities: {
        list:[

        ]
      },
    };
  }
  componentDidMount(){
    fetch("/api/favourites/weather")
    .then(response => response.json())
    .then(cities => this.setState({cities}))
  }
  render() {
    console.table(this.state.cities);
    const citie = this.state.cities.list.map((city) =>
      <WeatherBlock cityName={city.name} temperature={city.main.temp} weather={city.weather[0].main} />
    );
    return (
      <div className="WeatherBlocks">
      <h1>Favourite locations</h1>
          {citie}
      </div>
    );
  }
}
export default WeatherBlockList;
