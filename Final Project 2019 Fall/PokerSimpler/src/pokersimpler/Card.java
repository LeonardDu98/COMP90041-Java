/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokersimpler;

import java.util.Arrays;

/**
 *
 * @author holden
 */
public class Card {
    private int num;
    private char suit;
    private final char[] allSuit = new char[]{'C', 'D', 'H', 'S'};
    private final char[] allCharNum = new char[]{'2', '3', '4', '5', '6', '7', '8', '9', 'A', 'J', 'K', 'Q', 'T'};
    private final int[] allIntNum = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 14, 11, 13, 12, 10};
    
    public Card(String newCard){
        if(!legal(newCard)){
            System.out.println("Error: invalid card name " + newCard);
            System.exit(0);
        }
        num = findNum(newCard.toUpperCase().charAt(0));
        suit = newCard.toUpperCase().charAt(1);
    }
    
    private int findNum(char charNum){
        return allIntNum[Arrays.binarySearch(allCharNum, charNum)];
    }
    
    private boolean legal(String newCard){
        return newCard.length() == 2 && 
                Arrays.binarySearch(allCharNum, newCard.toUpperCase().charAt(0)) >= 0 && 
                Arrays.binarySearch(allSuit, newCard.toUpperCase().charAt(1)) >= 0;
    }
    
    public Card(Card newCard){
        if(newCard == null){
            System.out.println("Error");
            System.exit(0);
        }
        num = newCard.num;
        suit = newCard.suit;
    }
    
    public int getNum(){
        return num;
    }
    
    public String getSuit(){
        return Character.toString(suit);
    }
}
