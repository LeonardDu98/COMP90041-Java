/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_6;

/**
 *
 * @author holden
 */
public class student {
    private int quiz1, quiz2, quiz3, midterm, finalnum;
    private double overall;
    private String grade;
    
    public void constructor(int quiz1, int quiz2, int quiz3, int midterm, int finalnum){
        this.finalnum = finalnum;
        this.midterm = midterm;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;             
    }
    public void getString(){
        overall = midterm * 0.35 + finalnum * 0.4 + (quiz1 + quiz2 + quiz3)/30.0 * 100 * 0.25;
        if(overall >= 90){
            grade = "A";
        } else if(overall >= 80){
            grade = "B";
        }else if(overall >= 70){
            grade = "C";
        }else if(overall >= 60){
            grade = "D";
        }else{
            grade = "F";
        }
        System.out.println("Your quiz1 is "+ quiz1);
        System.out.println("Your quiz2 is "+ quiz2);
        System.out.println("Your quiz3 is "+ quiz3);
        System.out.println("Your midterm exam is "+ midterm);
        System.out.println("Your final exam is "+ finalnum);
        System.out.println("Your grade is "+ grade);
        System.out.println("Your over score is "+ overall);
    }
    public void setquiz1(int quiz1){
        this.quiz1 = quiz1;
    }
    public void setquiz2(int quiz2){
        this.quiz2 = quiz2;
    }
    public void setquiz3(int quiz3){
        this.quiz3 = quiz3;
    }
    public void setfinalnum(int finalnum){
        this.finalnum = finalnum;
    }
    public void setmidterm(int midterm){
        this.midterm = midterm;
    }
    public int getmidterm(){
        return midterm;
    }
    public int getfinalnum(){
        return finalnum;
    }
    public int getquiz1(){
        return quiz1;
    }
    public int getquiz2(){
        return quiz2;
    }
    public int getquiz3(){
        return quiz3;
    }
    public double getoverall(){
        return overall;
    }
    public String getgrade(){
        return grade;
    }
}
