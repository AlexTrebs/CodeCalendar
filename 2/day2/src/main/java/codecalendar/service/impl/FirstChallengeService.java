package codecalendar.service.impl;

import java.util.List;
import java.util.Map;
import codecalendar.model.QuestionValues;
import codecalendar.service.ChallengeService;
import codecalendar.util.LineUtil;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FirstChallengeService implements ChallengeService {

    /**
     * Returns the total of the  numbers where given the inputs the games were possible.
     */
    @Override
    public int findAnswer() {
        List<String> inputFileContents = loadInputFile();

        QuestionValues values = getValues();

        return inputFileContents.stream().map(line -> 
            getGamePossibility(line,values)).reduce(0, (a, b) -> a + b);
    }

    
    /**
     * Check if key exists in Map and that the map value for that key is larger than the expected value.
     * 
     * @param key the key that the respective map value is stored in.
     * @param round the round in the game that is to be checked.
     * @param value the value that the map value is compared against.
     * @return whether the conditions are true.
     */
    public static boolean checkRoundAndKey(String key, Map<String, Integer> round, Integer value){

        return round.containsKey(key) && round.get(key) > value;

    }

    /**
     * Check if round is possible given the inputs
     * 
     * @param round values of a given round in a game.
     * @param values values that are revealed at the end of the game.
     * @return if the round is possible.
     */
    private boolean isRoundPossible(Map<String, Integer> round, QuestionValues values){
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

    /**
     * Gets whether the game could have been possible given the inputs.
     * 
     * @param line a {@link String} with the game outputs.
     * @param values a {@link QuestionValues} which include the concluded game values.
     * @return the game number if it was possibe given the values.
     */
    private int getGamePossibility(String line, QuestionValues values){

        List<Map<String, Integer>> total = LineUtil.getValuesFromGame(line);

        for (Map<String, Integer> round: total){
            if(!isRoundPossible(round, values)){

                return 0;

            }
        }
            
        return LineUtil.getGameNumber(line);

    }

    /**
     * Gets the user submitted values that the games are checked against.
     *  
     * @return a {@link QuestionValues} object that contain the expected number of balls.
     */
    private QuestionValues getValues(){

        return new QuestionValues.Builder().getInputs().build();

    }
}
