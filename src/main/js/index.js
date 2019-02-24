import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import WeatherBlockList from './WeatherBlockList';
import './App.css';

ReactDOM.render(<App />, document.getElementById('root'));
ReactDOM.render(<WeatherBlockList />, document.getElementById('favourites'));
