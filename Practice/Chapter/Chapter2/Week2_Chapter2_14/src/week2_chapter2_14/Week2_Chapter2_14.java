/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_chapter2_14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week2_Chapter2_14 {
    public static final int coffeineToKillPeason = 10000;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = null;
        try{
            sc = new Scanner(new FileInputStream("Week2_Chapter2_14.txt"));
        } catch(FileNotFoundException e) {
            System.out.println("Sorry, ur file is not found.");
            System.exit(0);
        }
        String name = sc.nextLine();
        double contain = sc.nextDouble();
        System.out.printf("It will take approximately %.2f drinks of %s to kill a person from caffeine. %n", coffeineToKillPeason/contain, name);
    }
    
}
