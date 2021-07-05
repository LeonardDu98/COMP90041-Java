/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factors;

/**
 *
 * @author holden
 */
public class Factors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int a = Integer.parseInt(args[0]);
        for(int i = 1; i <= a; i++){
            if(a % i == 0){
                System.out.print(i);
                if(i == a){
                    System.out.println("");
                    continue;
                }
                System.out.print(" ");
            }
        }    
    }
    
}
