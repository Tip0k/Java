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
public class AgeLimits {

    private int min;
    private int max;
    
    public AgeLimits(int min, int max) {
        if(min < 0 || min > max) throw new IllegalArgumentException();
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }
    
    public int getMax() {
        return max;
    }
}
