/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_chapter3_9;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week3_Chapter3_9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc  = new Scanner(System.in);
        System.out.println("Please input the num of the objects: ");
        int num = sc.nextInt();
        int result[][] = new int[num][2];
        int sum = 0, possible = 0;
        for(int i = 0; i < num; i++){
            System.out.printf("Score received for exercise %d:%n", i + 1);
            sum += sc.nextInt();
            System.out.printf("Total points possible for exercise %d:%n", i + 1);
            possible += sc.nextInt();
        }
        double a = (double)sum / possible;
        DecimalFormat rule = new DecimalFormat("0.00%");
        System.out.printf("Your total is %d out of %d, or %s.%n", sum, possible, rule.format(a));
    }
    
}
