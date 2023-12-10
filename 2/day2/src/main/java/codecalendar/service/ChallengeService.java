package codecalendar.service;

import java.util.List;
import codecalendar.util.InputUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public interface ChallengeService {

    static String inputFileName = "input_file.txt";
    static Logger log = LoggerFactory.getLogger(ChallengeService.class);

    int findAnswer();

    /**
     * Loads file input_file.txt.
     * 
     * @return returns {@link List} of all the lines contained in the file.
     */
    default List<String> loadInputFile(){

        return InputUtil.getFileFromResources(inputFileName);

    }
}
