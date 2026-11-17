package Q2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;

public class MDFileReader {
    public static String read(String filePath)  {
        // TODO - Your Code Starts Here
        StringBuilder content = new StringBuilder(); //Allows you to actively edit a singlt string object

        //BufferedReader allows you to read one line at a time
        //Filereader opens the text file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            //Readline returns null at file end, returns "" for empty line
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator()); //readline doesnt maintain \n equivlents, so we append a new one.
            }
        } catch (IOException e) { //Handles errors, wraps the exceptioon because erros not delcared in methodology
            throw new UncheckedIOException("Could not read file: " + filePath, e);
        }
        return content.toString();
        // TODO - Your Code Ends Here
    }




}
