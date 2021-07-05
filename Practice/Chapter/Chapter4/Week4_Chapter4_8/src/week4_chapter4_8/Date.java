/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_8;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public final class Date {
    private int month;
    private int day;
    private int year;
    
    public Date(){
        month = 1;
        day = 1;
        year = 1000;
    }
    
    public Date(int monthInt, int day, int year){
        setDate(monthInt, day, year);
    }
    
    public Date(String monthString, int day, int year){
        setDate(monthString, day, year);
    }
    
    public Date(int year){
        setDate(1,1,year);
    }
    
    public Date(Date aDate){
        if(aDate == null){
            System.out.println("Fatal Error");
            System.exit(0);
        }
        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }
    public void setDate(int monthInt, int day, int year){
        if(dateOK(monthInt, day, year)){
            this.month = monthInt;
            this.day = day;
            this.year = year;
        }else{
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }
    
    public void setDate(String monthString, int day, int year){
        if(dateOK(monthString, day, year)){
            this.month = monthInt(monthString);
            this.day = day;
            this.year = year;
        }else{
            System.out.println("Fatal Error");
            System.exit(0);
        }
    }
    
    public void setDate(int year){
        setDate(1, 1, year);
    }
    
    public void setYear(int year){
        if(year < 1000 || year > 9999){
            System.out.println("Fatal Error");
            System.exit(0);
        }else
            this.year = year;
        
    }
    
    public void setMonth(int monthInt){
        if(monthInt <= 0 || monthInt > 12){
            System.out.println("Fatal Error");
            System.exit(0);
        }else
            this.month = month;
        
    }
    
    public void setDay(int day){
        if(day <= 0 || day > 31){
            System.out.println("Fatal Error");
            System.exit(0);
        }else
            this.day = day;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getDay(){
        return day;
    }
    
    public int getYear(){
        return year;
    }
    public String toString(){
        return (monthString(month) + " " +day+ ", "+ year );
    }
    
    public boolean equals(Date otherDate){
        return month == otherDate.month && day == otherDate.day && year == otherDate.year;
    }
    
    public boolean precede(Date otherDate){
        return (year < otherDate.year || (year == otherDate.year && month < otherDate.month)) 
                || (year == otherDate.year && month < otherDate.month && day < otherDate.day);
    }
    
    public void readInput(){
        boolean tryAgain = true;
        Scanner sc = new Scanner(System.in);
        while(tryAgain){
            System.out.println("Enter month, day, and year.");
            System.out.println("Don't use comma");
            int monthInput = sc.nextInt();
            int yearInput = sc.nextInt();
            int dayInput = sc.nextInt();
            if(dateOK(monthInput, dayInput, yearInput)){
                setDate(monthInput, dayInput, yearInput);
                tryAgain = false;
            }else{
                System.out.println("Illegal date. Reenter input.");
            }
        }   
    }
    
    private boolean dateOK(int monthInt, int day, int year){
        return (monthInt <= 12 && monthInt >= 1 && day >= 1 && day <= 31 && year >= 1000 && year <= 9999);
    }
    
    private boolean dateOK(String monthString, int day, int year){
        return (monthOK(monthString) && day >= 1 && day <= 31 && year >= 1000 && year <= 9999);
    }
    
    private boolean monthOK(String month){
        return (month.equals("January") ||
                month.equals("February") ||
                month.equals("March") || 
                month.equals("April") || 
                month.equals("May") || 
                month.equals("June") || 
                month.equals("July") || 
                month.equals("August") || 
                month.equals("September") || 
                month.equals("October") || 
                month.equals("November") || 
                month.equals("December") );
    }
    
    private String monthString(int monthInt){
        switch(monthInt){
            case 1:
                return "January";
            case 2:
                return "February";   
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "Decemeber";
            default:
                System.out.println("Fatal Error");
                System.exit(0);
                return "Error";               
        }
    }
    private int monthInt(String monthString){
        switch(monthString){
            case "January":
                return 1;
            case "Feburary":
                return 2;   
            case "March":
                return 3;
            case "April":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "July":
                return 7;
            case "August":
                return 8;
            case "Septermber":
                return 9;
            case "October":
                return 10;
            case "November":
                return 11;
            case "December":
                return 12;
            default:
                System.out.println("Fatal Error");
                System.exit(0);
                return 0;               
        }
    }
}