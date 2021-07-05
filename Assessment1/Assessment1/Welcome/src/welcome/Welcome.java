/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package welcome;

/**
 *
 * @author holden
 */
public class Welcome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String first = args[0];
        String second = args[1];
        System.out.println("Hello "+ first + " "+ second + ".");
        System.out.printf("Is that %s %s or %s %s?", first, second.toUpperCase(), first.toUpperCase(), second);
    }
    
}
