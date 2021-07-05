/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efficiency;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Efficiency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter vehicle make: ");
        String make = sc.nextLine();
        System.out.println("Enter vehicle model: ");
        String model = sc.nextLine();
        System.out.println("Enter kilometres travelled: ");
        double distance = sc.nextDouble();
        System.out.println("Enter litres of fuel used: ");
        double fuel = sc.nextDouble();
        System.out.printf("Fuel efficiency for a %s %s: %.2f litres/100 km%n", make, model, fuel*100/distance);
        
    }
    
}
