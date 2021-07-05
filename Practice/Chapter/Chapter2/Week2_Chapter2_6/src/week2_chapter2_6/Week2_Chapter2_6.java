/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_chapter2_6;

/**
 *
 * @author holden
 */
public class Week2_Chapter2_6 {
public static final double sweetnersToKillMice = 1.0;
public static final double weightOfMice = 0.05;
public static final double startWeightOfDieter = 100;
public static final int finalWeightOfDieter = 80;
public static final double sweetnersInSoda = 0.001;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double sweetersOf1kg = sweetnersToKillMice/weightOfMice;
        double sweetersOfFinalWeight = sweetersOf1kg*finalWeightOfDieter;
        double sodaCanDrink = sweetersOfFinalWeight/sweetnersInSoda;
        System.out.printf("Please never drink more than %.3f cans if U want to be safety %d kg.%n", sodaCanDrink, finalWeightOfDieter);
    }
}
