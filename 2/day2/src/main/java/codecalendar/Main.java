package codecalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import codecalendar.service.impl.FirstChallengeService;
import codecalendar.service.impl.SecondChallengeService;
import codecalendar.util.InputUtil;

public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    private static String ANSWER_LOG = "The answer is: {}";

    public static void main(String[] args) {
        switch(args[0]) {
            case "1":
                FirstChallengeService firstChallengeService = new FirstChallengeService();
                log.info(ANSWER_LOG, firstChallengeService.findAnswer());
                break;

            case "2":
                SecondChallengeService secondChallengeService = new SecondChallengeService();
                log.info(ANSWER_LOG, secondChallengeService.findAnswer());
                break;
            default:
                break;
        }
        
        switch(InputUtil.getInput("Would you like to go again(y/n): ")) {
            case "y":
                main(args);
                break;
            case "n":
                System.exit(0);
            default:
                System.exit(0);
        }
    }
}