package codecalendar.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import codecalendar.model.QuestionValues;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LineUtil {
    

    public static String getColour(String s){

        return s.replaceAll("[0-9,]", "").strip();

    }

    public static int getNumber(String s){

        return Integer.parseInt(s.replaceAll("[^0-9]", ""));

    }

    public static Map<String,Integer> parseRound(String round){

        return Stream.of(round.split(",")).collect(Collectors.toMap(item -> getColour(item), item -> getNumber(item)));

    }

    public static List<Map<String,Integer>> getValuesFromGame(String game){

        return Stream.of(game.split(": ")[1].split(";")).map((round) -> parseRound(round)).collect(Collectors.toList());

    }

    public static int getGameNumber(String game){

        return Integer.parseInt(game.split(": ")[0].replaceAll("[^0-9]", ""));

    }

    public static boolean checkRoundAndKey(String key, Map<String, Integer> round, Integer value){

        return round.containsKey(key) && round.get(key) > value;

    }

    public static boolean isRoundPossible(Map<String, Integer> round, QuestionValues values){
        log.info(round.toString());
        if(checkRoundAndKey("red",round,values.getNumberOfRed()) || 
           checkRoundAndKey("blue",round,values.getNumberOfBlue())|| 
           checkRoundAndKey("green",round,values.getNumberOfGreen())
        ){
            return false;
        }
        else{
            return true;
        }
    }
}
