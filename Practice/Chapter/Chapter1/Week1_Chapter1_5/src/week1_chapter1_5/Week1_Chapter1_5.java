/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1_chapter1_5;

/**
 *
 * @author holden
 */
public class Week1_Chapter1_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String test = "I hate u";
        int a = test.indexOf("hate");
        System.out.println(test.substring(0, a) + "love" + test.substring(a + 4));
    }
    
}
