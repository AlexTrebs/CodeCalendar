package org.codecalendar.day2.solution.util;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtil {
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
}
