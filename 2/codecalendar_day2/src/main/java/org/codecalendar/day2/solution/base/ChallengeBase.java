package org.codecalendar.day2.solution.base;

import java.util.List;

import org.codecalendar.day2.solution.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public interface ChallengeBase {

    static String inputFileName = "input_file.txt";
    static Logger log = LoggerFactory.getLogger(ChallengeBase.class);

    int findAnswer();

    default List<String> loadInputFile(){

        return FileUtil.getFileFromResources(inputFileName);

    }

}
