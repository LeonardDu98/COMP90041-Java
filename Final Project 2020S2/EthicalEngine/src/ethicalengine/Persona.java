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
public abstract class Persona {
    public enum Gender{FEMALE, UNKNOWN, MALE};
    public enum BodyType{ATHLETIC, OVERWEIGHT, UNSPECIFIED, AVERAGE};
    
    private int age;
    private Gender gender;
    private BodyType bodyType;

    public Persona() {
        age = 0;
        gender = Gender.UNKNOWN;
        bodyType = BodyType.UNSPECIFIED;
    }
    
    Persona(int newAge, Gender newGender, BodyType newBodyType){
        if(validAge(newAge)){
            age = newAge;
        }else{
            age = 0;
        }
        gender = newGender;
        bodyType = newBodyType;
    }
    
    Persona(Persona otherPersona){
        age = otherPersona.age;
        gender = otherPersona.gender;
        bodyType = otherPersona.bodyType;
    }

    private boolean validAge(int age){
        return age >= 0;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        if(validAge(newAge)){
            age = newAge;
        }
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender newGender) {
        gender = newGender;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType newBodyType) {
        bodyType = newBodyType;
    }   
}
