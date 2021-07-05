/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_chapter1_3;
import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week1_Chapter1_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input ur firstname: ");
        String first = sc.nextLine();
        System.out.println("Please input ur lastname: ");
        String last = sc.nextLine();
        String firstNum1 = first.substring(1,2);
        String lastNum1 = last.substring(1,2);
        first = firstNum1.toUpperCase() + first.substring(2) + first.substring(0, 1) + "ay";
        last = lastNum1.toUpperCase() + last.substring(2) + last.substring(0, 1) + "ay";
        String fullName = first + " " + last;
        System.out.println("Wonderful! Pig Latin of ur name is " + fullName);
    }
    
}
