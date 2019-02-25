import React, { Component } from 'react';
import WeatherBlock from './WeatherBlock';
import './App.css';

class WeatherBlockList extends Component {
  constructor() {
    super();
    this.state = {
      cities: {
        cnt:0,
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
    const citie = this.state.cities.list.map((city) =>
      <WeatherBlock key={city.id} cityCode={city.id} cityName={city.name}
      pressure={city.main.pressure} humidity={city.main.humidity}
      description={city.weather[0].description}
      temperature={city.main.temp} weather={city.weather[0].main} />

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
