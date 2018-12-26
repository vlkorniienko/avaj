package avaj.weather;

import avaj.aircrafts.*;
import avaj.weather.*;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private static String[] weather = {
        "RAIN",
        "FOG",
        "SUN",
        "SNOW"
    };

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    private WeatherProvider() {}

    public String getCurrentWeather(Coordinates coordinates) {
        int result = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();

        return weather[result % 4];
    }
}
