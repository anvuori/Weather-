import React, { Component } from 'react';
import './App.css';

class WeatherBlock extends Component {
  remove(cityCode){
    fetch("/api/favourites/remove?city=" + cityCode);
    console.log(cityCode);
  }
  render() {
    let cityName = this.props.cityName;
    let cityCode = this.props.cityCode;
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
            <button onClick={() => this.remove(cityCode)}>Remove from favourites</button>
      </div>
    );
  }
}

export default WeatherBlock;
