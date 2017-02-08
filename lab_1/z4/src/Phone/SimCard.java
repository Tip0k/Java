package Phone;

/**
 * Created by PEOPLE on 08.02.2017.
 */
public class SimCard {
    public SimCard(String operator, double frequency) {
        if(operator.length() < 3) throw new Error("Operator name is too short.");
        else if(frequency < 0) throw new Error("Frequency can\'t be less than zero.");
        else {
            this.operator = operator;
            this.frequency = frequency;
        }
    }

    private String operator;
    private double frequency;
}
