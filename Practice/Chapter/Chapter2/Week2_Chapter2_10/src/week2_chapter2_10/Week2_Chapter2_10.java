/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_chapter2_10;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week2_Chapter2_10 {
    public static final int numOfProducts = 3;
    public static final double taxOfSale = 0.0625;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int quantity[] = new int[numOfProducts];
        double price[] = new double[numOfProducts], total[] = new double[numOfProducts];
        String item[] = new String[numOfProducts];
        double subtotal = 0;
        for(int i = 0; i < numOfProducts;i++){
            System.out.printf("Input name of item %d:", i + 1);
            item[i] = sc.next();
            System.out.printf("Input quantity of item %d:", i + 1);
            quantity[i] = sc.nextInt();
            System.out.printf("Input price of item %d:", i + 1);
            price[i] = sc.nextDouble();
            total[i] = quantity[i] * price[i];
            subtotal += total[i];
        }
        double tax = subtotal * taxOfSale;
        double sumOfAll = tax + subtotal;
        System.out.println("Your bill:");
        System.out.println("");
        System.out.printf("%-10s%-15s%-10s%-10s%n", "Item", "Quantity", "Price", "Total");
        for(int i = 0; i < numOfProducts; i++){
            System.out.printf("%-10s%-15d%-10.2f%-10.2f%n", item[i], quantity[i], price[i], total[i]);
        }
        System.out.println("");
        System.out.printf("%-35s%5.2f%n", "Subtotal", subtotal);
        System.out.printf("%-35s%5.2f%n", "6.25% sales tax", tax);
        System.out.printf("%-35s%5.2f%n", "Total", sumOfAll);
    }
    
}
