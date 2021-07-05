/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;

/**
 *
 * @author holden
 */
public class Movie {
    private String title;
    private int rank;
    private int time;
    
    public Movie(){
        title = "no title";
        rank = 0;
        time = 0;
    }
    
    public Movie(String title, int rank, int time){
        this.title = title;
        this.rank = rank;
        this.time = time;
    }
    
    public String getTitle(){
        return title;
    }
    public int getRank(){
        return rank;
    }
    public int gettime(){
        return time;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    public void setRank(int rank){
        this.rank = rank;
    }
    public void settime(int time){
        this.time = time;
    }
    
}
