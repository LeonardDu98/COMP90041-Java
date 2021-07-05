/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_chapter3_1;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week3_Chapter3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("This program can be used to compute the square root of a negetive number!");
        System.out.print("Please input a negetive number: ");
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        double guess_old = 0;
        double guess_new = num / 2;
        double result = 0;
        do{
            result = num / guess_new;
            guess_old = guess_new;
            guess_new += result;
            guess_new /= 2;
        } while(guess_old / guess_new > 1.01 || guess_new / guess_old > 1.01);
        System.out.println(guess_old);
        System.out.println(guess_new);
        System.out.println(guess_old/guess_new);
        System.out.println(guess_new/guess_old);
        System.out.printf("The accurater result with Babylonian algorithm is \"%.2f\". %n", guess_new);
    }
    
}
