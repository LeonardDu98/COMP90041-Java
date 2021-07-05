/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_chapter1_1;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week1_Chapter1_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double BMI,weight,height;
        System.out.println("Please input ur height: ");
        //height = System.in.read();
        Scanner sc = new Scanner(System.in);
        height = sc.nextDouble();
        System.out.println("Please input ur weight: ");
        //weight =  System.in.read();
        weight = sc.nextDouble();
        System.out.println(weight);
        BMI = weight/Math.pow(height,2);
        System.out.println("Ur BMI is "+ BMI);
    }
    
}
