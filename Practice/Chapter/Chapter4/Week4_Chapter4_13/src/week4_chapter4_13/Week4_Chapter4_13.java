/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week4_Chapter4_13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc1 = new Scanner(System.in);
        Scanner sc = null;
        try{
            sc = new Scanner(new FileInputStream("Week4_Chapter4_13.txt"));
        } catch (FileNotFoundException e){
            System.out.println("Someting wrong!");
            System.exit(0);
        }
        ArrayList fruits = new ArrayList();
        while(sc.hasNextLine()){
            fruits.add(sc.nextLine());
        }
        BoxOfProduce box = new BoxOfProduce();
        box.set(box.getRandom(fruits), box.getRandom(fruits), box.getRandom(fruits));
        System.out.println(box.toString());
        int choose = sc1.nextInt();
        sc1.nextLine();
        System.out.println(fruits.toString());
        String update = sc1.nextLine();
        switch(choose){
            case 1:
                box.setFruit1(update);
                break;
            case 2:
                box.setFruit2(update);
                break;
            case 3:
                box.setFruit3(update);
                break;
            default:
                System.out.println("Wrong");
                break;
        }
        System.out.println(box.toString());
    }
    
}
