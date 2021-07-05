/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_5;

/**
 *
 * @author holden
 */
public class WordCount {
    private int count = 0;
    
    private boolean isValid(){
        return count >= 0;
    }
    public void counter(String a){
        a = a + ' ';
        do{
            count++;
            if(a.charAt(0) == 'A'|| a.charAt(0) == 'a'){
                count--;
            }
            a = a.substring(a.indexOf(" ")+ 1);
            if(!isValid()){
                System.out.println("Wrong!");
                System.exit(0);
            }
        }while(a.indexOf(" ") > 0);
    }
    public int getCount(){
        return count;
    }
    public void show(){
        System.out.println("The num of words is "+ count);
    }
}
