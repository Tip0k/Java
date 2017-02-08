package Phone;

/**
 * Created by PEOPLE on 08.02.2017.
 */
public class OneMoreApp implements App {
    private static final int POWER_CONSUMPTION = 80;
    private static final String NAME = "OneMoreApp";

    @Override
    public String getName() {
        return NAME;
    }
    @Override
    public int getPOWER_CONSUMPTION() {
        return POWER_CONSUMPTION;
    }
    @Override
    public boolean run() {
        System.out.println("App \'" + NAME + " is running :D");
        return true;
    }
}
