/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_12;

/**
 *
 * @author holden
 */
public class Pizza {
    private String size;
    private int numCheese;
    private int numPepperoni;
    private int numHam;
    
    public Pizza(){
        size = "No size yet";
        numCheese = 0;
        numPepperoni = 0;
        numHam = 0;
    }
    
    public Pizza(String size){
        if(size.equals("Small") || size.equals("Medium") || size.equals("Large")){
            this.size = size;
        }else{
            System.out.println("Wrong Size.");
            System.exit(0);
        }
        numCheese = 0;
        numPepperoni = 0;
        numHam = 0;
    }
    
    public Pizza(String size, int numCheese, int numPepperoni, int numHam){
        if(numPepperoni < 0 || numHam < 0 || 
                numCheese < 0 || 
                !(size.equals("Small") 
                || size.equals("Medium") 
                || size.equals("Large"))){
            System.out.println("Wrong");
            System.exit(0);
        }else{
            this.size = size;
            this.numCheese = numCheese;
            this.numPepperoni = numPepperoni;
            this.numHam = numHam;
        }
    }
    
    public String getSize(){
        return size;
    }
    
    public int getNumCheese(){
        return numCheese;
    }
    
    public int getNumPepperoni(){
        return numPepperoni;
    }
    
    public int getNumHam(){
        return numHam;
    }
    
    public void setSize(String size){
        if(size.equals("Small") || size.equals("Medium") || size.equals("Large")){
            this.size = size;
        }else{
            System.out.println("Wrong Size.");
            System.exit(0);
        }
    }
    
    public void setNumCheese(int numCheese){
        if(numCheese > 0){
            this.numCheese = numCheese;
        }else{
            System.out.println("Wrong Size.");
            System.exit(0);
        }
    }
    
    public void setNumPepperoni(int numPepperoni){
        if(numPepperoni > 0){
            this.numPepperoni = numPepperoni;
        }else{
            System.out.println("Wrong Size.");
            System.exit(0);
        }
    }
    public void setNumHam(int numHam){
        if(numHam > 0){
            this.numHam = numHam;
        }else{
            System.out.println("Wrong Size.");
            System.exit(0);
        }
    }
    
    public void set(String size, int numCheese, int numPepperoni, int numHam){
        if(numPepperoni < 0 || numHam < 0 || 
                numCheese < 0 || 
                !(size.equals("Small") 
                || size.equals("Medium") 
                || size.equals("Large"))){
            System.out.println("Wrong");
            System.exit(0);
        }else{
            this.size = size;
            this.numCheese = numCheese;
            this.numPepperoni = numPepperoni;
            this.numHam = numHam;
        }
    }
    
    public double calcCost(){
        if(size.equals("Small")){
            return (numHam + numPepperoni + numCheese) * 2 + 10;
        }
        if(size.equals("Large")){
            return (numHam + numPepperoni + numCheese) * 2 + 14;
        }
        if(size.equals("Medium")){
            return (numHam + numPepperoni + numCheese) * 2 + 14;
        }
        return 0;
    }
    
    public void getDescription(){
        System.out.println("Size: " + size);
        System.out.println("Contain: " + numCheese + " Cheese, "
                + numPepperoni + " Pepperoni and " + numHam + " Hams.");
        System.out.println("Cost: " + calcCost());
    }
}
