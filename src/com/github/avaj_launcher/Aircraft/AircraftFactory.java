package com.github.avaj_launcher.Aircraft;

public class AircraftFactory {
  public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
    if (longitude < 0 && latitude < 0 && height < 0)
      throw new Error("Invalid coordinates");
    Coordinates coordinates = new Coordinates(longitude, latitude, height);

    switch(type.toLowerCase()) {
      case "helicoptere":
        return Helicopter.Helicopter(name, coordinates);
        break;
      case "jetplane":
        return JetPlane.Jetplane(name, coordinates);
      break;
      case "baloon":
        return Baloon.Baloon(name, coordinates);
        break;
      default:
        throw new Error("Invalid type aircraft");
        break;
    }
  }
}
