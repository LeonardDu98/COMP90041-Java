/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_chapter3_8;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week3_Chapter3_8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input Ur number: ");
        int num = sc.nextInt();
        int digit = (int)Math.log10(num) + 1;
        int first = (num / (int)Math.pow(10, digit - 1)) % 2;
        int end = num % 2;
        for(int i = digit; i > 0 ; i-- ) {
            if(i == digit || i == 1){
                if(end == 0 && first == 0){
                    System.out.printf("$");
                    num %= (int)Math.pow(10, i - 1);
                    continue;
                } else if (end == 1 && first == 1){
                    System.out.printf("X");
                    num %= (int)Math.pow(10, i - 1);
                    continue;
                }
            }
            switch (num / (int)Math.pow(10, i - 1)){
                case 0:
                    System.out.print("*");
                    break;
                case 1:
                    System.out.print("B");
                    break;
                case 2:
                    System.out.print("E");
                    break;
                case 3:
                    System.out.print("A");
                    break;
                case 4:
                    System.out.print("@");
                    break;
                case 5:
                    System.out.print("F");
                    break;
                case 6:
                    System.out.print("K");
                    break;    
                case 7:
                    System.out.print("%");
                    break;
                case 8:
                    System.out.print("R");
                    break;
                case 9:
                    System.out.print("M");
                    break;
            }
            num %= (int)Math.pow(10, i - 1);
        }  
    }
}
