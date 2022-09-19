package com.github.avaj_launcher.Aircraft;

import com.github.avaj_launcher.WeatherTower;

public interface Flyable {
  public void updateConditions();
  public void registerTower(WeatherTower weatherTower);
}
