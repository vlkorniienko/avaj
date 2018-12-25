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
        Avaj.pw.println("Tower says: " + this.getName() + "(" + this.id + ") " + "registered to weather tower");
    }

    @Override
    public void updateConditions() {
        currentWeather = WeatherProvider.getProvider().getCurrentWeather(coordinates);
        if (currentWeather.equals("RAIN")) {
            Avaj.pw.println(this.getName() + "(" + this.id + "):" + " It's rain now! Call the police!");
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
        }
        else if (currentWeather.equals("SNOW")) {
            Avaj.pw.println(this.getName() + "(" + this.id + "):" + " It's snow now! The winter is coming");
            this.coordinates.setHeight(this.coordinates.getHeight() - 12);
            if (this.coordinates.getHeight() < 1) {
                Avaj.pw.println(this.getName() + "(" + this.id + ")" + "landing.");
                weathertower.unregister(this);
                Avaj.pw.println("Tower says: " + this.getName() + "(" + this.id + ") " + "unregistered from weather tower");
            }
        }
        else if (currentWeather.equals("SUN")) {
            Avaj.pw.println(this.getName() + "(" + this.id + "):" + " It's sun now! Everybody hold on! We will land on the beach now");
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            if (this.coordinates.getHeight() > 100)
                this.coordinates.setHeight(100);
        }
        else if (currentWeather.equals("FOG")) {
            Avaj.pw.println(this.getName() + "(" + this.id + "):" + "It's fog now! Let's jump from the helicopter now");
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
        }
    }
}
