/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_chapter3_4;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week3_Chapter3_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the item U want to buy:");
        String item = sc.nextLine();
        System.out.println("Please input the cost of the " + item);
        double cost = sc.nextDouble();
        sc.nextLine();
        System.out.printf("Please input the number of years from now that the %s will be purchased:%n", item);
        int years = sc.nextInt();
        sc.nextLine();
        System.out.println("Please input the interest in '%':");
        double interest = sc.nextDouble();
        sc.nextLine();
        for(;years > 0; years--){
            cost *= (1 + interest / 100);
        }
        System.out.printf("The cost of %s in %d years later is $%.3f.%n", item, years, cost);
    }
    
}
