/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_chapter3_2;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week3_Chapter3_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String colors = sc.next();
        if(colors.length() != 5) {
            System.out.println("Ur input is more or less than 5");
            System.exit(0);
        }
        int flag = 1;
        for(int i = 0; i < 5; i++){
            if(colors.charAt(i) != 'R' && colors.charAt(i) != 'B' && colors.charAt(i) != 'Y'){
                flag = 0;
            }
            if(i > 0){
                if(colors.charAt(i) == colors.charAt(i - 1)){
                    flag = 0;
                }
            }
        }
        if(flag == 0){
            System.out.println("Ur input is not right!");
        }else{
            System.out.printf("\"%s\" is a right input.%n", colors);
        }
    }
    
}
