/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokersimpler;

/**
 *
 * @author holden
 */
public class PokerSimpler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if(args.length > 5){
            System.out.println("NOT UNDERTAKEN");
            System.exit(0);
        }
        
        if(args.length < 1 || args.length % 5 != 0){
            System.out.println("Error: wrong number of arguments; must be a multiple of 5");
            System.exit(0);
        }
        
        Player aPlayer = new Player(args);
        System.out.println(aPlayer);
    }
    
}
