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
public class NimPlayer {
    private String name = "";
    
    public NimPlayer(){
        name = "";
    }
    
    public NimPlayer(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public int removeStone(Scanner sc){
        System.out.println(name + "'s turn - remove how many?");
        return sc.nextInt();
    }
}
