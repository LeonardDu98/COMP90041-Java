/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_11;

/**
 *
 * @author holden
 */
public class Week4_Chapter4_11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pizza a = new Pizza();
        Pizza b = new Pizza("Small");
        Pizza c = new Pizza("Medium", 1, 1, 1);
        a.getDescription();
        b.getDescription();
        c.getDescription();
        c.setSize("Large");
        c.setNumCheese(2);
        c.setNumHam(2);
        c.setNumPepperoni(2);
        System.out.println(c.getSize());
        System.out.println(c.getNumCheese());
        System.out.println(c.getNumHam());
        System.out.println(c.getNumPepperoni());
        
        a.set("Large", 5, 5, 5);
        a.getDescription();
        
    }
    
}
