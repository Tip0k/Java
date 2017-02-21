/**
 * Created by PEOPLE on 09.02.2017.
 */
public abstract class Product {
    public Product(String name) {
        if(name.length() < 3) throw new Error("Name is too short.");
        else this.name = name;
    }

    public Product(Product product) {
        this.name = product.getName();
        this.className = product.getClassName();
    }

    private String name;
    protected String className;

    public String getName() {
        return this.name;
    }

    public String getClassName() {
        return className;
    }
}
