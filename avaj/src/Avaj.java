import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Avaj {

    public static PrintWriter pw;
    public static void main(String[] args) {
        String line;
        AircraftFactory aircraftFactory = new AircraftFactory();
        WeatherTower weatherTower = new WeatherTower();
        int simulationCounter = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("scenario.txt"));
            FileWriter fileWriter = new FileWriter("simulation.txt");
            pw = new PrintWriter(fileWriter);
            int counter = 1;
            while ((line = reader.readLine()) != null) {
                if (counter == 1) {
                    if (testFirstString(line)) {
                        simulationCounter = Integer.parseInt(line);
                        System.out.println(simulationCounter);
                        counter++;
                    } else {
                        System.out.println("Wrong string with number");
                        System.exit(0);
                    }
                }
                else {
                    if (testRestStrings(line)) {
                        String[] initialAircraft = line.split(" ");
                        int longitude = Integer.parseInt(initialAircraft[2]);
                        int latitude = Integer.parseInt(initialAircraft[3]);
                        int height = Integer.parseInt(initialAircraft[4]);
                        aircraftFactory.newAircraft(
                                initialAircraft[0],
                                initialAircraft[1],
                                longitude,
                                latitude,
                                height).registerTower(weatherTower);
                    }
                }
            }
            WeatherProvider weatherProvider = WeatherProvider.getProvider();
            while (simulationCounter > 0) {
                weatherTower.conditionsChanged();
                simulationCounter--;
            }
        } catch (FileNotFoundException openFileEx) {
            System.out.println("File not found");
            return ;
        } catch (IOException IOexception) {
            System.out.println("Error to read file");
            return ;
        } catch (NumberFormatException gr) {
            System.out.println(gr.getMessage());
            return ;
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        finally {
            pw.close();
        }
    }

    public static boolean testRestStrings(String aircraft) {
        Pattern p = Pattern.compile("^(Helicopter|JetPlane|Baloon)\\s(H|J|B)[0-9223372036854775807]\\s[0-9223372036854775807]\\s[0-9223372036854775807]\\s[0-9223372036854775807]$");
        Matcher m = p.matcher(aircraft);
        System.out.println(m.matches());
        return m.matches();
    }

    public static boolean testFirstString(String FirstLine) {
        Pattern p = Pattern.compile("^[0-9]+");
        Matcher m = p.matcher(FirstLine);
        System.out.println(m.matches());
        return m.matches();
    }
}

