package com.github.avaj_launcher;

import com.github.avaj_launcher.Aircraft.Coordinates;

public class WeatherTower extends Tower {
  public String getWeather(Coordinates coordinates) {
    String weather = WeatherProvider.getProvider().getCurrentWeather(coordinates);

    return weather;
  }

  void changeWeather() {
    this.conditionsChanged();
  }
}
