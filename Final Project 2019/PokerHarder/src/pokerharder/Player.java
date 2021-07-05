package pokerharder;
/**
 * Represent a Player in a poker game.
 * This file can run to get javadoc if you need by adding package command.
 * @author Name: Zongcheng DU.
 * @author ID: zongchengd.
 * @version 2019.1004
 * @since 1.8.
 */
public class Player {
    /**
     * The rank of player cards type.
     * The rank larger, the type bigger.
     * The ranks represent high card, one pair, two pairs, three of a kind, straight, flush, full house, four of a kind or straight flush from 0 to 8.
     */
    private int rank = -1;
    /**
     * All of three int variables represent some detail of cards.
     * Use r1 and r2 when rank is 2 or 6, use r for other cases.
     */
    private int r = -1;
    private int r1 = -1;
    private int r2 = -1;
    /**
     * The number of pairs of player cards.
     */
    private int pairs = -1;
    /**
     * The String combines the values of every card which value uses two digits.
     * For example: "1304051008" 
     */
    private String numString = "";
    /**
     * Two String arrays are used when output detail description of player cards.
     */
    private final String[] description = new String[]{"-high", "Pair of ", "s over ", "Three ",
        "-high straight", "-high flush", "s full of ", "Four ", "-high straight flush"};
    private final String[] cardName  = new String[]{"", "","2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    
    /**
     * Copy Constructor
     * @param onePlayer another Player object.
     */
    public Player(Player onePlayer){
        if(onePlayer == null) return;
        
        rank = onePlayer.getRank();
        r = onePlayer.getR();
        r1 = onePlayer.getR1();
        r2 = onePlayer.getR2();
        pairs = onePlayer.getPairs();
        numString = onePlayer.getNumString();
    }
    
    /**
     * Constructor
     * @param PlayerString one String array contains details of 5 cards.
     */
    public Player(String[] PlayerString){
        Card[] hand = new Card[5];//Create a array contains 5 cards
        
        for(int i = 0; i < 5; i++){
            hand[i] = new Card(PlayerString[i]);//Set values of every card.
        }
        
        hand = inOrder(hand);//Let cards in decreasing order.
        
        CalculateEveryVariables(hand);
    }
    
    /**
     * Make cards in decreasing order.
     * @param hand an Card array contains 5 cards.
     * @return an Card array contains 5 cards with the numbers of cards from highest to lowest.
     */
    private Card[] inOrder(Card[] hand){
        for(int i = 0; i < 4; i++){
            for(int j = i + 1; j < 5; j++){
                if(hand[i].getNum() < hand[j].getNum()){
                    Card temp = new Card(hand[i]);
                    hand[i] = new Card(hand[j]);
                    hand[j] = new Card(temp);
                }
            }
        }
        return hand;
    }
    
    /**
     * Calculate pairs, rank, r, r1, r2 and numString.
     * @param hand an Card array contains 5 cards in decreasing order.
     */
    private void CalculateEveryVariables(Card[] hand){
        CalculatePairs(hand);
        CalculateRs(hand);
        toNumString(hand);
    }
    
    /**
     * Calculate the number of pairs of player cards.
     * @param hand an Card array contains 5 cards in decreasing order.
     */
    private void CalculatePairs(Card[] hand){
        int count = 0;
        for(int i = 0; i < 4; i++){
            for(int j = i + 1; j < 5; j++){
                if(hand[i].getNum() == hand[j].getNum()){
                    count++;
                }
            }
        }
        pairs = count;
    }
    
    /**
     * Calculate and set rank, r, r1, and r2.
     * @param hand an Card array contains 5 cards in decreasing order.
     */
    private void CalculateRs(Card[] hand){
        if(sameSuits(hand)){
            if(Straight(hand)) rank = 8;//Straight flush 
            else rank = 5; //Flush
        }else {
            switch(pairs){
                case 0:
                    if(Straight(hand)) rank = 4; //Straight
                    else rank = 0; //High card
                    break;
                case 1:
                    rank = 1;//One pair
                    r = hand[0].getNum() == hand[1].getNum() || hand[1].getNum() == hand[2].getNum() ? hand[1].getNum() : hand[3].getNum();
                    break;
                case 2:
                    rank = 2; //Two pairs
                    r1 = hand[1].getNum();
                    r2 = hand[3].getNum();
                    break;
                case 3:
                    rank = 3; //Three of a kind
                    break;
                case 4:
                    rank = 6; //Full house
                    r1 = hand[2].getNum();
                    r2 = hand[1].getNum() == hand[2].getNum() ? hand[3].getNum() : hand[1].getNum();
                    break;
                case 6:
                    rank = 7; //Four of a kind
                    break;
                default:
                    System.out.println("Some Errors in CalculatePairs");
            }
        }
        if(rank == 5 || rank == 8 || rank == 0 || rank == 4) r = hand[0].getNum();
        if(rank == 3 || rank == 7) r = hand[2].getNum();
    }
    
    /**
     * Determine if all cards are in same suit.
     * @param hand an Card array contains 5 cards in decreasing order.
     * @return true means all same suit, and false means 2 suits at least.
     */
    private boolean sameSuits(Card[] hand){
        return hand[0].getSuit().equals(hand[1].getSuit()) &&
                hand[1].getSuit().equals(hand[2].getSuit()) &&
                hand[2].getSuit().equals(hand[3].getSuit()) &&
                hand[3].getSuit().equals(hand[4].getSuit());
    }
    
    /**
     * Determine if 5 cards combine a straight.
     * @param hand an Card array contains 5 cards in order.
     * @return true means 5 cards combine a straight, and false means no straight.
     */
    private boolean Straight(Card[] hand){
        return hand[0].getNum() - 1 == hand[1].getNum() &&
                hand[1].getNum() - 1 == hand[2].getNum() &&
                hand[2].getNum() - 1 == hand[3].getNum() &&
                hand[3].getNum() - 1 == hand[4].getNum();
    }
    
    /**
     * Get the String combines the values of every card which value uses two digits.
     * @param hand an Card array contains 5 cards in order.
     * @return 
     */
    private void toNumString(Card[] hand){
        numString = hand[0].getNumString() + hand[1].getNumString() + hand[2].getNumString() + hand[3].getNumString() + hand[4].getNumString();
    }
    
    /**
     * 
     * @return value of rank.
     */
    public int getRank(){
        return rank;
    }
    
    /**
     * 
     * @return value of r.
     */
    public int getR(){
        return r;
    }
    
    /**
     * 
     * @return value of r1.
     */
    public int getR1(){
        return r1;
    }
    
    /**
     * 
     * @return value of r2.
     */
    public int getR2(){
        return r2;
    }
    
    /**
     * 
     * @return value of pairs.
     */
    public int getPairs(){
        return pairs;
    }
    
    /**
     * 
     * @return value of numString.
     */
    public String getNumString(){
        return numString;
    }
    
    /**
     * Determine if this player's cards are larger than another player.
     * @param onePlayer one Player object.
     * @return true means this player's cards are larger, and false means smaller.
     */
    public boolean larger(Player onePlayer){
        return rank > onePlayer.getRank() // rank of this player is large
                || ((rank == onePlayer.getRank() && (r > onePlayer.getR() || r1 > onePlayer.getR1() // equal ranks, but r is larger or r1 is larger.
                        || (r1 == onePlayer.getR1() && r2 > onePlayer.getR2()) // equal ranks and r1s, but r2 is larger.
                    || (r == onePlayer.getR() && r1 == onePlayer.getR1() && r2 == onePlayer.getR2()
                        && numString.compareTo(onePlayer.getNumString()) > 0)))); // equal ranks, rs, r1s and r2s, players cards is larger in special cases.
                                                                                  // For example: "97654" is larger than "96543".
    }
    
    /**
     * Determine if this player's cards are equal to another player.
     * @param onePlayer one Player object.
     * @return true means equal, and false means unequal.
     */
    public boolean equal(Player onePlayer){
        return rank == onePlayer.getRank() && numString.equals(onePlayer.getNumString());
    }
    
    /**
     * toString method of Player Class
     * @return one String describes the cards of player.
     */
    public String toString(){
        if(rank == 0 || rank == 4 || rank == 5 || rank == 8){
            return cardName[r] + description[rank];
        }
        if(rank == 1 || rank == 3 || rank == 7){
            return description[rank] + cardName[r] + "s";
        }
        return cardName[r1] + description[rank] + cardName[r2] + "s";
    }
}
