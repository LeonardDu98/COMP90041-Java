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
public class Week4_Chapter4_9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        animal a = new animal("aaa");
        animal b = new animal("bbb", 100);
        animal c = new animal("ccc", 100, 0.1);
        animal d = new animal("ddd", -0.05);
        animal e = new animal("eee", 123, 0.4);
        e.setGrowthRate(0.1);
        e.setPopulation(100);
        e.setname("ccc");
        a.getString();
        b.getString();
        c.getString();
        d.getString();
        e.getString();
        System.out.println(e.equals(c));
        System.out.println(d.endangered());
    }
    
}
