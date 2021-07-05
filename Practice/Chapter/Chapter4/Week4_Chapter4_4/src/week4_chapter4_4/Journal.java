/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_4;

import java.util.Date;

/**
 *
 * @author holden
 */
public class Journal {
    private String name;
    private String title;
    private Date date;
    
    public void Constructor(String name, String title, Date date){
        this.name = name;
        this.date = date;
        this.title = title;
    }
    public void displayDetails(){
        System.out.printf("Name: %s.%n", name);
        System.out.printf("Title: %s.%n", title);
        System.out.printf("Date: %d/%d/%d.%n", date.getDate(), date.getMonth(), date.getYear());
    }
    public void getSubmissionDetails(){
        char[] a = title.toCharArray();
        a[0] = Character.toUpperCase(a[0]);
        System.out.print(a[0]);
        for(int i = 1; i < a.length; i++){
            if(a[i-1] == ' '){
                a[i] = Character.toUpperCase(a[i]);
            }
            System.out.print(a[i]);
        }
        System.out.print("\n");
    }
   
}
