/**
 * Created by PEOPLE on 06.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        Car c1 = new Car("Ferrary", 200000d,"Cool red car.");

        Shop shop1 = new Shop("MagicShop");
        shop1.add(c1);
    }
}
