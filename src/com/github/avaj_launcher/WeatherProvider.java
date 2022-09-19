package com.github.avaj_launcher;

import java.util.Random;

import com.github.avaj_launcher.Aircraft.Coordinates;

public class WeatherProvider {
  private static WeatherProvider weatherProvider;
  private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

  private WeatherProvider() {
  }

  public static WeatherProvider getProvider() {
    return weatherProvider;
  }

  public String getCurrentWeather(Coordinates coordinates) {
    int r = new Random().nextInt(4);

    return weather[r];
  }
}
