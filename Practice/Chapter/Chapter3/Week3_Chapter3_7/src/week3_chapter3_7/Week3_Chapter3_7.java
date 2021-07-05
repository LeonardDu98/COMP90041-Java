/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_chapter3_7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week3_Chapter3_7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the start num: ");
        int start = sc.nextInt();
        System.out.println("Please input the end num: ");
        int end = sc.nextInt();
        ArrayList result = armStrong(start, end);
        for(int i = 0; i < result.size(); i++){
            System.out.printf("The %d num is %d.%n", i + 1, result.get(i));
        }
    }

    public static ArrayList armStrong(int start, int end){
        ArrayList a = new ArrayList();
        for(int i = start; i <= end; i++){
            int digit = (int)Math.log10(i) + 1;
            int sum = 0;
            int temp = i;
            for(int j = digit - 1; j >= 0; j--){
                int p = temp / (int)(Math.pow(10,j));
                sum += Math.pow(p, digit);
                temp = temp - p * (int)(Math.pow(10,j));
            }
            if(sum == i){
                a.add(i);
                System.out.println(sum);
            }
        }
        return a; 
    }
}
