package Phone;

/**
 * Created by PEOPLE on 08.02.2017.
 */
public class Battery {
    public Battery(int capacity) {
        if (capacity < 0) throw new Error("Capacity can\'t be less than zero.");
        else {
            this.capacity = capacity;
        }
    }

    private int capacity; //одиниці виміру - mAh
    private float currentCharge;

    public int getCapacity() {
        return capacity;
    }

    public float getCurrentCharge() {
        return currentCharge;
    }

    public boolean changeCurrentCharge(int chargeDifference) {
        if ((int)(currentCharge + chargeDifference/(float)capacity*100) > 100) {
            currentCharge = 100.0f;
            return true;
        } else if((currentCharge + chargeDifference/(float)capacity)*100 < 0) {
            return false;
        } else {
            currentCharge += chargeDifference/(float)capacity * 100;
            return true;
        }
    }
}
