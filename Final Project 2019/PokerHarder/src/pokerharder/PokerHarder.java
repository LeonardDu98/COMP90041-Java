package pokerharder;

import java.util.ArrayList;

/**
 * Represent a poker game.
 * This file can run to get javadoc if you need by adding package command.
 * @author Name: Zongcheng DU.
 * @author ID: zongchengd.
 * @version 2019.1004
 * @since 1.8.
 * @see java.util.ArrayList
 */
public class PokerHarder {

    /**
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //Test length error of args.        
        if(args.length < 1 || args.length % 5 != 0){
            System.out.println("Error: wrong number of arguments; must be a multiple of 5");
            System.exit(0);
        }
        
        //The number of player(s) we need to create.
        int playerNum = args.length / 5;
        
        //New every player and output every player's cards type using for loop.
        Player[] players = new Player[playerNum]; //Create Player arrays for all players in game.
        for(int i = 0; i < playerNum; i++){
            String[] temp = new String[5];
            for(int j = 0; j < 5; j++){
                temp[j] = args[i *  5 + j];
            }
            players[i] = new Player(temp);
            System.out.println("Player " + (i + 1) + ": " + players[i]);
        }
        
        if(playerNum == 1) System.exit(0); //End program when there is only 1 player.
        
        //Try to find the winner using for loop and Player method larger().
        Player maxPlayer = new Player(players[0]);
        for(int i = 0; i < playerNum; i++){
            if(players[i].larger(maxPlayer)) maxPlayer = new Player(players[i]);
        }

        ArrayList max = new ArrayList();//Record which player(s) have the same cards with winner.
        for(int i = 0; i < playerNum; i++){
            if(players[i].equal(maxPlayer)) max.add(i + 1);
        }
        
        //Output game results for only one winner or more than one winner(draw) .
        if(max.size() == 1){
            System.out.println("Player " + max.get(0) + " wins.");
        } else {
            System.out.print("Players");
            for(int i = 0; i < max.size(); i++){
                if(i == max.size() - 1) System.out.println(" " + max.get(i) + " draw.");
                else if(i == max.size() - 2) System.out.print(" " + max.get(i) + " and");
                else System.out.print(" " + max.get(i) + ",");  
            }
        }
    }
}
