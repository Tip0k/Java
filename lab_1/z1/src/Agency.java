import java.util.Random;

/**
 * Created by PEOPLE on 06.02.2017.
 */
public class Agency {
    public static void main(String[] args) {

        Person[] Persons = new Person[]{
                new Person("Tom1", true),
                new Person("Tom2", true),
                new Person("Tom3", true),
                new Person("Tom4", true),
                new Person("Tom5", true),

                new Person("Janifer1", false),
                new Person("Janifer2", false),
                new Person("Janifer3", false),
                new Person("Janifer4", false),
                new Person("Janifer5", false),
                new Person("Janifer6", false)
        };

        int CountOfPairs = 0;
        for (int i = 0; i < Persons.length; i++) {
            if (Persons[i].getSex() == true) CountOfPairs++;
        }

        Random opa = new Random();
        Couple[] Couples = new Couple[CountOfPairs];
        String[] temp = new String[CountOfPairs * 2];

        for (int i = 0; i < CountOfPairs; i++) {

            int hus = 0, wi = 0;

            for (int j = 0; ; j++) {
                hus = opa.nextInt(Persons.length);
                if (Persons[hus].getSex() == true) {
                    for (int k = 0; k < CountOfPairs * 2; k++) {
                        if (temp[k] == Persons[hus].getName()) {
                            hus = -1;
                            break;
                        }
                    }
                    if (hus == -1) continue;
                    else break;
                }
            }

            for (int j = 0; ; j++) {
                wi = opa.nextInt(Persons.length);
                if (Persons[wi].getSex() == false) {
                    for (int k = 0; k < CountOfPairs * 2; k++) {
                        if (temp[k] == Persons[wi].getName()) {
                            wi = -1;
                            break;
                        }
                    }
                    if (wi == -1) continue;
                    else break;
                }
            }

            temp[temp.length - i - 1] = Persons[hus].getName();
            temp[temp.length - CountOfPairs - i - 1] = Persons[wi].getName();
            Couples[i] = new Couple(Persons[hus], Persons[wi]);

            System.out.println(Couples[i].getHusband().getName() + " " + Couples[i].getWife().getName() + "\r\n");
        }
    }
}
