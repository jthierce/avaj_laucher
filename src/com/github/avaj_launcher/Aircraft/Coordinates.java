package com.github.avaj_launcher.Aircraft;

public class Coordinates {
  private int longitude;
  private int latitude;
  private int height;

  Coordinates(int longitude, int latitude, int height) {
    if (longitude < 0 || latitude < 0 || height < 0)
      throw new Error("Coordinates are negatives or we just accept positiv coordinate.");
    if (height > 100)
      height = 100;
    this.longitude = longitude;
    this.latitude = latitude;
    this.height = height;
  }

  public int getLongitude(){
    return this.longitude;
  }

  public int getLatitude(){
    return this.latitude;
  }

  public int getHeight(){
    return this.height;
  }
}
