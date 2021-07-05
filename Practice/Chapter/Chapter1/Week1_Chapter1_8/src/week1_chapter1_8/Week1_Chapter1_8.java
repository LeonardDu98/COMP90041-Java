/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_chapter1_8;

/**
 *
 * @author holden
 */
public class Week1_Chapter1_8 {

public static final double distance = 100;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double time = 20.5;
        System.out.println("This program calculates "
                + "vehicle average speed given a "
                + "time and distance traveled.");
        double averageSpeed = distance/time;
        System.out.println("Car average speed is " + averageSpeed
+ " miles per hour.");
    }
    
}
