package com.github.avaj_launcher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.github.avaj_launcher.Aircraft.AircraftFactory;

public class Simulator {

  public static class IncorrectFileData extends Exception { 
    public IncorrectFileData(String errorMessage) {
        super(errorMessage);
    }
  }

  private static int timesOfSimulation;
  private static String line;
  private static Scanner myReader;
  private static WeatherTower weatherTower;

  private static void readFile(String file) {
    try {
      File myObj = new File(file);
      myReader = new Scanner(myObj);

      line = myReader.nextLine();

      timesOfSimulation = Integer.parseInt(line);
      myReader.close();
    }
    catch (FileNotFoundException e) {
      throw new Error(e);
    }
  }

  private static void create_aircraft() throws IncorrectFileData {
    String[] dataAircraft;

    while(myReader.hasNextLine()) {
      line = myReader.nextLine();
      dataAircraft = line.split(" ");
      if (dataAircraft.length != 5) {
        throw new Simulator.IncorrectFileData("The data on the file was invalid");
      }
      AircraftFactory.newAircraft(dataAircraft[0], dataAircraft[1], Integer.parseInt(dataAircraft[2]), Integer.parseInt(dataAircraft[3]), Integer.parseInt(dataAircraft[4]));
    }
    myReader.close();
  }

  public static void main(String[] args) {
    if (args.length < 1) {
      return ;
    }
    try {
      readFile(args[0]);
      create_aircraft();

      while(timesOfSimulation > 0) {
        weatherTower.changeWeather();
      }
    }
    catch(Exception e) {
      throw new Error("A error has occured:\n%s", e);
    }
  }
}
