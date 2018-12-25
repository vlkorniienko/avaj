import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import javax.imageio.IIOException;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Avaj {

    public static PrintWriter pw;
    public static void main(String[] args) {
        String line;
        int simulationCounter;
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

                    }
                }
            }
        } catch (FileNotFoundException openFileEx) {
            System.out.println("File not found");
        } catch (IOException IOexception) {
            System.out.println("Error to read file");
        } catch (NumberFormatException greaterThanIntex) {
            System.out.println("Number is greater than integer");
        }
        finally {
            pw.close();
        }
    }

    public static boolean testRestStrings(String aircraft) {
        Pattern p = Pattern.compile("^(Helicopter|JetPlane|Baloon)\\s")
        return true;
    }

    public static boolean testFirstString(String FirstLine) {
        Pattern p = Pattern.compile("^[0-9]+");
        Matcher m = p.matcher(FirstLine);
        System.out.println(m.matches());
        return m.matches();
    }
}

