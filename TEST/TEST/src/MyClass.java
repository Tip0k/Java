/**
 * Created by PEOPLE on 21.12.2016.
 */
public class MyClass {

    private class Person{

        public Person(){

        }

        public Person(String name, boolean sex){
            this.sex = sex;

            if(name.length() < 3) {
                System.out.println("Name is too short.");
                if(sex == true) {
                    this.name = "Tom";
                } else {
                    this.name = "Janifer";
                }
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

    private class Couple{

    }
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
    }
}
