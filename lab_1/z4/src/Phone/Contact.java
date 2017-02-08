package Phone;

/**
 * Created by PEOPLE on 08.02.2017.
 */
public class Contact {
    public Contact() {
        this.name = new char[20];
        this.number = new char[13];
    }
    public Contact(String name, String number) {
        this.name = new char[20];
        this.number = new char[13];

        for (byte i = 0; i < ((name.length() >= 20) ? 20 : name.length()); i++) {
            this.name[i] = name.toCharArray()[i];
        }
        for (byte i = 0; i < ((number.length() >= 13) ? 13 : number.length()); i++) {
            this.number[i] = number.toCharArray()[i];
        }
    }

    private char[] name;
    private char[] number;

    public String getName() {
        String s = "";
        for(int i = 0; i < 20; i ++){
            if(name[i] == '\u0000') break;
            s+=name[i];
        }
        return s;
    }
    public String getNumber() {
        String s = "";
        for(int i = 0; i < 13; i ++){
            if(number[i] == '\u0000') break;
            s+=number[i];
        }
        return s;
    }
}
