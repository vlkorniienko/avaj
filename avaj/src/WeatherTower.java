import java.util.ArrayList;
import java.util.List;

public class WeatherTower extends Tower {
    List<Flyable> observers = new ArrayList<>();

    @Override
    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    @Override
    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    @Override
    protected void conditionsChanged() {
        for (Flyable obs : observers) {
            obs.updateConditions();
        }
    }
    void changeWeather()
    {
        this.conditionsChanged();
    }
}
