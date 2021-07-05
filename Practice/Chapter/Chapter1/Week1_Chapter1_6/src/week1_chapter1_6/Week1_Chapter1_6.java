/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_chapter1_6;

import java.util.Scanner;
/**
 *
 * @author holden
 */
public class Week1_Chapter1_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int princi_amount, no_of_yrs;
        double int_rate;
        System.out.println("please in put the totol saving: ");
        princi_amount = sc.nextInt();
        System.out.println("please in put the years u want to save: ");
        no_of_yrs = sc.nextInt();
        System.out.println("please in put the interest rate: ");
        int_rate = sc.nextDouble();
        
        double interest = princi_amount * no_of_yrs * int_rate / 100;
        System.out.println("U can get $" + interest + "for interests");
    }
    
}
