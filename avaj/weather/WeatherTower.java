package avaj.weather;

import avaj.aircrafts.*;
import avaj.weather.*;

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
    public void conditionsChanged() {
        for(int i = 0; i < observers.size(); i++)
        {
            observers.get(i).updateConditions();
        }
    }
    void changeWeather()
    {
        this.conditionsChanged();
    }

    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
}
