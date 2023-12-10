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
    public static List<String> getFileFromResources(String fileString){
        log.info("Opening file: {}", fileString);
        URL url = Thread.currentThread().getContextClassLoader().getResource(fileString);
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

    public static String getInput(String output){

        Scanner scannerObj = new Scanner(System.in);

        String input = "";
        log.info(output);
        try {
            input = JOptionPane.showInputDialog(output);
        } catch (Exception e) {
            log.warn("Inputs not found. {}", e);
        }
        scannerObj.close();
        return input;

    }

    public static int getValueInputs(String output){
        int input = 0;

        try {
            input = Integer.valueOf(getValueInputs(output));
        } catch (Exception e) {
            log.warn("Inputs at incorrect value. {}", e);
        }

        return input;
    }
}
