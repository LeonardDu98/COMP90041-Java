/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

import java.text.DecimalFormat;

/**
 *
 * @author holden
 */
public class Week2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.printf("This is the %n char of %c cool hu!", 65);
        DecimalFormat a = new DecimalFormat("#0.###E0");
        DecimalFormat b = new DecimalFormat("##0.##E0");
        double c = 123.456789;
        System.out.println(a.format(c));
        System.out.println(b.format(12345));
    }
    
}
