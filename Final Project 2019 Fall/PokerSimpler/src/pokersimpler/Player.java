/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokersimpler;

/**
 *
 * @author holden
 */
public class Player {
    private int rank = -1;
    private int r = -1;
    private int r1 = -1;
    private int r2 = -1;
    private int pairs = -1;
    private final String[] description = new String[]{"-high", "Pair of ", "s over ", "Three ",
        "-high straight", "-high flush", "s full of ", "Four ", "-high straight flush"};
    private final String[] cardName  = new String[]{"", "","2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    
    public Player(String[] PlayerString){
        Card[] hand = new Card[5];
        
        for(int i = 0; i < 5; i++){
            hand[i] = new Card(PlayerString[i]);
        }
        
        hand = inOrder(hand);
        pairs = CalculatePairs(hand);
        Calculate(hand);
    }
    
    private Card[] inOrder(Card[] hand){
        for(int i = 0; i < 4; i++){
            for(int j = i + 1; j < 5; j++){
                if(hand[i].getNum() > hand[j].getNum()){
                    Card temp = new Card(hand[i]);
                    hand[i] = new Card(hand[j]);
                    hand[j] = new Card(temp);
                }
            }
        }
        return hand;
    }
    
    private int CalculatePairs(Card[] hand){
        int count = 0;
        for(int i = 0; i < 4; i++){
            for(int j = i + 1; j < 5; j++){
                if(hand[i].getNum() == hand[j].getNum()){
                    count++;
                }
            }
        }
        return count;
    }
    
    private void Calculate(Card[] hand){
        if(sameSuits(hand)){
            if(Straight(hand)){ 
                rank = 8; //Straight flush   
            }else{
                rank = 5; //Flush
            }
            r = hand[4].getNum();
            return;
        }
        switch(pairs){
            case 0:
                if(Straight(hand)){ 
                    rank = 4; //Straight      
                }else{
                    rank = 0; //High card
                }
                r = hand[4].getNum();
                return;
            case 1:
                rank = 1;//One pair
                if(hand[0].getNum() == hand[1].getNum()){
                    r = hand[0].getNum();
                }else if(hand[1].getNum() == hand[2].getNum()){
                    r = hand[1].getNum();
                }else{
                    r = hand[3].getNum();
                }
                return;
            case 2:
                rank = 2; //Two pairs
                r1 = hand[3].getNum();
                r2 = hand[1].getNum();
                return;
            case 3:
                rank = 3; //Three of a kind
                r = hand[2].getNum();
                return;
            case 4:
                rank = 6; //Full house
                r1 = hand[2].getNum();
                if(hand[1].getNum() == hand[2].getNum()){
                    r2 = hand[3].getNum();
                }else{
                    r2 = hand[1].getNum();
                }
                return;
            case 6:
                rank = 7; //Four of a kind
                r = hand[2].getNum();
                return;
            default:
                System.out.println("Some Errors in CalculatePairs");
        }
    }
    
    private boolean sameSuits(Card[] hand){
        return hand[0].getSuit().equals(hand[1].getSuit()) &&
                hand[1].getSuit().equals(hand[2].getSuit()) &&
                hand[2].getSuit().equals(hand[3].getSuit()) &&
                hand[3].getSuit().equals(hand[4].getSuit());
    }
    
    private boolean Straight(Card[] hand){
        return hand[0].getNum() + 1 == hand[1].getNum() &&
                hand[1].getNum() + 1 == hand[2].getNum() &&
                hand[2].getNum() + 1 == hand[3].getNum() &&
                hand[3].getNum() + 1 == hand[4].getNum();
    }
    
    public String toString(){
        if(rank == 0 || rank == 4 || rank == 5 || rank == 8){
            return "Player 1: " + cardName[r] + description[rank];
        }
        if(rank == 1 || rank == 3 || rank == 7){
            return "Player 1: " + description[rank] + cardName[r] + "s";
        }
        return "Player 1: " + cardName[r1] + description[rank] + cardName[r2] + "s";
    }
}
