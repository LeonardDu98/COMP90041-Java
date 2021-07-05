/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_chapter1_7;
import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week1_Chapter1_7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the number of seconds: ");
        int time = sc.nextInt();
        int hours = time / 3600;
        int mintues = (time%3600)/60;
        int seconds = (time % 3600 % 60);
        System.out.println("Wow, it's " + hours+ " hours, " + mintues + "mintues and " + seconds + "seconds!");
    }
    
}
