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
public class NimGame {
    private int leftStone;
    private final int upperBound;
    private NimPlayer Player1;
    private NimPlayer Player2;

    public NimGame(int leftStone, int upperBound, NimPlayer Player1, NimPlayer Player2) {
        this.leftStone = leftStone;
        this.upperBound = upperBound;
        this.Player1 = Player1;
        this.Player2 = Player2;
    }
    
    public void game(Scanner sc){
        System.out.println("");
        System.out.println("Initial stone count: " + leftStone);
        System.out.println("Maximum stone removal: " + upperBound);
        System.out.println("Player 1: " + Player1.fullName());
        System.out.println("Player 2: " + Player2.fullName());
        System.out.println("");
        int flag = 1;
        NimAIPlayer instance = new NimAIPlayer();
        while(leftStone > 0){
            printStone();
            if(flag == 1){
                System.out.println(Player1.getGivenName() + "'s turn - remove how many?");
                int moveNum;
                if(Player1.getIsAI() == false){
                    moveNum = sc.nextInt();
                    sc.nextLine();
                }else{
                    moveNum = instance.removeStone(leftStone, upperBound);
                }
                if(isValid(moveNum)){
                    leftStone -= moveNum;
                    flag = 2;
                }
            }else{
                System.out.println(Player2.getGivenName() + "'s turn - remove how many?");
                int moveNum;
                if(Player2.getIsAI() == false){
                    moveNum = sc.nextInt();
                    sc.nextLine();
                }else{
                    moveNum = instance.removeStone(leftStone, upperBound);
                }
                if(isValid(moveNum)){
                    leftStone -= moveNum;
                    flag = 1;
                }
            }
            System.out.println("");
        }
        System.out.println("Game Over");
        if(flag == 1){
            System.out.println(Player1.fullName() + " wins!");
            Player1.win();
        }else{
            System.out.println(Player2.fullName() + " wins!");
            Player2.win();
        }
        Player1.finishGame();
        Player2.finishGame();
    }
    
    public void printStone(){
        System.out.print(leftStone + " stones left:");
        for(int i = 0; i < leftStone; i++){
            System.out.print(" *");
        }
        System.out.println("");
    }
    
    public boolean isValid(int moveNum){
        if(moveNum > 0 && moveNum <= Math.min(upperBound, leftStone)){
            return true;
        }
        System.out.println("");
        System.out.println("Invalid move. You must remove between 1 and " + Math.min(upperBound, leftStone) + " stones.");
        return false;
    }
}
