/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_chapter2_7;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week2_Chapter2_7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter price of item\n" +
            "(from 25 cents to a dollar, in 5-cent increments):");
        Scanner sc = new Scanner(System.in);
        int price  = sc.nextInt();
        int change = 100 - price;
        int quarters = change/25;
        int dimes = change % 25 / 10;
        int nickels = change % 25 % 10 /5;
        System.out.printf("You bought an item for %d cents and gave me a dollar,%n"
                + "so your change is%n %d quarters,%n %d dimes, "
                + "and %n %d nickels.%n", price, quarters, dimes,nickels);
    }
    
}
