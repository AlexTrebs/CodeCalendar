package codecalendar.service.impl;

import java.util.List;
import java.util.Map;

import codecalendar.service.ChallengeService;
import codecalendar.util.LineUtil;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SecondChallengeService implements ChallengeService {

    private static List<String> LIST_OF_COLOURS = List.of("red", "blue", "green");

    /**
     * Returns the sum of the multiplication of the least possible number of each coloured balls in a game. 
     */
    @Override
    public int findAnswer() {
        List<String> inputFileContents = loadInputFile();

        return inputFileContents.stream().map(line -> 
            findMinimumMultipliedNumberInGame(line)).reduce(0, (a, b) -> a + b);
    }

    /**
     * Find the mininimum number of each coloured ball possible in a game multiplied.
     * 
     * @param line a {@link String} with the game values in.
     * @return the mininimum number of each coloured ball possible in a game multiplied.
     */
    public int findMinimumMultipliedNumberInGame(String game){

        List<Map<String, Integer>> gameValues = LineUtil.getValuesFromGame(game);
        
        return LIST_OF_COLOURS.stream().map(colour -> 
            getMaxValue(gameValues, colour)).reduce(1, (a, b) -> a * b);
    }

    /**
     * Get the largest value for a given key in the {@link List} of {@link Map} objects.
     * 
     * @param gameValues values for each round in the given game.
     * @param key the {@link Map} key for the given coloured ball.
     * @return the largest value for the given key.
     */
    public int getMaxValue (List<Map<String, Integer>> gameValues, String key){

        int largestNumber = 0;

        for(Map<String, Integer> round: gameValues){
            if(round.containsKey(key) && round.get(key) > largestNumber){

                largestNumber = round.get(key);

            }
        }

        return largestNumber;
    }
}
