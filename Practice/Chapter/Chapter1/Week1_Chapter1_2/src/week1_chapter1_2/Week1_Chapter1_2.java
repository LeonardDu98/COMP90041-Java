/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_chapter1_2;

import java.util.Scanner;
/**
 *
 * @author holden
 */
public class Week1_Chapter1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input how many coupons u have now: ");
        int numOfCoupons = sc.nextInt();
        int numOfCandy = numOfCoupons / 10;
        int numOfGum = (numOfCoupons % 10) / 3;
        System.out.println("U can get " + numOfCandy + " candy bar(s) and " + numOfGum + " gumball(s)");
        
    }
    
}
