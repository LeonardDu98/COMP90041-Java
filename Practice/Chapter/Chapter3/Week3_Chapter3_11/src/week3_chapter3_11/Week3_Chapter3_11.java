/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_chapter3_11;

import java.util.Random;

/**
 *
 * @author holden
 */
public class Week3_Chapter3_11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("This program is about random.");
        Random ra = new Random();
        int a[] = new int[]{0, 0, 0};
        for(int i = 0; i < 3; i++){
            int temp = ra.nextInt(30) + 1;
            if(temp != a[0] && temp != a[1] && temp != a[2]){
                a[i] = temp;
            }else{
                i--;
            }
        }
        System.out.printf("The three nums are %d %d %d.%n", a[0], a[1], a[2]);
        
    }
    
}
