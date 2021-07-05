/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_chapter2_3;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week2_Chapter2_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input 2 integer numbers. 1st is the dividend, and 2nd is the divisor.");
        System.out.print("1st number:");
        int dividend = sc.nextInt();
        System.out.print("2nd number:");
        int divisor = sc.nextInt();
        int quotient = dividend / divisor;
        int remainder = dividend % divisor;
        System.out.printf("The dividend is %d. %nThe divisor is %d. %nThe quotient is %d. %nThe remainder is %d.%n", dividend,divisor,quotient,remainder);
        
    }
    
}
