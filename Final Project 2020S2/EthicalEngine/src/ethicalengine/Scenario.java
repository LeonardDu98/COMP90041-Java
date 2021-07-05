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
    private ArrayList<Persona> passengers = new ArrayList<>();
    private ArrayList<Persona> pedestrians = new ArrayList<>();
    private boolean isLegalCrossing;
    
    public Scenario(Persona[] passengers, Persona[] pedestrians, boolean isLegalCrossing){
        this.passengers.addAll(Arrays.asList(passengers));
        this.pedestrians.addAll(Arrays.asList(pedestrians));
        this.isLegalCrossing = isLegalCrossing;
    }
    
    public Scenario(ArrayList<Persona> passengers, ArrayList<Persona> pedestrians){
        this.passengers = passengers;
        this.pedestrians = pedestrians;
    }
    
    public boolean hasYouInCar(){
        for(int i = 0; i < passengers.size(); i++){
            Persona temp = passengers.get(i);
            if(temp instanceof Human){
                return ((Human) temp).isYou();
            }
        }
        return false;
    }
    
    public boolean hasYouInLane(){
        for(int i = 0; i < pedestrians.size(); i++){
            Persona temp = pedestrians.get(i);
            if(temp instanceof Human){
                return ((Human) temp).isYou();
            }
        }
        return false;
    }

    public Persona[] getPassengers() {
        Persona[] result = new Persona[getPassengerCount()];
        return passengers.toArray(result);
    }

    public Persona[] getPedestrians() {
        Persona[] result = new Persona[getPedestrianCount()];
        return pedestrians.toArray(result);
    }

    public boolean isLegalCrossing() {
        return isLegalCrossing;
    }

    public void setLegalCrossing(boolean newIsLegalCrossing) {
        isLegalCrossing = newIsLegalCrossing;
    }
    
    public int getPassengerCount(){
        return passengers.size();
    }
    
    public int getPedestrianCount(){
        return pedestrians.size();
    }
    
    @Override
    public String toString(){
        String result = "======================================\n# Scenario\n" +
                "======================================\nLegal Crossing: ";
        result = result + (isLegalCrossing ? "yes" : "no");
        result = result + "\n";
        
        result += "Passengers (" + getPassengerCount() + ")";
        for(int i = 0; i < passengers.size(); i++){
            result += "\n- " + passengers.get(i);
        }
        
        result += "\n";
        
        result += "Pedestrians (" + getPedestrianCount() + ")";
        for(int i = 0; i < pedestrians.size(); i++){
            result += "\n- " + pedestrians.get(i);
        }
        
        return result;
    }
}
