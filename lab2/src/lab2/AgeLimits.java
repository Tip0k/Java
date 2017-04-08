package lab2;

/**
 *
 * @author PEOPLE
 */
public class AgeLimits {

    private int min;
    private int max;

    public AgeLimits(int min, int max) {
        if (min < 0 || min > max) {
            throw new IllegalArgumentException();
        }
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    @Override
    public String toString() {
        if (min == max) {
            return min + "+";
        }
        return min + "-" + max;
    }

    public static String convertToString(AgeLimits ageLimits) {
        return ageLimits.getMin() + "-" + ageLimits.getMax();
    }

    public static AgeLimits convertToAgeLimits(String ageLimitsStr) {
        String[] tmp = ageLimitsStr.split("-");
        return new AgeLimits(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        AgeLimits x = (AgeLimits) obj;
        if (x.min == this.min && x.max == this.max) {
            return true;
        } else {
            return false;
        }
    }
}
