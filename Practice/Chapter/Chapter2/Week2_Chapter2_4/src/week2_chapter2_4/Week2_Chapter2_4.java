/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_chapter2_4;

/**
 *
 * @author holden
 */
public class Week2_Chapter2_4 {

    public static final int distance = 55;
    public static final int speed = 15;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int hour = distance / speed;
        //int minutes = (int)(((double)distance/speed - hour) * 60);
        int minutes = (int)((double)distance/speed * 60 - hour * 60);
        System.out.printf("He used %d hours and %d minutes", hour, minutes);
    }
    
}
