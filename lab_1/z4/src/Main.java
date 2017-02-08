import Phone.*;

/**
 * Created by PEOPLE on 08.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        Smartphone myPhone = new Smartphone("PRO 6", new Battery(1360), new SdCard());


        SimCard[] opa = new SimCard[]{
                new SimCard("life2;)",200.0d),
                new SimCard("life2;)",200.0d),
                new SimCard("life2;)",200.0d)
        };

        for(byte i = 0; i < 3; i++){
            if(myPhone.insertSim(opa[i])) {
                System.out.println("Сім-ка в телефоні )");
            } else {
                System.out.println("У телефоні вже дві сім-ки!");
            }
        }

        System.out.println("Result " + myPhone.addContact(new Contact("Tom1", "+380972065888")));
        System.out.println("Result " + myPhone.addContact(new Contact("Tom2", "+380972065888")));
        System.out.println("Result " + myPhone.addContact(new Contact("Tom3", "+380972065888")));
        System.out.println("Result " + myPhone.addContact(new Contact("Tom4", "+380972065888")));

        myPhone.toChargeOn(50);
        System.out.println("* The battery: " + myPhone.getCurrentCharge() + "% *");
        myPhone.toChargeOn(20);
        System.out.println("* The battery: " + myPhone.getCurrentCharge() + "% *");

        System.out.println("Result " + myPhone.addContact(new Contact("Tom1", "+380972065888")));
        System.out.println("Result " + myPhone.addContact(new Contact("Tom2", "+380972065888")));
        System.out.println("Result " + myPhone.addContact(new Contact("Tom3", "+380972065888")));
        System.out.println("* The battery: " + myPhone.getCurrentCharge() + "% *");

        System.out.println("Result " + myPhone.installApp(new SomeApp()));
        System.out.println("Result " + myPhone.installApp(new OneMoreApp()));
        System.out.println("* The battery: " + myPhone.getCurrentCharge() + "% *");
        myPhone.toChargeOn(600);
        System.out.println("* The battery: " + myPhone.getCurrentCharge() + "% *");
        System.out.println("Result " + myPhone.useApp(0).run());
        System.out.println("Result " + myPhone.useApp(1).run());
        System.out.println("* The battery: " + myPhone.getCurrentCharge() + "% *");
        System.out.println("Result " + myPhone.useApp("SomeApp").run());

        System.out.println(myPhone.callFromContacts("Tom3",'1'));
        System.out.println(myPhone.callByNumder("0976265875",'1'));
        System.out.println(myPhone.callFromContacts("Tom3",'2'));
        System.out.println(myPhone.delContact("Tom1"));
        System.out.println("* The battery: " + myPhone.getCurrentCharge() + "% *");
        System.out.println(myPhone.callFromContacts("Tom3",'4'));
        System.out.println(myPhone.delContact("Tom112"));
        System.out.println("* The battery: " + myPhone.getCurrentCharge() + "% *");

        System.out.println(myPhone.unistallApp("SomeApp"));
        //System.out.println("Result " + myPhone.useApp("SomeApp").run()); - Error, бо видалили
    }
}
