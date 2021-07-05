/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String[] a = ("I am Iron Man").split(" ");
        //System.out.println(a[0]);
        /*Scanner sc = new Scanner(System.in);
        String a = sc.next();
        switch(a){
            case "N":
                System.out.println("0");
                break;
            case "S":
                System.out.println("180");
                break;
            case "E":
                System.out.println("90");
                break;
            case "W":
                System.out.println("270");
                break;
            default:
                System.out.println("Wrong");
        }
*/
        /*
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(i == 0 && j == 0){
                    System.out.printf("%4s |", "*");
                }else if(i == 0){
                    System.out.printf("%4d |",j);
                } else if (j == 0){
                    System.out.printf("%4d |",i);
                }else{
                    System.out.printf("%4d |",i * j);
                }
            }
            System.out.println("");
            System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+");
        }
    }
    
        char b = 'A';
        int a = (int)b;
            a = (a - 65) % 26 + 66;
            System.out.printf("%s%d", (char)a, 1);
        System.out.printf("%d", (int)a);
 
        int[] a = {0,1};
        System.out.println(a[0]);
        */
        char a;
        a = 'C';
        System.out.printf("%c",a);
    }
     
}
