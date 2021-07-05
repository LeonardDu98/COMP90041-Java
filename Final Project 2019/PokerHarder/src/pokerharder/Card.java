package pokerharder;

import java.util.Arrays;

/**
 * Represent a Card in poker game.
 * This file can run to get javadoc if you need by adding package command.
 * @author Name: Zongcheng DU.
 * @author ID: zongchengd.
 * @version 2019.1004
 * @since 1.8.
 * @see java.util.Arrays
 */
public class Card {
    /**
     * The value of card.
     */
    private int num;
    /**
     * The suit of a card.
     */
    private char suit;
    /**
     * All possible conditions  of suits.
     */
    private final char[] allSuit = new char[]{'C', 'D', 'H', 'S'};
    /**
     * All possible conditions of values in char type in increasing order.
     */
    private final char[] allCharNum = new char[]{'2', '3', '4', '5', '6', '7', '8', '9', 'A', 'J', 'K', 'Q', 'T'};
    /**
     * All possible conditions of values in int type corresponding with allCharNum.
     */
    private final int[] allIntNum = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 14, 11, 13, 12, 10};
    /**
     * All possible conditions of values in String type with 2 chars in increasing order.
     */
    private final String[] allStringNum = new String[]{"", "","02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14"};
    
    /**
     * Copy Constructor
     * @param newCard one Card object.
     */
    public Card(Card newCard){
        if(newCard == null){
            System.out.println("Error");
            System.exit(0);
        }
        num = newCard.num;
        suit = newCard.suit;
    }
    
    /**
     * Constructor
     * @param newCard one String contains 2 legal chars ignoring case.
     */
    public Card(String newCard){
        if(!legal(newCard)){
            System.out.println("Error: invalid card name '" + newCard + "'");
            System.exit(0);
        }
        num = findNum(newCard.toUpperCase().charAt(0));
        suit = newCard.toUpperCase().charAt(1);
    }
    
    /**
     * Find position of charNum in array allCharNum.
     * @param charNum one legal char in allCharNum.
     * @return the position of charNum in array allCharNum.
     */
    private int findNum(char charNum){
        return allIntNum[Arrays.binarySearch(allCharNum, charNum)];
    }
    
    /**
     * Determine if newCard can represent a poker card.
     * @param newCard one normal String
     * @return true means the newCard is legal, and false means the newCard is illegal.
     */
    private boolean legal(String newCard){
        return newCard.length() == 2 && 
                Arrays.binarySearch(allCharNum, newCard.toUpperCase().charAt(0)) >= 0 && 
                Arrays.binarySearch(allSuit, newCard.toUpperCase().charAt(1)) >= 0;
    }
    
    /**
     * 
     * @return value of num.
     */
    public int getNum(){
        return num;
    }
    
    /**
     * 
     * @return value of suit in String type.
     */
    public String getSuit(){
        return Character.toString(suit);
    }
    
    /**
     * 
     * @return value of num in String type.
     */
    public String getNumString(){
        return allStringNum[num];
    }
}
