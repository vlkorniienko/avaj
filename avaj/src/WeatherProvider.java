public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private String[] weather;

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    private WeatherProvider() {
        this.weather[0] = "RAIN";
        this.weather[1] = "FOG";
        this.weather[2] = "SUN";
        this.weather[3] = "SNOW";
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int res = coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight();
        String res2 = Integer.toString(res);
        char res3 = res2.charAt(0);
        res = (int)res3;
        if(res > 3)
            return weather[0];
        else
            return weather[res];
    }
}
