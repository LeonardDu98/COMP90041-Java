/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ethicalengine;

import java.util.Random;

/**
 *
 * @author leonard
 */
public class ScenarioGenerator {
    private Random random;
    private int passengerCountMin;
    private int passengerCountMax;
    private int pedestrianCountMin;
    private int pedestrianCountMax;
    
    public ScenarioGenerator(){
        random = new Random();//seed time.
        passengerCountMin = 1;
        passengerCountMax = 5;
        pedestrianCountMin = 1;
        pedestrianCountMax = 5;
    }
    
    public ScenarioGenerator(long seed){
        random = new Random(seed);
        passengerCountMin = 1;
        passengerCountMax = 5;
        pedestrianCountMin = 1;
        pedestrianCountMax = 5;
    }
    
    public ScenarioGenerator(long seed, int passengerCountMinimum, int passengerCountMaximum, int pedestrianCountMinimum, int pedestrianCountMaximum){
        random = new Random(seed);
        passengerCountMin = passengerCountMinimum;
        pedestrianCountMin = pedestrianCountMinimum;
        passengerCountMax = passengerCountMaximum;
        pedestrianCountMax = pedestrianCountMaximum;
    }

    public void setPassengerCountMin(int passengerCountMin) {
        this.passengerCountMin = passengerCountMin;
    }

    public void setPassengerCountMax(int passengerCountMax) {
        this.passengerCountMax = passengerCountMax;
    }

    public void setPedestrianCountMin(int pedestrianCountMin) {
        this.pedestrianCountMin = pedestrianCountMin;
    }

    public void setPedestrianCountMax(int pedestrianCountMax) {
        this.pedestrianCountMax = pedestrianCountMax;
    }
    
    //int age, Profession profession, Gender gender, BodyType bodytype, boolean isPregnant   
    public Person getRandomPerson(){
        int age = random.nextInt(100);//?
        
        int professionRandom = random.nextInt(8);//8/9
        Person.Profession p = Person.Profession.values()[professionRandom];
        
        int genderRandom = random.nextInt(3);
        Person.Gender g = Person.Gender.values()[genderRandom];
        
        int bodyTypeRandom = random.nextInt(4);
        Person.BodyType bt = Person.BodyType.values()[bodyTypeRandom];
        
        boolean isPregnant = random.nextBoolean();
        return new Person(age, p, g, bt, isPregnant);
    }
    
    public Animal getRandomAnimal(){
        int age = random.nextInt(100);//?
        
        int genderRandom = random.nextInt(3);
        Animal.Gender g = Animal.Gender.values()[genderRandom];
        
        //int bodyTypeRandom = random.nextInt(4);
        //Animal.BodyType bt = Animal.BodyType.values()[bodyTypeRandom];
        
        int speciesRandom = random.nextInt(4);//???
        String s = Animal.Species.values()[speciesRandom].toString();
        
        boolean isPet = random.nextBoolean();
        
        //Animal temp = new Animal(s);
        //temp.setAge(age);
        //temp.setGender(g);
        //temp.setIsPet(isPet);
        
        //return temp;
        
        return new Animal(age, g, s, isPet);
    }
    
    //Character[] passengers, Character[] pedestrians, boolean isLegalCrossing
    public Scenario generate(){
        int passengersNum = random.nextInt(passengerCountMax - passengerCountMin + 1) + passengerCountMin;
        int pedestriansNum = random.nextInt(pedestrianCountMax - pedestrianCountMin + 1) + pedestrianCountMin;
        
        Character[] passengers = new Character[passengersNum];
        Character[] pedestrians = new Character[pedestriansNum];
        boolean isLegalCrossing = random.nextBoolean();
        
        for(int i = 0; i < passengersNum; i++){
            boolean isPerson = random.nextBoolean();
            passengers[i] = isPerson ? getRandomPerson() : getRandomAnimal();
        }
        
        for(int i = 0; i < pedestriansNum; i++){
            boolean isPerson = random.nextBoolean();
            pedestrians[i] = isPerson ? getRandomPerson() : getRandomAnimal();
        }
        
        int yourPosition = random.nextInt(3);//0:pass/1:peds/2:out
        if(yourPosition == 0){//in car
            passengers[random.nextInt(passengersNum)].setAsYou(true);
        }else if(yourPosition == 1){// on road
            pedestrians[random.nextInt(pedestriansNum)].setAsYou(true);
        }
        
        return new Scenario(passengers, pedestrians, isLegalCrossing);
    }
}
