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
public class PizzaOrder {
    private Pizza a = new Pizza();
    private Pizza b = new Pizza();
    private Pizza c = new Pizza();
    private int numPizzas;
    
    public PizzaOrder(){
        numPizzas = 0;
    }
    
    public void setNumPizzas(int numPizzas){
        if(0 <= numPizzas && numPizzas <= 3){
            this.numPizzas = numPizzas;
        }else{
            System.out.println("Wrong num");
            System.exit(0);
        }    
    }
    
    public void setPizza1(Pizza pizza1){
        if(numPizzas >= 1){
            a.set(pizza1.getSize(), pizza1.getNumCheese(), pizza1.getNumPepperoni(), pizza1.getNumHam());
        }else{
            System.out.println("U don't have Pizza1.");
        }
    }
    
    public void setPizza2(Pizza pizza2){
        if(numPizzas >= 2){
            b.set(pizza2.getSize(), pizza2.getNumCheese(), pizza2.getNumPepperoni(), pizza2.getNumHam());
        }else{
            System.out.println("U don't have Pizza2.");
        }
    }
    
    public void setPizza3(Pizza pizza3){
        if(numPizzas >= 3){
            c.set(pizza3.getSize(), pizza3.getNumCheese(), pizza3.getNumPepperoni(), pizza3.getNumHam());
        }else{
            System.out.println("U don't have Pizza3.");
        }
    }
    
    public double calcTotal(){
        return a.calcCost() + b.calcCost() + c.calcCost();
    }
}
