/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_chapter1_9;
import java.util.Scanner;
/**
 *
 * @author holden
 */
public class Week1_Chapter1_9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input ur height in feets and inchs:");
        int feetOfHeight = sc.nextInt();
        int inchOfHeight = sc.nextInt();
        if(feetOfHeight<5) { 
            System.out.println("Ur input was too small:");
        } else{
            int idealBodyWeight = 110 + (((feetOfHeight - 5) * 12) + inchOfHeight) * 5;
            System.out.println("ur ideal body weight is " + idealBodyWeight + "pounds");
        }
    }
    
}
