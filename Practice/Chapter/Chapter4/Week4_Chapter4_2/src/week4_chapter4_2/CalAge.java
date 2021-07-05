/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_2;

/**
 *
 * @author holden
 */
public class CalAge {
    private int day, month, year;
    
    public void setDate(int day, int month, int year){
        if(!dateIsValid(day, month, year)){
            System.out.println("Input is not a date.");
            return;
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void show(){
        System.out.printf("the date is %d/%d/%d.%n", day,month,year);
    }
    private boolean dateCanComp(CalAge b){
        if(this.year > b.year){
            return true;
        }else if (this.year == b.year && this.month > b.month){
            return true;
        }else if(this.year == b.year && this.month == b.month && this.day > b.day){
            return true;
        }
        System.out.println("The 1st date is later than 2nd date");
        return false;
    }
    public double cal(CalAge b){
        if(!dateCanComp(b)){
            System.out.println("The 1st date is later than 2nd date");
            return 0;
        }
        double resultInt = this.year - b.year;
        double resultFloat = (this.month - b.month)/12.0;
        return resultInt + resultFloat;
    }
    
    private boolean dateIsValid(int day, int month, int year){
        int[] model = getYearModel(year);
        if(month < 1 || month > 12){
            return false;
        }else if(day > model[month] || day < 1){
            return false;
        }
        return true;
    }
    
    private boolean yearIsLeapYear(int year){
        return (year%4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    
    private int[] getYearModel(int year){
        if(yearIsLeapYear(year)){
            int[] model = {0 , 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            return model;
        }
        int[] model = {0 , 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return model;
        
    }
}
