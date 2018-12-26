public class JetPlane extends Aircraft implements Flyable {
    WeatherTower weatherTower;
    String currentWeather;

    protected JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Avaj.pw.println("Tower says: " + "JetPlane#" + this.getName() + "(" + this.id + ") " + "registered to weather tower");
    }

    @Override
    public void updateConditions() {
        currentWeather = WeatherProvider.getProvider().getCurrentWeather(coordinates);
        if (currentWeather.equals("RAIN")) {
            Avaj.pw.println("JetPlane#" + this.getName() + "(" + this.id + "):" + " It's rain now! Allah Akbar!");
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
        }
        else if (currentWeather.equals("SNOW")) {
            Avaj.pw.println("JetPlane#" + this.getName() + "(" + this.id + "):" + " It's snow now! Snow in Africa in July!");
            this.coordinates.setHeight(this.coordinates.getHeight() - 7);
            if (this.coordinates.getHeight() < 1) {
                Avaj.pw.println("JetPlane#" + this.getName() + "(" + this.id + ")" + "landing.");
                weatherTower.unregister(this);
                Avaj.pw.println("Tower says: " + "JetPlane#" + this.getName() + "(" + this.id + ") " + "unregistered from weather tower");
            }
        }
        else if (currentWeather.equals("SUN")) {
            Avaj.pw.println("JetPlane#" + this.getName() + "(" + this.id + "):" + "It's sun now! Everybody hold on! We will land on the beach now and have a party");
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            if (this.coordinates.getHeight() > 100)
                this.coordinates.setHeight(100);
        }
        else if (currentWeather.equals("FOG")) {
            Avaj.pw.println("JetPlane#" + this.getName() + "(" + this.id + "):" + "It's fog now! Let's jump from the helicopter now");
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
        }
    }
}
