package abstractClass;

/**
 * Created by PEOPLE on 07.02.2017.
 */
public class GazonKos extends Gear {
    public GazonKos() {
        super();
    }

    public GazonKos(String crash) {
        super(crash);
    }

    protected void setTIME_NEED_TO_FIX() {
        this.TIME_NEED_TO_FIX = 10;
    }
}
