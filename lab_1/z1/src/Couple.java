/**
 * Created by PEOPLE on 06.02.2017.
 */
public class Couple{
    public Couple(Person husband, Person wife, int id) {
        this.husband = husband;
        this.wife = wife;
        this.id = id;
    }

    private Person husband;
    private Person wife;
    private int id;

    public Person getHusband() {
        return husband;
    }

    public Person getWife() {
        return wife;
    }

    public int getId() { return id; }
}
