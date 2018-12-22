/**
 * Created by vkorniie on 15/12/2018.
 */
public class Helicopter extends Aircraft implements Flyable {
    WeatherTower weathertower;
    String currentWeather;

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    @Override
    public void updateConditions() {
        currentWeather = WeatherProvider.getProvider().getCurrentWeather(coordinates);
        if (currentWeather == "RAIN") {
            Avaj.pw.print("It's rain now! Call the police!");
        }
    }
}
