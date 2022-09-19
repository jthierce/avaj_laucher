package com.github.avaj_launcher.Aircraft;

import com.github.avaj_launcher.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
  WeatherTower weatherTower;

  Baloon(String name, Coordinates coordinates) {
    super (name, coordinates);
  }

  public void updateConditions() {
    String weather = weatherTower.getWeather(coordinates);
    int longitude = coordinates.getLongitude();
    int latitude = coordinates.getLatitude();
    int height = coordinates.getHeight();

    switch(weather) {
      case "RAIN":
        height -= 5;
        break;
      case "FOG":
        height -= 3;
        break;
      case "SUN":
        longitude += 2;
        height += 4;
        break;
      case "SNOW":
        height -= 15;
        break;
      default:
        break;
    }
    Coordinates newCoordinates = new Coordinates(longitude, latitude, height);
    this.coordinates = newCoordinates;
  }

  public void registerTower(WeatherTower weatherTower) {
    
  }
}
