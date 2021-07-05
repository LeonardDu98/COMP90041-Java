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
public class Person extends Character{
    public enum Profession{DOCTOR, CEO, CRIMINAL, HOMELESS, UNEMPLOYED, STUDENT, ENGINEER, UNKNOWN};
    public enum AgeCategory{BABY, CHILD, ADULT, SENIOR};
    
    private Profession profession;
    private boolean isPregnant;
    private boolean isYou;
    
    public Person(int age, Profession profession, Character.Gender gender, Character.BodyType bodytype, boolean isPregnant){
        super(age, gender, bodytype);
        
        this.profession = profession;
        if(!getAgeCategory().equals(AgeCategory.ADULT)){
            this.profession = Profession.UNKNOWN;
        }
        
        this.isPregnant = isPregnant;
        if(!gender.equals(Character.Gender.FEMALE)){
            this.isPregnant = false;
        }
        this.isYou = false;
    }
    
    public Person(Person otherPerson){
        super(otherPerson);
        this.profession = otherPerson.profession;
        this.isPregnant = otherPerson.isPregnant;
        this.isYou = otherPerson.isYou;
    }
    
    public AgeCategory getAgeCategory(){
        if(super.getAge() <= 4){
            return AgeCategory.BABY;
        }else if(super.getAge() <= 16){
            return AgeCategory.CHILD;
        }else if(super.getAge() <= 68){
            return AgeCategory.ADULT;
        }else{
            return AgeCategory.SENIOR;
        }
    }

    public Profession getProfession() {
        return profession;
    }

    public boolean isPregnant() {
        return isPregnant;
    }

    public void setPregnant(boolean isPregnant) {
        this.isPregnant = isPregnant;
    }
    
    @Override
    public boolean isYou(){
        return isYou;
    }
    
    public void setAsYou(boolean isYou){
        this.isYou = isYou;
    }
    
    @Override
    public String toString(){
        String result = "";
        if(isYou == true){
            result += "you ";
        }
        
        result += super.getBodyType().toString().toLowerCase() + " ";
        result += getAgeCategory().toString().toLowerCase() + " ";
        
        if(getAgeCategory().equals(AgeCategory.ADULT)){
            result += getProfession().toString().toLowerCase() + " ";
        }
        
        result += super.getGender().toString().toLowerCase();
        
        if(isPregnant == true){
            result += " pregnant";
        }
        return result;
    }
}
