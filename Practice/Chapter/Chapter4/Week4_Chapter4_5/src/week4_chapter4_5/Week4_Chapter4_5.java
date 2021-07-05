/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_5;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week4_Chapter4_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Words:");
        String words = sc.nextLine();
        WordCount wc = new WordCount();
        System.out.println(wc.getCount());
        wc.counter(words);
        wc.show();
        int b = wc.getCount();
        System.out.println(b);
    }
    
}
