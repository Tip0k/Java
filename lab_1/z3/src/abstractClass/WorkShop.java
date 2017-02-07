package abstractClass;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by PEOPLE on 07.02.2017.
 */
public class WorkShop {
    public WorkShop() {
        crashedGears = new ArrayList<>();
    }

    private ArrayList<Gear> crashedGears;

    public void addToFix(Gear gear) {
        if(gear.getIsCrashed()) {
            crashedGears.add(gear);
        } else {
            System.out.println("Not crashed!");
        }
    }
    public boolean tryRepairNext() {
        if(crashedGears.size() <= 0) {
            System.out.println("There are nothing to repair!");
            return false;
        }
        if((new Random().nextInt(99) + 1) > 60) {
            System.out.println(crashedGears.get(0).getClass().getName() + " is fixed!");
            crashedGears.remove(0);
            return true;
        } else {
            System.out.println("We can\'t fix " + crashedGears.get(0).getClass().getName() + " now(");
            return true;
        }
    }
}
