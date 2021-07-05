/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_13;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author holden
 */
public class BoxOfProduce {
    private String fruit1;
    private String fruit2;
    private String fruit3;
    
    public BoxOfProduce(){
        fruit1 = "No fruit yet.";
        fruit2 = "No fruit yet.";
        fruit3 = "No fruit yet.";
    }
    
    public BoxOfProduce(String fruit1){
        this.fruit1 = fruit1;
        fruit2 = "No fruit yet.";
        fruit3 = "No fruit yet.";
    }
    
    public BoxOfProduce(String fruit1, String fruit2){
        this.fruit1 = fruit1;
        this.fruit2 = fruit2;
        fruit3 = "No fruit yet.";
    }
    
    public BoxOfProduce(String fruit1, String fruit2, String fruit3){
        this.fruit1 = fruit1;
        this.fruit2 = fruit2;
        this.fruit3 = fruit3;
    }
    
    public void set(String fruit1, String fruit2, String fruit3){
        this.fruit1 = fruit1;
        this.fruit2 = fruit2;
        this.fruit3 = fruit3;
    }
    
    public void setFruit1(String fruit1){
        this.fruit1 = fruit1;
    }
    
    public void setFruit2(String fruit2){
        this.fruit2 = fruit2;
    }
    
    public void setFruit3(String fruit3){
        this.fruit3 = fruit3;
    }
    
    public String getFruit1(){
        return fruit1;
    }
    
    public String getFruit2(){
        return fruit2;
    }
    
    public String getFruit3(){
        return fruit3;
    }
    
    public String toString(){
        return "Now Contain " + fruit1 + " " + fruit2 + " " + fruit3 + "."; 
    }
    
    public String getRandom(ArrayList fruits){
        Random ra = new Random();
        return (String)fruits.get(ra.nextInt(5));
    }
}
