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
public final class Human extends Persona{
    public enum Profession{UNEMPLOYED, DOCTOR, CEO, NONE, CRIMINAL, HOMELESS, PROFESSOR, LECTURER}//2 more
    public enum AgeCategory{SENIOR, CHILD, BABY, ADULT}
    
    private Profession profession;
    private boolean isPregnant;
    private AgeCategory ageCategory;
    private boolean isYou = false;
    
    public Human(){
        super();
        profession = Profession.NONE;
        ageCategory = determineAgeCategory();
    }
    
    public Human(int age, Gender gender, BodyType bodytype){
        super(age, gender, bodytype);
        profession = Profession.NONE;
        ageCategory = determineAgeCategory();
    }
    
    public Human(int age, Profession newProfession, Gender gender, BodyType bodytype, boolean newIsPregnant){
        super(age, gender, bodytype);
        ageCategory = determineAgeCategory();
        profession = this.getAgeCategory() == AgeCategory.ADULT ? newProfession : Profession.NONE;

        if(validPregnant()){
            isPregnant = newIsPregnant;
        }
    }

    private boolean validPregnant(){
        return super.getGender() == Gender.FEMALE;
    }
    
    public Human(Human otherHuman){
        super(otherHuman);
        profession = otherHuman.getProfession();
        isPregnant = otherHuman.isPregnant();
        ageCategory = otherHuman.getAgeCategory();
        isYou = otherHuman.isYou();
    }
    
    private AgeCategory determineAgeCategory(){
        int age = super.getAge();
        if(age < 17 && age > 4){
            return AgeCategory.CHILD;
        }
        if(age < 69 && age > 16){
            return AgeCategory.ADULT;
        }
        if(age > 68){
            return AgeCategory.SENIOR;
        }
        return AgeCategory.BABY;
    }
    
    public AgeCategory getAgeCategory(){
        return determineAgeCategory();
    }

    public Profession getProfession() {
        return profession;
    }
    
    public void setProfession(Profession newProfession){
        this.profession = newProfession;
    }

    public void setPregnant(boolean newIsPregnant) {
        if(validPregnant()){
            isPregnant = newIsPregnant;
        }
    }

    public boolean isPregnant() {
        return isPregnant;
    }

    public void setAsYou(boolean newIsYou) {
        isYou = newIsYou;
    }

    public boolean isYou() {
        return isYou;
    }

    
    @Override
    public String toString(){
        ageCategory = determineAgeCategory();
        String result;
        if(isYou){
            result = "you ";
        }else{
            result = "";
        }

        result = result + super.getBodyType().toString().toLowerCase() + " " + ageCategory.toString().toLowerCase() + " ";

        if(ageCategory == AgeCategory.ADULT){
            result = result + profession.toString().toLowerCase() + " " + super.getGender().toString().toLowerCase();
        }else{
            result = result + super.getGender().toString().toLowerCase();
        }

        if(isPregnant){
            result += " pregnant";
        }

        return result;
    }  
}
