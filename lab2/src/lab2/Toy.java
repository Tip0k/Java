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
}
