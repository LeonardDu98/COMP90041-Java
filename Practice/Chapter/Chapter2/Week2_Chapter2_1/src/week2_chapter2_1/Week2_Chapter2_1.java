/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_chapter2_1;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week2_Chapter2_1 {

    public static final int numOfLoop = 500;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("This program can be used to compute the square root of a negetive number!");
        System.out.print("Please input a negetive number: ");
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        double guess = num/2;
        double result = 0;
        for(int i = 0; i < numOfLoop; i++){
            result = num / guess;
            guess += result;
            guess /= 2;
        }
        System.out.printf("The accurater result with Babylonian algorithm is \"%.2f\". %n", guess);
    }
    
}
