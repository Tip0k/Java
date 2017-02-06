/**
 * Created by PEOPLE on 06.02.2017.
 */
public class Couple{
    public Couple(Person husband, Person wife){
        this.husband = husband;
        this.wife = wife;
    }

    private Person husband;
    private Person wife;

    public Person getHusband() {
        return husband;
    }

    public Person getWife() {
        return wife;
    }
}
