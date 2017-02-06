/**
 * Created by PEOPLE on 06.02.2017.
 */
public class Person{

    public Person(String name, boolean sex){
        this.sex = sex;

        if(name.length() < 3) {
            System.out.println("Name is too short.");
            if(sex == true) {
                this.name = "Tom";
            } else {
                this.name = "Janifer";
            }
        } else {
            this.name = name;
        }
    }

    private String name;
    private boolean sex;

    public boolean getSex() {
        return sex;
    }

    public String getName(){
        return name;
    }
}
