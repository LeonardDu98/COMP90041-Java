/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ethicalengine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author leonard
 */
public class Scenario {
    private ArrayList<Character> passengers;
    private ArrayList<Character> pedestrians;
    private boolean isLegalCrossing;
    
    public Scenario(Character[] passengers, Character[] pedestrians, boolean isLegalCrossing){
        this.passengers = new ArrayList<>(Arrays.asList(passengers));
        this.pedestrians = new ArrayList<>(Arrays.asList(pedestrians));
        this.isLegalCrossing = isLegalCrossing;
    }
    
    public boolean hasYouInCar(){
        for(int i = 0; i < passengers.size(); i++){
            //if(passengers.get(i) instanceof Person){
              //  if(((Person)passengers.get(i)).isYou()){
                //    return true;
                //}
            //}
            
            if(passengers.get(i).isYou()){
                return true;
            }
        }
        return false;
        /*
        for(Character person : passengers){
            if(person.isYou() == true){
                return true;
            }
        }
        */
        /*
        if (passengers.stream().anyMatch((person) -> (person.isYou() == true))) {
            return true;
        }
        */
        /*
        return passengers.stream().anyMatch((person) -> (person.isYou() == true));
        */
    }
    
    public boolean hasYouInLane(){
        for(int i = 0; i < pedestrians.size(); i++){
            //if(passengers.get(i) instanceof Person){
              //  if(((Person)passengers.get(i)).isYou()){
                //    return true;
                //}
            //}
            
            if(pedestrians.get(i).isYou()){
                return true;
            }
        }
        return false;
    }
    
    public Character[] getPassengers(){
        return passengers.toArray(new Character[passengers.size()]);
    }
    
    public Character[] getPedestrians(){
        return pedestrians.toArray(new Character[pedestrians.size()]);
    }

    public boolean isLegalCrossing() {
        return isLegalCrossing;
    }

    public void setLegalCrossing(boolean isLegalCrossing) {
        this.isLegalCrossing = isLegalCrossing;
    }
    
    public int getPassengerCount(){
        return passengers.size();
    }
    
    public int getPedestrianCount(){
        return pedestrians.size();
    }
    
    
    @Override
    public String toString(){
        String result = "======================================\n" +
                        "# Scenario\n" +
                        "======================================\n";
        result += "Legal Crossing: " + (isLegalCrossing ? "yes" : "no") + "\n";
        
        result += "Passengers (" + passengers.size() + ")\n";
        for(int i = 0; i < passengers.size(); i++){
            result += "- " + passengers.get(i).toString() + "\n";
        }
        
        result += "Pedestrians (" + pedestrians.size() + ")\n";
        for(int i = 0; i < pedestrians.size(); i++){
            result += "- " + pedestrians.get(i).toString();
            if(i != (pedestrians.size() - 1)){
                result += "\n";
            }
        }
        
        System.out.println(result);
        return result;
    }
}
