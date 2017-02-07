package abstractClass;

/**
 * Created by PEOPLE on 07.02.2017.
 */
public class VantajAvto extends Gear {
    public VantajAvto() {
        super();
    }

    public VantajAvto(String crash) {
        super(crash);
    }
    protected void setTIME_NEED_TO_FIX() {
        this.TIME_NEED_TO_FIX = 90;
    }
}
