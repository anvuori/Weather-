import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import Menu from './Menu';
import WeatherBlockList from './WeatherBlockList';
import './App.css';

ReactDOM.render(<Menu />, document.getElementById('menu'));
ReactDOM.render(<App />, document.getElementById('root'));
ReactDOM.render(<WeatherBlockList />, document.getElementById('favourites'));
