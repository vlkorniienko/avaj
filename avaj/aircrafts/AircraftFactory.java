package avaj.aircrafts;

import  avaj.aircrafts.*;
import avaj.weather.*;

public class AircraftFactory {
    public static Coordinates coordinates;

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        if (type.equals("Helicopter")) {
            coordinates = new Coordinates(longitude, latitude, height);
            return new Helicopter(name, coordinates);
        }
        else if (type.equals("JetPlane")) {
            coordinates = new Coordinates(longitude, latitude, height);
            return new JetPlane(name, coordinates);
        }
        else if (type.equals("Baloon")) {
            coordinates = new Coordinates(longitude, latitude, height);
            return new Ballon(name, coordinates);
        }
        return null;
    }
}
