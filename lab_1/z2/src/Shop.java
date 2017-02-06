import java.util.ArrayList;

/**
 * Created by PEOPLE on 06.02.2017.
 */
public class Shop {
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

    public void add(Object some){
        try {
            if(some instanceof Car){
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
}
