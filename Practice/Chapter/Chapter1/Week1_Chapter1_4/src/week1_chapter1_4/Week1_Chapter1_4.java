/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_chapter1_4;

/**
 *
 * @author holden
 */
public class Week1_Chapter1_4 {
    
public static final double sweetnersToKillMice = 1.0;
public static final double weightOfMice = 0.05;
public static final double startWeightOfDieter = 100;
public static final double finalWeightOfDieter = 80;
public static final double sweetnersInSoda = 0.001;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double sweetersOf1kg = sweetnersToKillMice/weightOfMice;
        double sweetersOfFinalWeight = sweetersOf1kg*finalWeightOfDieter;
        double sodaCanDrink = sweetersOfFinalWeight/sweetnersInSoda;
        System.out.println("Please never drink more than " + sodaCanDrink + " "
                + "cans if U want to be safety " + finalWeightOfDieter + " kg");
    }
    
}
