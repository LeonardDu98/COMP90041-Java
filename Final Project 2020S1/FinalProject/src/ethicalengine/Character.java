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
public abstract class Character {
    public enum Gender{MALE, FEMALE, UNKNOWN};
    public enum BodyType{AVERAGE, ATHLETIC, OVERWEIGHT, UNSPECIFIED};
    
    private int age;
    private Gender gender;
    private BodyType bodyType;
    
    public Character(){
        age = 0;
        gender = Gender.UNKNOWN;
        bodyType = BodyType.UNSPECIFIED;
    }

    public Character(int age, Gender gender, BodyType bodyType) {
        this.age = age >= 0 ? age : 0;
        this.gender = gender;
        this.bodyType = bodyType;
    }
    
    public Character(Character c){
        this.age = c.age;
        this.gender = c.gender;
        this.bodyType = c.bodyType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }
    
    public abstract boolean isYou();
    public abstract void setAsYou(boolean isYou);
}
