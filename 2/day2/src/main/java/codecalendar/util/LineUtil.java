package codecalendar.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineUtil {
    
    /**
     * Get the colour of the balls in the {@link String} by only keeping the lower-case alphabet letters.
     * 
     * @param s the values for a coloured ball and number of them picked in a round.
     * @return the colour of the balls.
     */
    public static String getColour(String s){

        return s.replaceAll("[^a-z]", "");

    }

    /**
     * Remove everything other than numbers in a string.
     * 
     * @param s the values for a coloured ball and number of them picked in a round.
     * @return the number of balls picked.
     */
    public static int getNumber(String s){

        return Integer.parseInt(s.replaceAll("[^0-9]", ""));

    }

    /**
     * Separates all the rounds into a map of each colour, and the number of balls there
     * are for that given colour.
     * 
     * @param round the values for a given round.
     * @return a round separated into each coloured ball picked and how many of each.
     */
    public static Map<String,Integer> parseRound(String round){

        return Stream.of(round.split(",")).collect(Collectors.toMap(item -> getColour(item), item -> getNumber(item)));

    }

    /**
     * Get all the values separated by round and colour for each game.
     * 
     * @param game the values combined for each game.
     * @return the values separated by round and colour for each game.
     */
    public static List<Map<String,Integer>> getValuesFromGame(String game){

        return Stream.of(game.split(": ")[1].split(";")).map((round) -> parseRound(round)).collect(Collectors.toList());

    }

    /**
     * Get the game number given the given game string.
     * 
     * @param game the values of the game.
     * @return the game number.
     */
    public static int getGameNumber(String game){

        return Integer.parseInt(game.split(": ")[0].replaceAll("[^0-9]", ""));

    }

}
