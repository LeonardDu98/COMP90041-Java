/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_6;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week4_Chapter4_6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int quiz1, quiz2, quiz3, midterm, finalnum;
        System.out.println("Please input quiz1:");
        quiz1 = sc.nextInt();
        System.out.println("Please input quiz2:");
        quiz2 = sc.nextInt();
        System.out.println("Please input quiz3:");
        quiz3 = sc.nextInt();
        System.out.println("Please input midterm:");
        midterm = sc.nextInt();
        System.out.println("Please input finalnum:");
        finalnum = sc.nextInt();
        student st = new student();
        st.constructor(quiz1, quiz2, quiz3, midterm, finalnum);
        st.getString();
    }
    
}
