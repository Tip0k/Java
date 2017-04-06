/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author PEOPLE
 */
public class Toy {
    private final String name;
    private final double price;
    private final AgeLimits ageLimits;
    private final String attribute;
    private final String pictureURL;
    
    public Toy (String name, double price, AgeLimits ageLimits, String attribute, String pictureURL) {
        if(name.length() > 3) {
            this.name = name; 
        } else {
            throw new IllegalArgumentException();
        }
        if(price >= 0.0d) {
            this.price = price;
        } else {
            throw new IllegalArgumentException();
        }
        this.ageLimits = ageLimits;
        this.attribute = attribute;
        this.pictureURL = pictureURL;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public AgeLimits getAgeLimits() {
        return ageLimits;
    }
    
    public String getAttribute() {
        return attribute;
    }
    
    public String getPictureURL() {
        return pictureURL;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    public static Toy convertToToy(String someToyStr) {
        String[] tmp = someToyStr.split(",");
        return new Toy(tmp[0], Double.parseDouble(tmp[1]), 
                AgeLimits.convertToAgeLimits(tmp[2]), tmp[3], tmp[4]);
    }
    
    public static String convertToString(Toy someToy) {
        return someToy.getName() + "," + someToy.getPrice() + "," + 
                AgeLimits.convertToString(someToy.getAgeLimits()) + "," 
                + someToy.getAttribute() + "," + someToy.getPictureURL() + "\r\n";
    }    
}
