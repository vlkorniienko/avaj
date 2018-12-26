/**
 * Created by vkorniie on 15/12/2018.
 */
public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private String currentWeather;

    protected Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Avaj.pw.println("Tower says: " + "Helicopter#" + this.getName() + "(" + this.id + ") " + "registered to weather tower");
    }

    @Override
    public void updateConditions() {
        currentWeather = WeatherProvider.getProvider().getCurrentWeather(this.coordinates);
        if (currentWeather.equals("RAIN")) {
            Avaj.pw.println("Helicopter#" + this.getName() + "(" + this.id + "):" + " It's rain now! Call the police!");
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
        }
        else if (currentWeather.equals("SNOW")) {
            Avaj.pw.println("Helicopter#" + this.getName() + "(" + this.id + "):" + " It's snow now! The winter is coming");
            this.coordinates.setHeight(this.coordinates.getHeight() - 12);
            if (this.coordinates.getHeight() < 1) {
                Avaj.pw.println("Helicopter#" + this.getName() + "(" + this.id + ")" + "landing.");
                this.weatherTower.unregister(this);
            }
        }
        else if (currentWeather.equals("SUN")) {
            Avaj.pw.println("Helicopter#" + this.getName() + "(" + this.id + "):" + " It's sun now! Everybody hold on! We will land on the beach now");
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            if (this.coordinates.getHeight() > 100)
                this.coordinates.setHeight(100);
        }
        else if (currentWeather.equals("FOG")) {
            Avaj.pw.println("Helicopter#" + this.getName() + "(" + this.id + "):" + " It's fog now! Let's jump from the helicopter now");
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
        }
    }
}
