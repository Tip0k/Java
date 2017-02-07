package abstractClass;

/**
 * Created by PEOPLE on 07.02.2017.
 */
public abstract class Gear {
    public Gear() {
        this.crash = "fine.";
        isCrashed = false;
        setTIME_NEED_TO_FIX();
    }

    public Gear(String crash) {
        this.crash = crash;
        isCrashed = true;
        setTIME_NEED_TO_FIX();
    }

    private String crash;
    private boolean isCrashed;
    public int TIME_NEED_TO_FIX;

    abstract protected void setTIME_NEED_TO_FIX();

    public boolean getIsCrashed(){
        return isCrashed;
    }
    public String getCrash(){
        return "It\'s " + crash;
    }
}
