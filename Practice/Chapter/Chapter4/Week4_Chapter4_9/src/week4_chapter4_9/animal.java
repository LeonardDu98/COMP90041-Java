/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_9;

/**
 *
 * @author holden
 */
public final class animal {
    private String name;
    private int population;
    private double growthRate;
    
    public animal(String name){
        setanimal(name, 0, 0);
    }
    
    public animal(String name, int population){
        setanimal(name, population, 0);
    }
    
    public animal(String name, double growthRate){
        setanimal(name, 0, growthRate);
    }
    
    public animal(String name, int population, double growthRate){
        setanimal(name, population, growthRate);
    }
    
    public void setname(String name){
        this.name = name;
    }
    
    public void setPopulation(int population){
        this.population = population;
    }
    
    public void setGrowthRate(double growthRate){
        this.growthRate = growthRate;
    }
    
    public void setanimal(String name, int population, double growthRate){
        this.name = name;
        this.population = population;
        this.growthRate = growthRate;
    }
    
    public int getPopulation(){
        return population;
    }
    
    public String getName(){
        return name;
    }
    
    public double getGrowthRate(){
        return growthRate;
    }
    
    public void getString(){
        System.out.println("Name: "+name);
        System.out.println("Population: " + population);
        System.out.printf("GrowthRate: %.2f.%n", growthRate);
    }
    
    public boolean equals(animal x){
        return name.equals(x.name) && population == x.population && growthRate == x.growthRate;
    }
    
    public boolean endangered(){
        return growthRate < 0;
    }
}
