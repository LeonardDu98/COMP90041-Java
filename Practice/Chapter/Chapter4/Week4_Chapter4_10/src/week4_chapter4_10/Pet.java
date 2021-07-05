/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_10;

/**
 *
 * @author holden
 */
public class Pet {
    private String name;
    private int age; //in years
    private double weight;//in pounds
    private String type;
    
    public String toString(){
        return("Name: "+ name + " Age: " + age + " years"
                + "\nWeight: " + weight + " pounds"
                + "\nType: "+ type);
    }
    public Pet(String name, int age, double weight, String type){
        this.name = name;
        if(age < 0 || weight < 0){
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }else{
            this.age = age;
            this.weight = weight;
        }
        if(type.equals("cat") || type.equals("dog")){
            this.type = type;
        } else {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }
    }
    
    public Pet(String name){
        this.name = name;
        this.age = 0;
        this.weight = 0;
        this.type = "No type yet.";
    }
    
    public Pet(int age){
        this.name = "No name yet.";
        this.weight = 0;
        if(age < 0){
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }else{
            this.age = age;
        }
        this.type = "No type yet.";
    }
    
    public Pet(double weight){
        this.name = "No name yet.";
        this.age = 0;
        this.type = "No type yet.";
        if(weight < 0){
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }else{
            this.weight = weight;
        }
    }
    
    public Pet(){
        this.age = 0;
        this.weight = 0;
        this.name = "No name yet.";
        this.type = "No type yet.";
    }
    
    public void set(String name, int age, double weight, String type){
        this.name = name;
        if(age < 0 || weight < 0){
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }else{
            this.age = age;
            this.weight = weight;
        }
        if(type.equals("cat") || type.equals("dog")){
            this.type = type;
        } else {
            System.out.println("Error: Negative age or weight.");
            System.exit(0);
        }
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setType(String type){
        if(type.equals("cat") || type.equals("dog")){
            this.type = type;
        } else {
            System.out.println("Error: Wrong type.");
            System.exit(0);
        }
    }
    
    public void setAge(int age){
        if(age < 0){
            System.out.println("Error: Negative age");
            System.exit(0);
        }else{
            this.age = age;
        }
    }
    
    public void setWeight(double weight){
        if(weight < 0){
            System.out.println("Error: Negative weight.");
            System.exit(0);
        }else{
            this.weight = weight;
        }
    }
    
    public String getName(){
        return name;
    }
    
    public String getType(){
        return type;
    }
    
    public int getAge(){
        return age;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public double acepromazine(){
        if(type.equals("dog")){
            return weight / 2.2 * 0.03 / 10;
        }
        return weight / 2.2 * 0.002 / 10;
    }
    
    public double carprofen(){
        if(type.equals("dog")){
            return weight / 2.2 * 0.5 / 12;
        }
        return weight / 2.2 * 0.25 / 12;
    }
}

