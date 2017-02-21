import java.util.ArrayList;

/**
 * Created by PEOPLE on 06.02.2017.
 */
public class Shop {
    public Shop(String name){
        this.name = name;
        products = new ArrayList<>();
    }

    private String name;
    private ArrayList<Product> products;

    public void add(Product some) {
        products.add(some);
    }

    public void printPriceOfAll() {
        System.out.println("\r\n--All prices--");
        for (int j = 0; j < products.size(); j++) {
            System.out.printf("%10s %-10s %10s %-10.2f %n",
                    "Name: ", products.get(j).getName(), "Price: ", products.get(j).getPrice());
        }
    }

    public void printGoodsInfo() {
        String info = "--GoodsInfo--\r\n";
        for (int i = 0; i < products.size(); i++) {
            info += products.get(i).toString() + "\r\n";
        }
        System.out.println(info);
    }

    public static void main(String[] args) {
        Shop shop1 = new Shop("MagicShop");

        shop1.add(new Car("Ferrary", 200000d));
        shop1.add(new Car("Ferrary1", 20000d));
        shop1.add(new Car("Ferrary2", 2000d));

        //shop1.add(new Computer("Asus", 3000.85d));
        //shop1.add(new Computer("Asus2", 1000.85d));

        shop1.add(new Horse("Nomad", 5000d));
        shop1.add(new Horse("Tramp", 10000d));

        shop1.add(new Phone("Nokia", 500d));
        shop1.add(new Phone("Meizu", 550d));
        shop1.add(new Phone("iPhone", 1100d));

        shop1.printGoodsInfo();
        shop1.printPriceOfAll();
    }
}
