/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_chapter1_10;

/**
 *
 * @author holden
 */
public class Week1_Chapter1_10 {
public static final double caffeineInCola_12ounce = 34;
public static final double caffeineInCoffee_16ounce = 160;
public static final double caffeineTokillAPerson = 10000;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double  colaToKill = caffeineTokillAPerson/caffeineInCola_12ounce + 1;
        double  coffeeToKill = caffeineTokillAPerson/caffeineInCoffee_16ounce + 1;
        System.out.println((int)colaToKill + " colas or "+ (int)coffeeToKill + " coffees can kill a person");
    }
    
}
