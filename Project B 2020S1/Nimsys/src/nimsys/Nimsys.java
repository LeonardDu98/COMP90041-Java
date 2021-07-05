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
    static NimPlayer[] allPlayers = new NimPlayer[100];
    static int playerNum = 0;
    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Welcome to Nim");
        while(true){
            System.out.println("");
            System.out.print("$");
            String commond = sc.nextLine();
            String[] subCommonds = commond.split(" ");
            if(subCommonds[0].equals("addplayer")){
                String[] addplayer = subCommonds[1].split(",");
                addPlayer(addplayer[0], addplayer[1], addplayer[2]);
            }
            
            if(subCommonds[0].equals("removeplayer")){
                if(subCommonds.length == 1){
                    removePlayer();
                }else{
                    removePlayer(subCommonds[1]);
                }
            }
            
            if(subCommonds[0].equals("editplayer")){
                String[] editplayer = subCommonds[1].split(",");
                editPlayer(editplayer[0], editplayer[1], editplayer[2]);
            }
            
            if(subCommonds[0].equals("resetstats")){
                if(subCommonds.length == 1){
                    resetStats();
                }else{
                    resetStats(subCommonds[1]);
                }
            }
            
            if(subCommonds[0].equals("displayplayer")){
                if(subCommonds.length == 1){
                    displayPlayer();
                }else{
                    displayPlayer(subCommonds[1]);
                }
            }
            
            if(subCommonds[0].equals("rankings")){
                if(subCommonds.length == 1){
                    rank();
                }else{
                    rank(subCommonds[1]);
                }
            }
            
            if(subCommonds[0].equals("startgame")){
                String[] startgame = subCommonds[1].split(",");
                startGame(Integer.parseInt(startgame[0]), Integer.parseInt(startgame[1]), startgame[2], startgame[3]);
            }
            
            if(subCommonds[0].equals("exit")){
                exit();
            }
        }
    }
    
    public static void addPlayer(String userName, String familyName, String givenName){
        if(isExist(userName) != -1){
            System.out.println("The player already exists.");
            return;
        }
        allPlayers[playerNum++] = new NimPlayer(userName, familyName, givenName);
        sortedAlpha();
    }
    
    public static void removePlayer(String userName){
        if(isExist(userName) == -1){
            System.out.println("The player does not exist.");
            return;
        }
        for(int i = isExist(userName); i < playerNum - 1; i++){
            allPlayers[i] = new NimPlayer(allPlayers[i + 1]);
        }
        allPlayers[playerNum--] = null;
    }
    
    public static void removePlayer(){
        System.out.println("Are you sure you want to remove all players? (y/n)");
        if(sc.nextLine().equals("y")){
            allPlayers = new NimPlayer[100];
            playerNum = 0;
        }
    }
    
    private static int isExist(String userName){
        for(int i = 0; i < playerNum; i++){
            if(allPlayers[i].getUserName().equals(userName)){
                return i;
            }
        }
        return -1;
    }
    
    public static void editPlayer(String userName, String familyName, String givenName){
        if(isExist(userName) == -1){
            System.out.println("The player does not exist.");
            return;
        }
        allPlayers[isExist(userName)].setFamilyName(familyName);
        allPlayers[isExist(userName)].setGivenName(givenName);
    }
    
    public static void resetStats(String userName){
        if(isExist(userName) == -1){
            System.out.println("The player does not exist.");
            return;
        }
        allPlayers[isExist(userName)].reset();
    }
    
    public static void resetStats(){
        System.out.println("Are you sure you want to reset all player statistics? (y/n)");
        if(sc.nextLine().equals("y")){
            for(int i = 0; i < playerNum; i++){
                allPlayers[i].reset();
            }
        }
    }
    
    public static void displayPlayer(String userName){
        if(isExist(userName) == -1){
            System.out.println("The player does not exist.");
            return;
        }
        allPlayers[isExist(userName)].display();
    }
    
    public static void displayPlayer(){
        for(int i = 0; i < playerNum; i++){
                allPlayers[i].display();
        }
    }
    
    public static void rank(String order){
        NimPlayer[] afterSort = sortWinRate();
        if(order.equals("asc")){
            for(int i = playerNum; i > 0; i--){
                afterSort[i - 1].history();
            }
        }else if(order.equals("desc")){
            for(int i = 0; i < playerNum; i++){
                afterSort[i].history();
            }
        }
    }
    
    public static void rank(){
        rank("desc");
    }
    
    public static NimPlayer[] sortWinRate(){
        NimPlayer[] sorted = new NimPlayer[100];
        for(int i = 0; i < playerNum; i++){
            sorted[i] = new NimPlayer(allPlayers[i]);
        }
        for(int i = 0; i < playerNum - 1; i++){
            for(int j = i + 1; j < playerNum; j++){
                if(sorted[j].winRate() > sorted[i].winRate()){
                    NimPlayer temp = new NimPlayer(sorted[i]);
                    sorted[i] = new NimPlayer(sorted[j]);
                    sorted[j] = new NimPlayer(temp);
                }
            }
        }
        return sorted;
    }
    
    public static void sortedAlpha(){
        for(int i = 0; i < playerNum - 1; i++){
            for(int j = i + 1; j < playerNum; j++){
                if(allPlayers[j].getUserName().compareTo(allPlayers[i].getUserName()) < 0){
                    NimPlayer temp = new NimPlayer(allPlayers[i]);
                    allPlayers[i] = new NimPlayer(allPlayers[j]);
                    allPlayers[j] = new NimPlayer(temp);
                }
            }
        }
    }
    
    public static void exit(){
        System.out.println("");
        System.exit(0);
    }
    
    public static void startGame(int initialStones,int upperbound, String userName1,String userName2){
        if(isExist(userName1) == -1 || isExist(userName2) == -1){
            System.out.println("One of the players does not exist.");
            return;
        }
        NimGame newGame = new NimGame(initialStones, upperbound, allPlayers[isExist(userName1)], allPlayers[isExist(userName2)]);
        newGame.game(sc);
    }
}
