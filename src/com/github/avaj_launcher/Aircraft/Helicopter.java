package com.github.avaj_launcher.Aircraft;

import com.github.avaj_launcher.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
  WeatherTower weatherTower;

  Helicopter(String name, Coordinates coordinates) {
    super (name, coordinates);
  }

  public void updateConditions() {
    String weather = weatherTower.getWeather(coordinates);
    int longitude = coordinates.getLongitude();
    int latitude = coordinates.getLatitude();
    int height = coordinates.getHeight();

    switch(weather) {
      case "RAIN":
        longitude += 5;
        break;
      case "FOG":
        longitude += 1;
        break;
      case "SUN":
        longitude += 10;
        height += 2;
        break;
      case "SNOW":
        height -= 12;
        break;
      default:
        break;
    }
    Coordinates newCoordinates = new Coordinates(longitude, latitude, height);
    this.coordinates = newCoordinates;
  }

  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    weatherTower.register(this);
  }
}
