package avaj.aircrafts;

import avaj.aircrafts.*;
import avaj.weather.*;

public interface Flyable {
    public void updateConditions ();
    public void registerTower(WeatherTower weatherTower);
}
