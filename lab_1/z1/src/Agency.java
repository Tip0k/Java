import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by PEOPLE on 06.02.2017.
 */
public class Agency {
    public Agency(String name) {
        this.name = name;
        couples = new ArrayList<>();
        id = 1;
    }

    private static int id;
    private String name;
    private ArrayList<Couple> couples;

    protected boolean registerNewCouple(Person husband, Person wife) {
        if (husband != null && wife != null) {
            if (husband.getSex() == true && wife.getSex() == false) {
                couples.add(new Couple(husband, wife, this.id++));
                return true;
            } else return false;
        } else return false;
    }

    protected boolean divorceCouple(int id) {
        for (Couple i: couples) {
            if(i.getId() == id) {
                couples.remove(i);
                return true;
            }
        }
        return false;
    }

    protected void showCouples() {
        if(couples.size() > 0) System.out.println("--Registered couples--");
        else System.out.println("--no one--");
        for(Couple i : couples) {
            System.out.println(i.getId() + ": " + i.getHusband().getName() + " " + i.getWife().getName());
        }
    }

    public void run() {
        System.out.println("Welcome to " + this.name + " agency!");
        showCouples();
        System.out.println("Type [husband]#[wife] and press Enter to register new couple.");
        System.out.println("Type -[couple id] and press Enter to divorce couple.");

        Scanner sc = new Scanner(System.in);
        try {
            String tmp = sc.next();
            if (tmp.toCharArray()[0] == '-') {
                if(divorceCouple(Integer.parseInt(tmp)*(-1))) {
                    System.out.println("Divorced");
                } else {
                    System.out.println("Error");
                }
            } else {
                String[] pair = tmp.split("#", 2);
                if(pair.length < 2) throw new Error("Error");
                if(pair[0].length() < 3 || pair[1].length() < 3) throw new Error("Name is too short.");
                else if(registerNewCouple(new Person(pair[0], true), new Person(pair[1], false))){
                    System.out.println("Registered!");
                } else {
                    System.out.println("Error.");
                }
            }
        } catch (Error ex) {
            System.out.println(ex.getMessage());
        } finally {
            while (true) {
                System.out.println("Continue? [Y/N]");
                String temp = sc.next();
                if (temp.equals("Y") || temp.equals("y")) run();
                else if(temp.equals("N") || temp.equals("n")) return;
            }
        }
    }
}
