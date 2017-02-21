/**
 * Created by PEOPLE on 06.02.2017.
 */
public class Phone implements Product {
    public Phone(String name, double price) {
    if (name.length() > 3) {
        if (price >= 0) {
            this.name = name;
            this.price = price;
        } else throw new Error("Price incorrect.");
    } else throw new Error("Name is too short.");
}

    private String name;
    private double price;

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "class: " + getClass().getName() + ", name: " + getName() + ", price: " + getPrice();
    }
}
