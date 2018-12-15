import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Avaj {

    public static void main(String[] args) {
        String line;
        int simulationCounter;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("scenario.txt"));
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
//                    if (testRestStrings(line)) {
//
//                    }
                }
            }
        } catch (FileNotFoundException openFileEx) {
            System.out.println("File not found");
        } catch (IOException IOexception) {
            System.out.println("Error to read file");
        } catch (NumberFormatException greaterThanIntex) {
            System.out.println("Number is greater than integer");
        }
    }

    public static boolean testFirstString(String FirstLine) {
        Pattern p = Pattern.compile("^[0-9]+");
        Matcher m = p.matcher(FirstLine);
        System.out.println(m.matches());
        return m.matches();
    }
}

