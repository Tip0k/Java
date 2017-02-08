package interfaceClass;

/**
 * Created by PEOPLE on 08.02.2017.
 */
public class GazonKos implements Gear {
    public GazonKos() {
        this.crash = "fine.";
        isCrashed = false;
    }

    public GazonKos(String crash) {
        this.crash = crash;
        isCrashed = true;
    }

    private String crash;
    private boolean isCrashed;
    public static final int TIME_NEED_TO_FIX = 10;

    @Override
    public boolean getIsCrashed() {
        return isCrashed;
    }
    @Override
    public String getCrash() {
        return "It\'s " + crash;
    }
}
