package codecalendar.service.impl;

import java.util.List;

import codecalendar.model.QuestionValues;
import codecalendar.service.ChallengeService;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FirstChallengeService implements ChallengeService {

    @Override
    public int findAnswer() {
        List<String> inputFileContents = loadInputFile();

        QuestionValues values = getValues();

        return inputFileContents.stream().map(line -> getGamePossibility(line,values)).reduce(0, (a, b) -> a + b);
    }
}
