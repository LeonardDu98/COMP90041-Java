/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.Arrays;

/**
 *
 * @author holden
 */
public class Card {
    private int num;
    private String suit;
    private final int[] allNum = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 14, 11, 13, 12, 10};
    //private final String[] allNumChar = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
    private final char[] allNumChar = new char[]{'2', '3', '4', '5', '6', '7', '8', '9', 'A', 'J', 'K', 'Q', 'T'};
    private final char[] allSuit = new char[]{'C', 'D', 'H', 'S'};
    
    public Card(){
        num = 0;
        suit = "No suit";
    }
    
    public void setCard(String newCard){
        newCard = newCard.toUpperCase();
        if(!isVaild(newCard)){
            System.out.println("Error: invalid card name '" + newCard + "'");
            System.exit(0);  
        }
        num = toNum(newCard.charAt(0));
        suit = Character.toString(newCard.charAt(1));   
    }
    
    public int getNum(){
        return num;
    }
    
    public String getSuit(){
        return suit;
    }
    
    public void output(){
        System.out.println("Num: " + num);
        System.out.println("Suit: " + suit);
    }
    
    private int toNum(char numChar){
         return allNum[Arrays.binarySearch(allNumChar, numChar)];
    }
    
    private boolean isVaild(String newCard){
        return Arrays.binarySearch(allNumChar, newCard.charAt(0)) > -1 &&
                Arrays.binarySearch(allSuit, newCard.charAt(1)) > -1;
    }
}
