/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_2;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week4_Chapter4_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Please input your birthday:");
        System.out.println("The day：");
        Scanner sc = new Scanner(System.in);
        int dayBirth = sc.nextInt();
        System.out.println("The month：");
        int monthBirth = sc.nextInt();
        System.out.println("The year：");
        int yearBirth = sc.nextInt();
        
        System.out.println("Please input date Now:");
        System.out.println("The day：");
        int dayNow = sc.nextInt();
        System.out.println("The month：");
        int monthNow = sc.nextInt();
        System.out.println("The year：");
        int yearNow = sc.nextInt();
        
        CalAge birth = new CalAge();
        birth.setDate(dayBirth, monthBirth, yearBirth);
        CalAge now = new CalAge();
        now.setDate(dayNow, monthNow, yearNow);
        
        double result = now.cal(birth);
        System.out.printf("%.2f.%n",result);
    }
    
}
