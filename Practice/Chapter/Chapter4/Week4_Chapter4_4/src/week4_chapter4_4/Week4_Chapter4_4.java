/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_4;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week4_Chapter4_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Journal j = new Journal();
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Title:");
        String title = sc.nextLine();
        System.out.println("Day:");
        int day = sc.nextInt();
        System.out.println("Month:");
        int month = sc.nextInt();
        System.out.println("year:");
        int year = sc.nextInt();
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(year, month, day);
        Date date = gc.getTime();
        //date = new Date(year, month, day);
        j.Constructor(name, title, date);
        j.displayDetails();
        j.getSubmissionDetails();
    }
    
}
