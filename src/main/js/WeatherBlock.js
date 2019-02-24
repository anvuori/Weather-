import React, { Component } from 'react';
import './App.css';

class WeatherBlock extends Component {
  render() {
    let cityName = this.props.cityName;
    let temperature = this.props.temperature;
    let weather = this.props.weather;
    return (
      <div className="WeatherBlock">
            <h2>{cityName}</h2>
            <ul>
            <li>{temperature} °C</li>
            <li>{weather}</li>
            </ul>
      </div>
    );
  }
}

export default WeatherBlock;
