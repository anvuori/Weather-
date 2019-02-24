import React, { Component } from 'react';
import './App.css';

class Menu extends Component {
  render() {
    return (
      <ul id="nav">
      <li><a href="/logout">Logout</a></li>
      </ul>
    );
  }
}

export default Menu;
