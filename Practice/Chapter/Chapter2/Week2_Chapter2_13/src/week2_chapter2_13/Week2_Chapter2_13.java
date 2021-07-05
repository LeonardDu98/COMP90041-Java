/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_chapter2_13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week2_Chapter2_13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = null;
        try{
            sc = new Scanner(new FileInputStream("Week2_Chapter2_13.txt"));
        } catch(FileNotFoundException e){
            System.out.println("Sorry, ur file is not found");
            System.exit(0);
        }
        String name[] = new String[3];
        int height[][] = new int[3][3];
        for(int i = 0; i < 3; i++){
            name[i] = sc.nextLine();
            height[i][0] = sc.nextInt();
            height[i][1] = sc.nextInt();
            sc.nextLine();
            height[i][2] = 110 + ((height[i][0] - 5) * 12 + height[i][1]) * 5;
        }
        for(int i = 0; i < 3; i++){ 
            System.out.printf("%s, Ur ideal weight is %d pounds. %n", name[i], height[i][2]);
        }
    }
    
}
