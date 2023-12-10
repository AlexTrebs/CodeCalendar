package codecalendar.util;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InputUtil {

    /**
     * Give a fileName, return a {@link List} of each of the lines in the file.
     * 
     * @param fileName a {@link String} of the file's name
     * @return a {@link List} of each of the lines in the file.
     */
    public static List<String> getFileFromResources(String fileName){
        log.info("Opening file: {}", fileName);
        URL url = Thread.currentThread().getContextClassLoader().getResource(fileName);
        if(url == null){

            log.error("File could not be found. Exiting app");
            System.exit(0);

        }
        try{

            Path path = Paths.get(url.toURI());
            return Files.readAllLines(path, StandardCharsets.UTF_8);

        } catch (Exception e){

            log.error("Error opening file due to: {}", e.getMessage());
            System.exit(0);

            return null;
        }
    }

    /**
     * Get the user input for a given output.
     * 
     * @param output the output that is displayed to user before input is recieved.
     * @return a {@link String} of the user input.
     */
    public static String getInput(String output){
        Scanner scannerObj = new Scanner(System.in);

        String input = "";
        log.info(output);
        try {
            input = JOptionPane.showInputDialog(output);
        } catch (Exception e) {
            log.warn("Inputs not found.");
            scannerObj.close();
            return getInput(output);
        }
        scannerObj.close();
        return input;
    }

    /**
     * Gets the user input string and converts it to a {@link Integer}.
     * 
     * @param output the output that is displayed to user before input is recieved.
     * @return the number that the user inputted.
     */
    public static int getValueInputs(String output){
        try {
            return Integer.valueOf(getInput(output));
        } catch (Exception e) {
            log.warn("Inputs incorrect type. Try again.");
            return getValueInputs(output);
        }
    }
}
