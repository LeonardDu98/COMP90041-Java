/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_chapter3_5;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week3_Chapter3_5 {

    public static final double interestRate = 1.5;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the price of Ur item:");
        double price = sc.nextInt();
        double interestSum = 0;
        double interestNow;
        for(int i = 1; price > 0 ;i++){
             interestNow = price * interestRate / 100;
             interestSum += interestNow;
             price = price - 50 + interestNow;
             if(price < 0){
                System.out.printf("U need to pay %.2f of interest and %.2f of debt in Month %d.%n", interestNow, price + 50 - interestNow, i);
                price = 0;
                System.out.printf("The price now is %.2f.%n", price);
             } else {
                System.out.printf("U need to pay %.2f of interest and %.2f of debt in Month %d.%n", interestNow, 50 - interestNow, i);
                System.out.printf("The price now is %.2f.%n", price);
             }
        }
        System.out.println("The total interest is " + interestSum);
        
    }
    
}
