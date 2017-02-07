import java.util.ArrayList;
import java.util.List;

/**
 * Created by PEOPLE on 06.02.2017.
 */
public class Shop implements PrintPrice {
    @Override
    public void printPriceOfAll() {
        System.out.println("\r\nPrice of Cars");
        for (int j = 0; j < Cars.size(); j++) {
            System.out.printf("%10s %-10s %10s %-10.2f %n",
                    "Name: ", Cars.get(j).getName(),"Price: ",Cars.get(j).getPrice());
        }
        System.out.println("\r\nPrice of Computers");
        for (int j = 0; j < Computers.size(); j++) {
            System.out.printf("%10s %-10s %10s %-10.2f %n",
                    "Name: ", Computers.get(j).getName(),"Price: ",Computers.get(j).getPrice());
        }
        System.out.println("\r\nPrice of Horses");
        for (int j = 0; j < Horses.size(); j++) {
            System.out.printf("%10s %-10s %10s %-10.2f %n",
                    "Name: ", Horses.get(j).getName(),"Price: ",Horses.get(j).getPrice());
        }
        System.out.println("\r\nPrice of Phones");
        for (int j = 0; j < Phones.size(); j++) {
            System.out.printf("%10s %-10s %10s %-10.2f %n",
                    "Name: ", Phones.get(j).getName(),"Price: ",Phones.get(j).getPrice());
        }
    }

    public Shop(String name){
        this.name = name;
        Cars = new ArrayList<Car>();
        Computers = new ArrayList<Computer>();
        Horses = new ArrayList<Horse>();
        Phones = new ArrayList<Phone>();
    }

    private String name;
    private ArrayList<Car> Cars;
    private ArrayList<Computer> Computers;
    private ArrayList<Horse> Horses;
    private ArrayList<Phone> Phones;

    public void add(Object some) {
        try {
            if(some instanceof Car) {
                Cars.add((Car)some);
            } else if(some instanceof Computer) {
                Computers.add((Computer)some);
            } else if(some instanceof Horse) {
                Horses.add((Horse)some);
            } else if(some instanceof Phone){
                Phones.add((Phone)some);
            }
        } catch (Exception e) {
            return;
        }
    }

    public void printGoodsInfo() {

    }

    public static void main(String[] args) {
        Shop shop1 = new Shop("MagicShop");

        shop1.add(new Car("Ferrary", 200000d,"Cool red car."));
        shop1.add(new Car("Ferrary1", 20000d));
        shop1.add(new Car("Ferrary2", 2000d,"Cool black car."));

        shop1.add(new Computer("Asus", 3000.85d,"Norm comp."));
        shop1.add(new Computer("Asus2", 1000.85d));

        shop1.add(new Horse("Nomad", 5000d));
        shop1.add(new Horse("Tramp", 10000d));

        shop1.add(new Phone("Nokia", 500d));
        shop1.add(new Phone("Meizu", 550d));
        shop1.add(new Phone("iPhone", 1100d));

        shop1.printPriceOfAll();
    }
}
