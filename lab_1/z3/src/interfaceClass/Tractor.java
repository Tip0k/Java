package interfaceClass;

/**
 * Created by PEOPLE on 08.02.2017.
 */
public class Tractor implements Gear {
    public Tractor() {
        this.crash = "fine.";
        isCrashed = false;
    }

    public Tractor(String crash) {
        this.crash = crash;
        isCrashed = true;
    }

    private String crash;
    private boolean isCrashed;
    public static final int TIME_NEED_TO_FIX = 70;

    @Override
    public boolean getIsCrashed() {
        return isCrashed;
    }
    @Override
    public String getCrash() {
        return "It\'s " + crash;
    }
}
