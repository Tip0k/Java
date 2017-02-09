import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by PEOPLE on 09.02.2017.
 */
public class Shop {
    public Shop(String name) {
        if(name.length() < 3) throw new Error("Name is too short.");
        else this.name = name;
        goods = new ArrayList<>();
        reserved = new ArrayList<>();
    }

    private String name;
    private ArrayList<Product> goods;
    private ArrayList<ReserveProduct> reserved;

    public void doOrder(){
        Order x = new Order();
        x.run(this);
    }

    //inner classes
    //
    private class ReserveProduct extends Product {
        private ReserveProduct(Product product, String userName) {
            super(product);
            this.userName = userName;
        }

        private String userName;
    }

    private class Kitchen extends Product{
        private Kitchen(String name) {
            super(name);
            className = "Kitchen";
        }
    }

    private class Bedroom extends Product{
        private Bedroom(String name) {
            super(name);
            className = "Bedroom";
        }
    }

    private class LivingRoom extends Product{
        private LivingRoom(String name) {
            super(name);
            className = "Living room";
        }
    }

    private class Order {
        private void run(Shop shop) {
            ArrayList<String> goodsNames = new ArrayList<>();
            for (int i = 0; i < goods.size(); i++) {
                if (!goodsNames.contains(goods.get(i).getClassName())) goodsNames.add(goods.get(i).getClassName());
            }

            printMainView(goodsNames, shop);

            Scanner sc = new Scanner(System.in);
            int err = 5;
            while (true) {
                if (err-- == 0) break;
                if (sc.hasNextInt()) {
                    int tmp = sc.nextInt();
                    if (tmp <= goodsNames.size()) {
                        err = tmp;
                    } else {
                        System.out.println("Incorrect input! Try again [" + (err + 1) + "]");
                    }
                } else if (sc.next().equals("admin")) {
                    addProducts();
                    for (int i = 0; i < goods.size(); i++) {
                        if (!goodsNames.contains(goods.get(i).getClassName())) {
                            goodsNames.add(goods.get(i).getClassName());
                        }
                    }
                    System.out.println("\n\n\n\n");
                    printMainView(goodsNames, shop);
                    err = 5;
                    continue;
                }

                while (true) {
                    if (err == 0) break;

                    ArrayList<Product> shown = show(goodsNames.get(err - 1), shop);
                    if (shown.size() < 1) {
                        System.out.println("Sorry, but these products aren\'t available");
                        break;
                    } else {
                        System.out.println("Choose products to reserve by typing them with comma (for example: 1,3,6)");
                        System.out.println("Previous menu - 0");
                        String[] reserve = sc.next().split(",");

                        if (Integer.parseInt(reserve[0]) == 0) {
                            lolClearConsole();
                            printMainView(goodsNames, shop);
                            err = -1;
                            break;
                        }

                        ArrayList<Product> reservedGoods = new ArrayList<>();
                        for (int i = 0; i < reserve.length; i++) {
                            int tmp = Integer.parseInt(reserve[i]);
                            if (!(tmp < 1 || tmp > shown.size())) {
                                reservedGoods.add(shown.get(tmp - 1));
                            }
                        }
                        if (reservedGoods.size() > 0) {
                            System.out.print("Products: ");
                            for (int i = 0; i < reservedGoods.size(); i++)
                                System.out.print(reservedGoods.get(i).getName() + " ");
                            System.out.println(" reserved, please enter you name to confirm");
                            String tmp = sc.next();
                            if (tmp.length() < 3) {
                                System.out.println("Incorrect input! Bye :(");
                                break;
                            } else {
                                if (addToReserve(reservedGoods, tmp, shop)) {
                                    System.out.println("RESERVED ;)");
                                    break;
                                } else {
                                    System.out.println("ERROR");
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Incorrect input! Bye :(");
                            break;
                        }
                    }
                }
                if (err == -1) {
                    err = 5;
                    continue;
                }
                else break;
            }
            System.out.println("Press any key . . .");
            sc.next();
        }

        private void printMainView(ArrayList<String> goodsNames, Shop shop) {
            System.out.println("Welcome to " + shop.name + " ;)");
            System.out.println("----------------------------------");
            System.out.println("Press:");

            for (int i = 1; i < goodsNames.size() + 1; i++) {
                System.out.println("       " + i + " view " + goodsNames.get(i - 1) + "s");
            }

            System.out.println("       0 exit");
            System.out.println("----------------------------------");
        }

        private void lolClearConsole() {
            for (int i = 0; i < 100; i++) System.out.println();
        }

        private void addProducts() {
            goods.add(new Kitchen("Стілець"));
            goods.add(new Kitchen("Стіл"));
            goods.add(new Kitchen("Крісло"));
            goods.add(new Bedroom("«Крижопіль»"));
            goods.add(new LivingRoom("«Вітання із Жмеринки»"));
            goods.add(new Kitchen("Стілець1"));
            goods.add(new Kitchen("Стіл2"));
            goods.add(new Kitchen("Крісло3"));
            goods.add(new Bedroom("«Крижопіль»4"));
            goods.add(new LivingRoom("«Вітання із Жмеринки»5"));
            goods.add(new Kitchen("Стілець6"));
            goods.add(new Kitchen("Стіл7"));
            goods.add(new Kitchen("Крісло8"));
            goods.add(new Bedroom("«Крижопіль»9"));
            goods.add(new LivingRoom("«Вітання із Жмеринки»10"));

            System.out.println("Filling shop «" + name + "» . . .");
        }

        private ArrayList<Product> show(String product, Shop shop) {
            System.out.println("----------------------------------");

            ArrayList<Product> shown = new ArrayList<>(0);
            int id = 1;

            for (int i = 0; i < shop.goods.size(); i++) {
                    if(shop.goods.get(i).getClassName().equals(product)) {
                        System.out.println(id + ". " + shop.goods.get(i).getName());
                        shown.add(shop.goods.get(i));
                        id++;
                    }
            }
            System.out.println("----------------------------------");
            return shown;
        }

        private boolean addToReserve(ArrayList<Product> reservedGoods, String tmp, Shop shop) {
            try {
                for (int i = 0; i < reservedGoods.size(); i++) {
                    shop.reserved.add(new ReserveProduct(reservedGoods.get(i), tmp));
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }
}
