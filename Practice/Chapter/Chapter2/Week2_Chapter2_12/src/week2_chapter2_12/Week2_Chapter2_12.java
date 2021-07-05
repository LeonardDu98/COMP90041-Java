/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_chapter2_12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week2_Chapter2_12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = null;
        try{
            sc = new Scanner(new FileInputStream("Week2_Chapter2_12.txt"));
        }
        catch(FileNotFoundException e){
            System.out.println("File not find");
            System.exit(0);
        }
        String words;
        while(sc.hasNextLine() == true){
            System.out.println("Text has next line? " + sc.hasNextLine());
            words = sc.nextLine();
            int position = words.indexOf("hate");
            if(position >= 0){
                System.out.println(words.substring(0, position) + "love" + words.substring(position + 4));
            } else {
                System.out.println(words);
            }
        }
        System.out.println("Text has next line?" + sc.hasNextLine());
    }
    
}
