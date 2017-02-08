//import abstractClass.*;
import interfaceClass.*;

/**
 * Created by PEOPLE on 07.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        GazonKos x1 = new GazonKos("blade");
        Gear x2 = new GazonKos();
        Tractor t1 = new Tractor("Wheel");
        Gear t2 = new Tractor();

        System.out.println(x1.TIME_NEED_TO_FIX);
        System.out.println(t1.TIME_NEED_TO_FIX);
        /*
        Godynnyk g1 = new Godynnyk();
        Gear g2 = new Godynnyk("strelka");
        VantajAvto v1 = new VantajAvto();
        Gear v2 = new VantajAvto();

        System.out.println(v1.TIME_NEED_TO_FIX);
        System.out.println(g1.TIME_NEED_TO_FIX);
        */
        System.out.println(x1.getCrash());
        System.out.println(x1.getIsCrashed());

        System.out.println(t2.getCrash());
        System.out.println(t2.getIsCrashed());

        WorkShop opacha = new WorkShop();
        //opacha.tryRepairNext();
        opacha.addToFix(x1);
        opacha.addToFix(x2);
        opacha.addToFix(t1);
        opacha.addToFix(t2);
        /*
        opacha.addToFix(v1);
        opacha.addToFix(g1);
        opacha.addToFix(g2);
        opacha.addToFix(v2);
        */
        for (int i = 1; ; i++) {
            System.out.printf("Day %d: ", i);
            if(opacha.tryRepairNext()) continue;
            else break;
        }
    }
}
