/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimsys;

import java.util.Scanner;

/**
 *
 * @author leonard
 */
public class Nimsys {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        String next = "Y";
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Nim");
        System.out.println("");
        System.out.println("Please enter Player 1's name:");
        String Player1name = sc.nextLine();
        NimPlayer Player1 = new NimPlayer(Player1name);
        System.out.println("");
        System.out.println("Please enter Player 2's name:");
        String Player2name = sc.nextLine();
        NimPlayer Player2 = new NimPlayer(Player2name);
        System.out.println("");
        while(next.equals("Y")){
            System.out.println("Please enter upper bound of stone removal:");
            int upper_bound = sc.nextInt();
            System.out.println("");
            System.out.println("Please enter initial number of stones:");
            System.out.println("");
            int initial_number = sc.nextInt();
            int left_number = initial_number;
            int flag = 1;
            while(left_number > 0){
                System.out.print(left_number + " stones left:");
                for(int i = 0; i < left_number; i++){
                    System.out.print(" *");
                    if(i == left_number - 1){
                        System.out.println("");
                    }
                }
                if(flag == 1){       
                    left_number -= Player1.removeStone(sc);
                    sc.nextLine();
                    flag = 2;
                } else{
                    left_number -= Player2.removeStone(sc);
                    sc.nextLine();
                    flag = 1;
                }
                System.out.println("");  
                /*
                int num = sc.nextInt();
                if(num > upper_bound || num > left_number){
                    System.out.println("Wrong input");
                    System.exit(0);
                }
                System.out.println("");   
                left_number -= num;
*/
            }
            System.out.println("Game Over");
            if(flag == 1){
                System.out.println(Player1.getName() + " wins!");
            } else{
                System.out.println(Player2.getName() + " wins!");
            }
            System.out.println("");
            System.out.println("Do you want to play again (Y/N):");
            next = sc.next();
            sc.nextLine();
        }
    }
    
}
