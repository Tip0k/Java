package abstractClass;

/**
 * Created by PEOPLE on 07.02.2017.
 */
public class Tractor extends Gear {
    public Tractor() {
        super();
    }

    public Tractor(String crash) {
        super(crash);
    }

    protected void setTIME_NEED_TO_FIX() {
        this.TIME_NEED_TO_FIX = 70;
    }
}
