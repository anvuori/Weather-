import React, { Component } from 'react';
import './App.css';

class WeatherBlock extends Component {
  render() {
    let cityName = this.props.cityName;
    let temperature = this.props.temperature;
    let weather = this.props.weather;
    let pressure = this.props.pressure;
    let humidity = this.props.humidity;
    let description = this.props.description;
    return (
      <div className="WeatherBlock">
            <h2>{cityName}</h2>
            <ul>
            <li>{temperature} °C</li>
            <li>{weather}, {description}</li>
            <li>Pressure {pressure} hPa</li>
            <li>Humidity {humidity} %</li>
            </ul>
      </div>
    );
  }
}

export default WeatherBlock;
