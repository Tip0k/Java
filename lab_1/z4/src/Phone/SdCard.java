package Phone;

import java.util.ArrayList;

/**
 * Created by PEOPLE on 08.02.2017.
 */
public class SdCard {
    public SdCard() {
        this.Contacts = new ArrayList<>();
    }

    protected static final int MAX_CountOfContacts = 1000;
    protected ArrayList<Contact> Contacts;
}
