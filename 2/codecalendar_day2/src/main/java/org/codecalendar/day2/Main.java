package org.codecalendar.day2;

import org.codecalendar.day2.solution.FirstChallenge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    static FirstChallenge firstChallenge;

    public static void main(String[] args) {
        log.error(args.toString());

        if(args.length >= 1){
            
            switch (args[1]) {
                case "1":
                    
                    log.info("The answer is: %d", firstChallenge.findAnswer());
                    break;
            
                default:
                    break;
            }

        }
    }
}