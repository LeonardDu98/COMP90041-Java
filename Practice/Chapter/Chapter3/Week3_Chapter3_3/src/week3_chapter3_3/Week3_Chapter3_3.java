/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_chapter3_3;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week3_Chapter3_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int flag_system = 1;
        do{
            System.out.printf("Please input the mass of a car: ");
            double mass = sc.nextDouble();
            sc.nextLine();
            System.out.println("Please input 1 or 2: 1 is earth, and 2 is moon: ");
            int flag = sc.nextInt();
            sc.nextLine();
            double weight;
            switch (flag){
                case 1:
                    weight = mass * 9.81;
                    System.out.printf("The weight in %s is %f N.%n", "earth", weight);
                    break;
                case 2:
                    weight = mass * 9.81 / 6;
                    System.out.printf("The weight in %s is %f N.%n", "moon", weight);
                    break;
            }
            System.out.println("If U want to quit, please input '0'.");
            
            if(sc.nextInt() == 0){//sc.nextLine() == "wq"
                flag_system = 0;
            }
        }while (flag_system == 1);
    }
    
}
