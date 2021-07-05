/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimsys;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
        
        String fileName = "players.dat";
        File fileObject = new File(fileName);
        if (fileObject.exists()) {
            readData();
        }
        
        System.out.println("Welcome to Nim");
        while(true){
            System.out.println("");
            System.out.print("$");
            String commond = sc.nextLine();
            String[] subCommonds = commond.split(" ");
            try{
                switch (subCommonds[0]) {
                    case "addplayer":
                        String[] addplayer = subCommonds[1].split(",");
                        addPlayer(addplayer[0], addplayer[1], addplayer[2]);
                        break;
                    case "addaiplayer":
                        String[] addaiplayer = subCommonds[1].split(",");
                        addAIPlayer(addaiplayer[0], addaiplayer[1], addaiplayer[2]);
                        break;
                    case "removeplayer":
                        if(subCommonds.length == 1){
                            removePlayer();
                        }else{
                            removePlayer(subCommonds[1]);
                        }   break;
                    case "editplayer":
                        String[] editplayer = subCommonds[1].split(",");
                        editPlayer(editplayer[0], editplayer[1], editplayer[2]);
                        break;
                    case "resetstats":
                        if(subCommonds.length == 1){
                            resetStats();
                        }else{
                            resetStats(subCommonds[1]);
                        }   break;
                    case "displayplayer":
                        if(subCommonds.length == 1){
                            displayPlayer();
                        }else{
                            displayPlayer(subCommonds[1]);
                        }   break;
                    case "rankings":
                        if(subCommonds.length == 1){
                            rank();
                        }else{
                            rank(subCommonds[1]);
                        }   break;
                    case "startgame":
                        String[] startgame = subCommonds[1].split(",");
                        startGame(Integer.parseInt(startgame[0]), Integer.parseInt(startgame[1]), startgame[2], startgame[3]);
                        break;
                    case "exit":
                        exit();
                        break;
                    default:
                        System.out.println("'" + subCommonds[0] + "' is not a valid command.");
                        break;
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Incorrect number of arguments supplied to command.");
            }
        }
    }
    
    public static void addPlayer(String userName, String familyName, String givenName){
        if(isExist(userName) != -1){
            System.out.println("The player already exists.");
            return;
        }
        allPlayers[playerNum++] = new NimHumanPlayer(userName, givenName, familyName, 0, 0, false);
        sortedAlpha();
    }
    
    public static void addAIPlayer(String userName, String familyName, String givenName){
        if(isExist(userName) != -1){
            System.out.println("The player already exists.");
            return;
        }
        allPlayers[playerNum++] = new NimAIPlayer(userName, givenName, familyName, 0, 0, true);
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
        if(order.equals("asc")){
            NimPlayer[] afterSort = sortWinRateAsc();
            for(int i = 0; i < playerNum; i++){
                afterSort[i].history();
            }
        }else if(order.equals("desc")){
            NimPlayer[] afterSort = sortWinRateDesc();
            for(int i = 0; i < playerNum; i++){
                afterSort[i].history();
            }
        }
    }
    
    public static void rank(){
        rank("desc");
    }
    
    public static NimPlayer[] sortWinRateDesc(){
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
    
    public static NimPlayer[] sortWinRateAsc(){
        NimPlayer[] sorted = new NimPlayer[100];
        for(int i = 0; i < playerNum; i++){
            sorted[i] = new NimPlayer(allPlayers[i]);
        }
        for(int i = 0; i < playerNum - 1; i++){
            for(int j = i + 1; j < playerNum; j++){
                if(sorted[j].winRate() < sorted[i].winRate()){
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
        writeData();
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
    
    public static void readData(){
        try{
            FileInputStream inputstream = new FileInputStream("players.dat");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream));
            String str;
            while((str = bufferedReader.readLine()) != null){
		String[] readData = str.split(",");
                allPlayers[playerNum++] = new NimPlayer(readData[0], readData[1], readData[2],
                        Integer.parseInt(readData[3]), Integer.parseInt(readData[4]), Boolean.parseBoolean(readData[5]));
            }
            inputstream.close();
            bufferedReader.close();
            sortedAlpha();
        }catch(FileNotFoundException e){
        }catch(IOException e){}
    }
    
    public static void writeData(){
        try{
            BufferedWriter out = new BufferedWriter(new FileWriter("players.dat"));
            for(int i = 0; i < playerNum; i++){
                out.write(allPlayers[i].writeData());
            }
            out.close();
        }catch(FileNotFoundException e){
        }catch(IOException e){
        }
    }
}


