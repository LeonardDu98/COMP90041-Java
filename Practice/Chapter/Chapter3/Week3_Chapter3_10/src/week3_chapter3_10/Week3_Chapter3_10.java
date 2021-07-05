/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_chapter3_10;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week3_Chapter3_10 {

    public static Random ra = new Random();
    public static Scanner sc = new Scanner(System.in);
    public static int temp = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int scoreHuman = 0, scoreComputer = 0;
        int flag = 0;
        for(int i = 0; i < 100; i++){
            System.out.println("--------------------------------------------------");
            if(i % 2 == 0){
                 scoreHuman = rollHuman(scoreHuman, 0);
                 System.out.println("Human's Score now is "+ scoreHuman);
                 System.out.println("");
            } else {
                scoreComputer = rollComputer(scoreComputer , 0);
                System.out.println("Computer's Score now is "+ scoreComputer);
                System.out.println("");
            }
            System.out.println("--------------------------------------------------");
            if(win(scoreHuman) == true){
                flag = 1;
                break;
            }
            if(win(scoreComputer) == true){
                flag = 2;
                break;
            }
        }
        switch (flag){
            case 1:
                System.out.println("Human wins.");
                break;
            case 2:
                System.out.println("Computer wins.");
                break;
            default :
                System.out.println("Someting wrong.");
                break;
        }
    }

    public static boolean win(int num){
            return num >= 100;
    }
    public static int rollHuman(int scoreHuman, int temp){
        int num = ra.nextInt(6) + 1;
        System.out.printf("U had get %d.%n", num);
        if(num  == 1 ){
            System.out.printf("Turn to Computer.%n");
            return scoreHuman;
        }
        temp += num;
        System.out.println("Please input Ur choose:");
        if(continueRoll() == false){
            scoreHuman += temp;
            temp = 0;
            return scoreHuman;
        }
        return rollHuman(scoreHuman, temp);
    }
    public static int rollComputer(int scoreComputer, int temp){
        int num = ra.nextInt(6) + 1;
        System.out.printf("Computer had get %d.%n", num);
        if(num  == 1 ){
            System.out.printf("Turn to Human.%n");
            return scoreComputer;
        }
        temp += num;
        if(win(scoreComputer + temp) == true){
            System.out.println("Hold and Win");
            return scoreComputer + temp;
        }
        if(temp > 20){
            System.out.println("Computer Hold.");
            scoreComputer += temp;
            temp = 0;
            return scoreComputer;
        }
        System.out.println("Computer reroll.");
        return rollComputer(scoreComputer, temp);
    }
    public static boolean continueRoll(){
        return sc.nextLine().equals("r");
    }
}