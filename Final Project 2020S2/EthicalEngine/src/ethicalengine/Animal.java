/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ethicalengine;

/**
 *
 * @author leonard
 */
public final class Animal extends Persona{
    public enum Species {HAUSKY, ALASKAN, LION};
    
    private String species;
    private boolean isPet = false;
    
    public Animal(){
        super();
        species = "";
    }
    
    public Animal(String newSpecies){
        super();
        species = newSpecies;
    }
    
    public Animal(String newSpecies, boolean isPet){
        super();
        species = newSpecies;
        this.isPet = isPet;
    }
    
    public Animal(Animal otherAnimal){
        super();
        species = otherAnimal.getSpecies();
        isPet = otherAnimal.isPet();
    }

    public String getSpecies() {
        return species.toLowerCase();
    }

    public void setSpecies(String newSpecies) {
        species = newSpecies;
    }

    public boolean isPet() {
        return isPet;
    }

    public void setPet(boolean newIsPet) {
        isPet = newIsPet;
    }
    
    @Override
    public String toString(){
        return getSpecies() + (isPet == true ? " is pet" : "");
    }
}
