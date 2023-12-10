package codecalendar.service;

import java.util.List;
import java.util.Map;

import codecalendar.util.InputUtil;
import codecalendar.util.LineUtil;
import codecalendar.model.QuestionValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public interface ChallengeService {

    static String inputFileName = "input_file.txt";
    static Logger log = LoggerFactory.getLogger(ChallengeService.class);

    int findAnswer();

    default List<String> loadInputFile(){

        return InputUtil.getFileFromResources(inputFileName);

    }

    default int getGamePossibility(String line, QuestionValues values){

        List<Map<String, Integer>> total = LineUtil.getValuesFromGame(line);

        for (Map<String, Integer> round: total){
            if(!LineUtil.isRoundPossible(round, values)){

                return 0;

            }
        }
            
        return LineUtil.getGameNumber(line);

    }

    default QuestionValues getValues(){

        return new QuestionValues.Builder().getInputs().build();

    }
}
