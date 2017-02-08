package Phone;

import java.util.ArrayList;

/**
 * Created by PEOPLE on 08.02.2017.
 */
public class Smartphone {
    public Smartphone(String name, Battery battery, SdCard sdCard) {
        this.name = name;
        this.battery = battery;
        this.sdCard = sdCard;
        installedApps = new ArrayList<>();

        Contacts = new Contacts();
        Phone = new Phone();
    }

    private String name;
    private SimCard sim1;
    private SimCard sim2;
    private SdCard sdCard;
    private Battery battery;
    private ArrayList<App> installedApps;
    private Contacts Contacts;
    private Phone Phone;

    public float getCurrentCharge() {
        return this.battery.getCurrentCharge();
    }

    public boolean toChargeOn(int percent) {
        if (percent <= 0) {
            return false;
        } else {
            battery.changeCurrentCharge((int) (percent * battery.getCapacity() / 100.0f));
            System.out.println("* Charge on " + percent + "% *");
            return true;
        }
    }

    public boolean insertSim(SimCard sim) {
        if (sim1 == null) {
            sim1 = sim;
            return true;
        } else if (sim2 == null) {
            sim2 = sim;
            return true;
        } else return false;
    }

    public boolean installApp(App app) {
        if (app != null) {
            installedApps.add(app);
            return true;
        } else {
            return false;
        }
    }

    public boolean unistallApp(String appName) {
        for(App temp : installedApps) {
            if(temp.getName().equals(appName)) {
                installedApps.remove(temp);
                System.out.println("App removed.");
                return true;
            }
        }
        return false;
    }

    public App useApp(String appName) {
        for (App tmp : installedApps) {
            if (tmp.getName() == appName) {
                if (!battery.changeCurrentCharge(-tmp.getPOWER_CONSUMPTION())) {
                    return null;
                } else {
                    return tmp;
                }
            }
        }
        return null;
    }

    public App useApp(int appIndex) {
        if (appIndex >= 0 && appIndex < installedApps.size()) {
            if (!battery.changeCurrentCharge(-installedApps.get(appIndex).getPOWER_CONSUMPTION())) {
                return null;
            } else {
                return installedApps.get(appIndex);
            }
        }
        return null;
    }

    public boolean addContact(Contact contact) {
        return Contacts.addContact(contact);
    }

    public boolean delContact(String contactName) {
        return Contacts.delContact(contactName);
    }

    public class Contacts {
        private static final int POWER_CONSUMPTION = 15;

        private boolean addContact(Contact contact) {
            if (sdCard.Contacts.size() < sdCard.MAX_CountOfContacts) {
                if (battery.changeCurrentCharge(-POWER_CONSUMPTION + 1)) {
                    sdCard.Contacts.add(contact);
                    System.out.println("Contact added!");
                    return true;
                } else {
                    System.out.println("Low battery!");
                    return false;
                }
            } else {
                System.out.println("Out of memory!");
                battery.changeCurrentCharge(-POWER_CONSUMPTION);
                return false;
            }
        }

        private boolean delContact(String contactName) {
            for (Contact temp : sdCard.Contacts) {
                if (temp.getName().equals(contactName)) {
                    if (!battery.changeCurrentCharge(-(POWER_CONSUMPTION + 5))) {
                        System.out.println("Low battery!");
                        return false;
                    }
                    battery.changeCurrentCharge(-(POWER_CONSUMPTION + 5));
                    sdCard.Contacts.remove(sdCard.Contacts.indexOf(temp));
                    System.out.println("Contact " + temp.getName() + " | " + temp.getNumber() + " removed!");
                    return true;
                }
            }
            battery.changeCurrentCharge(-POWER_CONSUMPTION);
            System.out.println("Contact doesn\'t exist.");
            return false;
        }
    }

    public boolean callFromContacts(String contactName, char sim1or2) {
        return Phone.callFromContacts(contactName, sim1or2);
    }

    public boolean callByNumder(String number, char sim1or2) {
        return Phone.callByNumber(number, sim1or2);
    }

    private class Phone {
        private static final int POWER_CONSUMPTION = 30;

        private boolean checkSim(char sim1or2) {
            boolean tmp = false;
            if (sim1or2 != '1' && sim1or2 != '2') {
                System.out.println("Wrong sim value!");
                tmp = true;
            } else if (sim1 == null && sim2 == null) {
                System.out.println("Insert sim in slot " + sim1or2);
                tmp = true;
            } else if (sim2 == null && sim1or2 == '2') {
                System.out.println("Insert sim in slot " + sim1or2);
                tmp = true;
            } else if (sim1 == null && sim1or2 == '1') {
                System.out.println("Insert sim in slot " + sim1or2);
                tmp = true;
            }
            return tmp;
        }

        private boolean callFromContacts(String contactName, char sim1or2) {
            boolean tmp = false;
            if (checkSim(sim1or2)) {
                battery.changeCurrentCharge(-POWER_CONSUMPTION / 10);
                return false;
            }

            Contact contact = new Contact();
            for (Contact temp : sdCard.Contacts) {
                if (temp.getName().equals(contactName)) {
                    tmp = true;
                    contact = temp;
                }
            }
            if (tmp) {
                if (!battery.changeCurrentCharge(-(POWER_CONSUMPTION + 5))) {
                    System.out.println("Low battery!");
                    return false;
                }
                System.out.println("[SIM"+sim1or2+"] Calling to " + contact.getName() + " | " + contact.getNumber() + " . . .");
                return true;
            } else {
                battery.changeCurrentCharge(-POWER_CONSUMPTION / 10);
                System.out.println("Contact doesn\'t exist.");
                return false;
            }
        }

        private boolean callByNumber(String number, char sim1or2) {
            boolean tmp = false;
            if (checkSim(sim1or2)) {
                battery.changeCurrentCharge(-POWER_CONSUMPTION / 10);
                return false;
            } else {
                if (!battery.changeCurrentCharge(-(POWER_CONSUMPTION + 5))) {
                    System.out.println("Low battery!");
                    return false;
                }
                System.out.println("[SIM"+sim1or2+"] Calling to " + number + " . . .");
                return true;
            }
        }
    }
}