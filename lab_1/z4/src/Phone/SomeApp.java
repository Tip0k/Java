package Phone;

/**
 * Created by PEOPLE on 08.02.2017.
 */
public class SomeApp implements App {
    private static final int POWER_CONSUMPTION = 50;
    private static final String NAME = "SomeApp";

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
        System.out.println("App \'" + NAME + "\' is running . . .");
        return true;
    }
}
