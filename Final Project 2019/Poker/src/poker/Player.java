/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author holden
 */
public class Player {
    private int rank = -1;
    private int r = -1, r1 = -1, r2 = -1, r3 = -1, r4 = -1, r5 = -1;
    
    private final String[] playersString = new String[]{"","","2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    
    public Player(){
        rank = -1;
        r = -1;
        r1 = -1;
        r2 = -1;
    }
    
    public void setPlayer(Card[] cards){
        cards = CompareCards(cards);
        if(isSameSuit(cards)){
            if(isStraight(cards)){
                rank = 8;
                if(cards[0].getNum() == 2 && cards[4].getNum() == 14){
                    r = cards[3].getNum();
                }else{
                    r = cards[4].getNum();
                }
            }else{
                rank = 5;
                r = cards[4].getNum();
                r2 = cards[3].getNum();
                r3 = cards[2].getNum();
                r4 = cards[1].getNum();
                r5 = cards[0].getNum();
            }
        } else{
            switch (countPairs(cards)){
                case 0:
                    if(isStraight(cards)){
                        rank = 4;
                        if(cards[0].getNum() == 2 && cards[4].getNum() == 14){
                            r = cards[3].getNum();
                        }else{
                            r = cards[4].getNum();
                        }
                    }else{
                        rank = 0;
                        r = cards[4].getNum();
                        r2 = cards[3].getNum();
                        r3 = cards[2].getNum();
                        r4 = cards[1].getNum();
                        r5 = cards[0].getNum();
                    }
                    break;
                case 1:
                    rank = 1;
                    r = getRForCase1(cards);
                    break;
                case 2:
                    rank = 2;
                    r1 = cards[3].getNum();
                    r2 = cards[1].getNum();
                    break;
                case 3:
                    rank = 3;
                    r = cards[2].getNum();
                    break;
                case 4:
                    rank = 6;
                    r1 = cards[2].getNum();
                    r2 = cards[1].getNum() == cards[2].getNum() ? cards[3].getNum():cards[0].getNum();
                    break;
                case 6:
                    rank = 7;
                    r = cards[3].getNum();
                    break;
            }
        }
    }
    
    public int getRank(){
        return rank;
    }
    
    public int getR(){
        return r;
    }
    
    public int getR1(){
        return r1;
    }
    
    public int getR2(){
        return r2;
    }
    
    public boolean equalTo(Player player){
        return this.rank == player.rank && this.r == player.r && this.r1 == player.r1 && this.r2 == player.r2
                && this.r3 == player.r3 && this.r4 == player.r4 && this.r5 == player.r5;
    }
    
    public boolean Larger(Player player){
        return this.rank > player.rank ||
               this.rank == player.rank && (this.r > player.r || this.r1 > player.r1 || (this.r1 == player.r1 && this.r2 > player.r2)) || 
               this.rank == player.rank && this.r == player.r && this.r1 == player.r1 && this.r2 == player.r2 && this.r3 > player.r3 || 
               this.rank == player.rank && this.r == player.r && this.r1 == player.r1 && this.r2 == player.r2 && this.r3 == player.r3 && this.r4 > player.r4 || 
               this.rank == player.rank && this.r == player.r && this.r1 == player.r1 && this.r2 == player.r2 && this.r3 == player.r3 && this.r4 == player.r4 && this.r5 > player.r5;
    }
    
    private boolean isSameSuit(Card[] cards){
        return cards[0].getSuit().equals(cards[1].getSuit()) && cards[1].getSuit().equals(cards[2].getSuit()) &&
               cards[2].getSuit().equals(cards[3].getSuit()) && cards[3].getSuit().equals(cards[4].getSuit());
    }
    
    private boolean isStraight(Card[] cards){
        return cards[0].getNum() + 1 == cards[1].getNum() && cards[1].getNum() + 1 == cards[2].getNum() && cards[2].getNum() + 1 == cards[3].getNum()
                    && (cards[3].getNum() + 1 == cards[4].getNum() || cards[4].getNum() % 13 + 1 == cards[0].getNum());
    }
    
    private int countPairs(Card[] cards){
        int count = 0;
        for(int i = 0; i < 4; i++){
            for(int j = i + 1; j < 5; j++){
                if(cards[i].getNum() == cards[j].getNum()){
                    count++;
                }
            }
        }
        return count;
    }
    
    private int getRForCase1(Card[] cards){
        if(cards[0].getNum() == cards[1].getNum()){
            return cards[0].getNum();
        }
        if(cards[1].getNum() == cards[2].getNum()){
            return cards[1].getNum();
        }
        return cards[3].getNum();
    }
    
    private Card[] CompareCards(Card[] cards){
        for(int i = 0; i < 4; i++){
            for(int j = i + 1; j < 5; j++){
                if(cards[i].getNum() > cards[j].getNum()){
                    Card temp = cards[j];
                    cards[j] = cards[i];
                    cards[i] = temp;
                }
            }
        }
        return cards;
    }
    
    public void output(){
        switch(rank){
            case 0:
                System.out.println(playersString[r] + "-high");
                break;
            case 1:
                System.out.println("Pair of "+ playersString[r] + "s");
                break;
            case 2:
                System.out.println(playersString[r1] + "s over " + playersString[r2] + "s");
                break;
            case 3:
                System.out.println("Three " + playersString[r] + "s");
                break;
            case 4:
                System.out.println(playersString[r] + "-high straight");
                break;
            case 5:
                System.out.println(playersString[r] + "-high flush");
                break;
            case 6:
                System.out.println(playersString[r1] + "s full of " + playersString[r2] + "s");
                break;
            case 7:
                System.out.println("Four " + playersString[r] + "s");
                break;
            case 8:
                System.out.println(playersString[r] + "-high straight flush");
                break;
        }
        
    }
}
