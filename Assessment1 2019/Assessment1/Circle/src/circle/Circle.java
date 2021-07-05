/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circle;

/**
 *
 * @author holden
 */
public class Circle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double diameter = Double.parseDouble(args[0]);
        double area = Math.PI * Math.pow(diameter/2 , 2);
        System.out.printf("%.4f", area);
    }
    
}
