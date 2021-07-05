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
public class Animal extends Character{
    
    public enum Species{CAT, DOG, BIRD, DINOSAUR};//?
    
    private String species;
    private boolean isPet;
    
    public Animal(String species){
        super();
        this.species = species.toLowerCase();
        this.isPet = true;//???
    }
    
    public Animal(int age, Character.Gender gender, String species, boolean isPet){
        super.setAge(age);
        super.setGender(gender);
        this.species = species.toLowerCase();
        this.isPet = isPet;
    }
    
    public Animal(Animal otherAnimal){
        super(otherAnimal);
        this.species = otherAnimal.species;
        this.isPet = otherAnimal.isPet;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
    
    public boolean isPet(){
        return isPet;
    }
    
    //public void setIsPet(boolean isPet){
      //  this.isPet = isPet;
    //}
    
    @Override
    public String toString(){
        return species + (isPet ? " is pet" : "");
    }
    
    @Override
    public boolean isYou(){
        return false;
    }
    
    @Override
    public void setAsYou(boolean isYou){
        //nonthing at here.
    }
}
