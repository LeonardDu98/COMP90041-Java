/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nimsys;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author leonard
 */
public class NimPlayer {
    private String userName;
    private String givenName;
    private String familyName;
    private int gamePlayed;
    private int gameWon;
    private boolean IsAI;
    
    public NimPlayer(){
        userName = "";
        givenName = "";
        familyName = "";
        gamePlayed = 0;
        gameWon = 0;
        IsAI = false;
    }

    public NimPlayer(String userName, String givenName, String familyName, int gamePlayed, int gameWon, boolean IsAI) {
        this.userName = userName;
        this.givenName = givenName;
        this.familyName = familyName;
        this.gamePlayed = gamePlayed;
        this.gameWon = gameWon;
        this.IsAI = IsAI;
    }
    
    public NimPlayer(NimPlayer another) {
        this.userName = another.getUserName();
        this.givenName = another.getGivenName();
        this.familyName = another.getFamilyName();
        this.gamePlayed = another.getGamePlayed();
        this.gameWon = another.getGameWon();
        this.IsAI = another.getIsAI();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    private void setGamePlayed(int gamePlayed) {
        this.gamePlayed = gamePlayed;
    }

    private void setGameWon(int gameWon) {
        this.gameWon = gameWon;
    }

    public String getUserName() {
        return userName;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getGamePlayed() {
        return gamePlayed;
    }

    public int getGameWon() {
        return gameWon;
    }
    
    public void reset(){
        setGamePlayed(0);
        setGameWon(0);
    }
    
    public boolean isSame(NimPlayer anotherPlayer){
        return anotherPlayer.getUserName().equals(userName);
    }
    
    public void display(){
        System.out.println(userName + "," + givenName + "," + 
                familyName + "," + gamePlayed + " games," + gameWon + " wins");
    }
    
    public String writeData(){
        return userName + "," + givenName + "," + familyName + "," + gamePlayed + "," + gameWon + "," + IsAI +"\n";
    }
    
    public double winRate(){
        return gamePlayed == 0 ? 0 : (double)gameWon / gamePlayed;
    }
    
    public void history(){
        NumberFormat np = NumberFormat.getPercentInstance();
        np.setMinimumFractionDigits(0);
        DecimalFormat df=new DecimalFormat("00");
        System.out.printf("%-5s| %s games | %s %s%n", np.format(winRate()), df.format(gamePlayed), givenName, familyName);
    }
    
    public String fullName(){
        return givenName + " " + familyName;
    }
    
    public void win(){
        gameWon++;
    }
    
    public void finishGame(){
        gamePlayed++;
    }
    
    public boolean getIsAI(){
        return IsAI;
    }
}
