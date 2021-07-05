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
public class Game {
    public Game(String[] gameCards){

        if(gameCards.length < 1 || (gameCards.length) % 5 != 0){
            System.out.println("Error: wrong number of arguments must be a multiple of 5");
            System.exit(0);
        }
        Card[] cards = new Card[5];
        for(int i = 0; i < 5; i++){
            cards[i] = new Card();
        }
        int playerNum = (gameCards.length) / 5;
        Player[] players = new Player[playerNum];
        for(int i = 0; i < playerNum; i++){
            players[i] = new Player();
        }
        for(int i = 0; i < playerNum; i++){
            for(int j = 0; j < 5; j++){
                cards[j].setCard(gameCards[i * 5 + j]);
            }
            players[i].setPlayer(cards);
        }
        ComparePlayers(players);
    }
    
    private void ComparePlayers(Player[] players){
        for(int i = 0; i < players.length; i++){
            System.out.printf("Player " + (i + 1) + ": ");
            players[i].output();
        }
        
        if(players.length == 1)
            return;
        Player max = new Player();
        int maxPostion = 0;
        for(int i = 0; i < players.length; i++){
            if(players[i].Larger(max)){
                max = players[i];
                maxPostion = i;
            }
        }
        int count = 0;
        for(int i = 0; i < players.length; i++){
            if(players[i].equalTo(max) && i != maxPostion){
                count++;
            }
        }
        if(count == 0){
            System.out.println("Player " + (maxPostion + 1) + " wins.");
        } else {
            System.out.print("Players ");
            for(int i = 0; i < players.length; i++){
                if(players[i].equalTo(max)){
                    if(count == 1){
                        System.out.print((i + 1) + " and ");
                    }
                    if(count == 0){
                        System.out.print((i + 1) + " draw.");
                    }
                    if(count > 1){
                        System.out.print((i + 1) + ", ");
                    }
                    count--;
                }
            }
            System.out.println("");
        }
    }
}
