/**
 * Created by vkorniie on 15/12/2018.
 */
public class Helicopter extends Aircraft implements Flyable {
    WeatherTower weathertower;

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
    }

    @Override
    public void updateConditions() {
        
    }
}
