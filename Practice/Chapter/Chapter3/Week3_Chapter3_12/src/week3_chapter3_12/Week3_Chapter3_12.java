/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_chapter3_12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week3_Chapter3_12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        Scanner sc = null;
        try{
            sc = new Scanner(new FileInputStream("Week3_Chapter3_12.txt"));
        } catch (FileNotFoundException e){
            System.out.println("Someting wrong!");
            System.exit(0);
        }
        ArrayList name = new ArrayList();
        ArrayList inch = new ArrayList();
        ArrayList foot = new ArrayList();
        while(sc.hasNextLine()){
            name.add(sc.nextLine());
            inch.add(sc.nextInt());
            foot.add(sc.nextInt());
            if(sc.hasNextLine()){
                sc.nextLine();
            }
        }
        ArrayList weight = new ArrayList();
        for(int i = 0; i < name.size(); i++){
            weight.add((((int)inch.get(i) - 5) * 12 + (int)foot.get(i)) * 5 + 100);
        }
        for(int i = 0; i < name.size(); i++){
            System.out.printf("%s's ideal weight is %d.%n", name.get(i), weight.get(i));
        }
    }
    
}
