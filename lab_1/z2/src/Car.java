/**
 * Created by PEOPLE on 06.02.2017.
 */
public class Car {
    public Car(String name, double price, String info){
        if(name.length() > 3) {
            if(price > 0){
                this.name = name;
                this.price = price;
                if(info != "") this.info = info;
                else info = "NAAI";
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
