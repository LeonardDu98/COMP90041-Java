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
public class Week4_Chapter4_12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PizzaOrder order = new PizzaOrder();
        System.out.println(order.calcTotal());
        Pizza a = new Pizza("Small", 1, 1, 1);
        Pizza b = new Pizza("Medium", 2, 2, 2);
        Pizza c = new Pizza("Large", 3, 3, 3);
        order.setNumPizzas(3);
        order.setPizza1(a);
        order.setPizza2(b);
        order.setPizza3(c);
        a.getDescription();
        b.getDescription();
        c.getDescription();
        System.out.println(order.calcTotal());
    }
    
}
