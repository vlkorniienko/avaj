public class Ballon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    private String currentWeather;

    protected Ballon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Avaj.pw.println("Tower says: " + "Baloon#" + this.getName() + "(" + this.id + ") " + "registered to weather tower");
    }

    @Override
    public void updateConditions() {
        currentWeather = WeatherProvider.getProvider().getCurrentWeather(coordinates);
        if (currentWeather.equals("RAIN")) {
            Avaj.pw.println("Baloon#" + this.getName() + "(" + this.id + "):" + " It's rain now! AAAAAAAAAAaaaaaaaa!");
            this.coordinates.setHeight(this.coordinates.getHeight() - 5);
            if (this.coordinates.getHeight() < 1) {
                Avaj.pw.println("Baloon#" + this.getName() + "(" + this.id + ")" + "landing.");
                weatherTower.unregister(this);
                Avaj.pw.println("Tower says: " + "Baloon#" + this.getName() + "(" + this.id + ") " + "unregistered from weather tower");
            } else if (currentWeather.equals("SNOW")) {
                Avaj.pw.println("Baloon#" + this.getName() + "(" + this.id + "):" + " It's snow now! We all gonna die!");
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                if (this.coordinates.getHeight() < 1) {
                    Avaj.pw.println("Baloon#" + this.getName() + "(" + this.id + ")" + "landing.");
                    weatherTower.unregister(this);
                    Avaj.pw.println("Tower says: " + "Baloon#" + this.getName() + "(" + this.id + ") " + "unregistered from weather tower");
                }
            } else if (currentWeather.equals("SUN")) {
                Avaj.pw.println("Baloon#" + this.getName() + "(" + this.id + "):" + " It's sun now! I don't know what to do");
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                if (this.coordinates.getHeight() > 100)
                    this.coordinates.setHeight(100);
            } else if (currentWeather.equals("FOG")) {
                Avaj.pw.println("Baloon#" + this.getName() + "(" + this.id + "):" + " It's fog now! Let's jump from the helicopter now");
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                if (this.coordinates.getHeight() < 1) {
                    Avaj.pw.println("Baloon#" + this.getName() + "(" + this.id + ")" + "landing.");
                    weatherTower.unregister(this);
                    Avaj.pw.println("Tower says: " + "Baloon#" + this.getName() + "(" + this.id + ") " + "unregistered from weather tower");
                }
            }
        }
    }
}
