/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_7;

/**
 *
 * @author holden
 */
public class Week4_Chapter4_7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double x = 32;
        char c = 'F';
        Temperature a = new Temperature();
        a.getString();
        Temperature b = new Temperature(31,c);
        Temperature d = new Temperature(x,c);
        Temperature f = new Temperature(33,c);
        b.getString();
        d.getString();
        f.getString();
        System.out.println(a.getTemperatureFahrenheit());
        System.out.println(d.getTemperatureCelsius());
        System.out.println(a.equals(d));
        System.out.println(a.greater(d));
        System.out.println(a.smaller(d));
        System.out.println(a.equals(b));
        System.out.println(a.greater(b));
        System.out.println(a.smaller(b));
        System.out.println(a.equals(f));
        System.out.println(a.greater(f));
        System.out.println(a.smaller(f));
    }
    
}
