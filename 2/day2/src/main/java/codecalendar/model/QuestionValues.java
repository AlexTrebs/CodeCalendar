package codecalendar.model;

import codecalendar.util.InputUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class QuestionValues {
    
    private int numberOfRed;

    private int numberOfBlue;

    private int numberOfGreen;

    @NoArgsConstructor
    public static class Builder {

        private int numberOfRed;

        private int numberOfBlue;

        private int numberOfGreen;

        /**
         * Gets user inputs for the game values.
         * 
         * @return the {@link Builder} object for a {@link QuestionValues}.
         */
        public Builder getInputs(){

            this.numberOfRed = InputUtil.getValueInputs("Enter number of red:");
            this.numberOfBlue = InputUtil.getValueInputs("Enter number of blue:");            
            this.numberOfGreen = InputUtil.getValueInputs("Enter number of green:");

            return this;

        }
        
        public QuestionValues build(){

            return new QuestionValues(numberOfRed, numberOfBlue, numberOfGreen);

        }
    }
}
