/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_chapter2_5;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week2_Chapter2_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input Ur percentage: ");
        int percentage = sc.nextInt();
        int gpa = percentage * 4 / 100;
        System.out.println("U gap is "+ gpa);
    }
    
}
