/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ethicalengine;

import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author leonard
 */
public class ScenarioGenerator {
    private Random random = new Random();
    
    private int passengerCountMinimum;
    private int passengerCountMaximum;
    private int pedestrianCountMinimum;
    private int pedestrianCountMaximum;
    
    public ScenarioGenerator(){
        setDefault();
    }
    
    public ScenarioGenerator(long seed){
        random.setSeed(seed);
        setDefault();
    }
    
    public ScenarioGenerator(long seed, int newPassengerCountMinimum,
            int newPassengerCountMaximum, int newPedestrianCountMinimum,
            int newPedestrianCountMaximum){
        
        setDefault();
        if(newPassengerCountMaximum - newPassengerCountMinimum >= 0){
            passengerCountMaximum = newPassengerCountMaximum;
            passengerCountMinimum = newPassengerCountMinimum;
        }
        if(newPedestrianCountMaximum - newPedestrianCountMinimum >= 0){
            pedestrianCountMaximum = newPedestrianCountMaximum;
            pedestrianCountMinimum = newPedestrianCountMinimum;
        }
        random.setSeed(seed);
    }
    
    private void setDefault(){
        passengerCountMaximum = 5;
        passengerCountMinimum = 1;
        pedestrianCountMaximum = 5;
        pedestrianCountMinimum = 1;
    }
    
    public void setPassengerCountMin(int min){
        if(passengerCountMaximum - min >= 0){
            if(min >= 1){
                passengerCountMinimum = min;
            }
        }
    }

    public void setPassengerCountMax(int max) {
        if(max - passengerCountMinimum >= 0){
            passengerCountMaximum = max;
        }
    }

    public void setPedestrianCountMin(int min) {
        if(pedestrianCountMaximum - min >= 0){
            if(min >= 1){
                pedestrianCountMinimum = min;
            }
        }  
    }

    public void setPedestrianCountMax(int max) {
        if(max - pedestrianCountMinimum >= 0){
            pedestrianCountMaximum = max;
        }
    }
    
    public Human getRandomHuman(){
        //public Human(int age, Profession profession, Gender gender, BodyType bodytype, boolean isPregnant){
        int age = random.nextInt(120); // [0, 100)
        
        Persona.Gender gender;
        Persona.Gender[] genders = Persona.Gender.values();
        gender = genders[random.nextInt(genders.length)];
        
        Persona.BodyType bodyType;
        Persona.BodyType[] bodyTypes = Persona.BodyType.values();
        bodyType = bodyTypes[random.nextInt(bodyTypes.length)];
        
        Human.Profession profession;
        Human.Profession[] professions = Human.Profession.values();
        profession = professions[random.nextInt(professions.length)];
        
        boolean isPregnant = random.nextBoolean();
        
        Human result = new Human(age, profession, gender, bodyType, isPregnant);
        
        return result;       
    }
    
    public Animal getRandomAnimal(){
        String species;
        Animal.Species[] specieses = Animal.Species.values();
        species = specieses[random.nextInt(specieses.length)].toString().toLowerCase();

        return new Animal(species, random.nextBoolean());
    }
    
    private Persona getRandomPersona(){
        return random.nextBoolean() ? getRandomHuman() : getRandomAnimal();
    }
    
    public Scenario generate(){
        int passengerNum = passengerCountMinimum;
        passengerNum += random.nextInt(passengerCountMaximum - passengerCountMinimum + 1);
        
        ArrayList<Persona> passengers = new ArrayList<>();
        while(passengers.size() < passengerNum){
            passengers.add(getRandomPersona());
        }
        
        int pedestrianNum = pedestrianCountMinimum;
        pedestrianNum += random.nextInt(pedestrianCountMaximum - pedestrianCountMinimum + 1);
        
        ArrayList<Persona> pedestrians = new ArrayList<>();
        while(pedestrians.size() < pedestrianNum){
            pedestrians.add(getRandomPersona());
        }
        
        int yourPosition = random.nextInt(passengerNum + pedestrianNum);
        if(yourPosition < passengerNum){
            if(passengers.get(yourPosition) instanceof Human){
                ((Human)passengers.get(yourPosition)).setAsYou(true);
            }
        }else{
            yourPosition -= passengerNum;
            if(pedestrians.get(yourPosition) instanceof Human){
                ((Human)pedestrians.get(yourPosition)).setAsYou(true);
            }
        }
        
        boolean isLegalCrossing = random.nextBoolean();
        
        Persona[] passengersArray = passengers.toArray(new Persona[passengerNum]);
        Persona[] pedestriansArray = pedestrians.toArray(new Persona[pedestrianNum]);
        
        return new Scenario(passengersArray, pedestriansArray, isLegalCrossing);
    }
    
}
