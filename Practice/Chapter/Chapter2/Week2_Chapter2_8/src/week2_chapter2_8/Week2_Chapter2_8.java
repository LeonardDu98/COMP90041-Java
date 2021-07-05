/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_chapter2_8;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week2_Chapter2_8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String oneLine = sc.nextLine();
        int length = oneLine.length();
        for(int i = 0; i < length; i++){
            if(oneLine.charAt(i) == ','){
                System.out.printf("%n");
            } else{
                System.out.print(oneLine.charAt(i));
            }
        }
        System.out.println("");
    }
    
}
