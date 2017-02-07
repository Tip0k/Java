/**
 * Created by PEOPLE on 06.02.2017.
 */
public class Computer {
    public Computer(String name, double price) {
        if (name.length() > 3) {
            if (price >= 0) {
                this.name = name;
                this.price = price;
                this.info = "NAAI";
            } else throw new Error("Price incorrect.");
        } else throw new Error("Name is too short.");
    }

    public Computer(String name, double price, String info){
        if(name.length() > 3) {
            if(price >= 0){
                this.name = name;
                this.price = price;
                this.info = info;
            } else throw new Error("Price incorrect.");
        } else throw new Error("Name is too short.");
    }

    private String name;
    private double price;
    private String info;

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
