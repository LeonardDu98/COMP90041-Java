/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_1;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week4_Chapter4_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PrintCodeword code = new PrintCodeword();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input startNum:");
        int startNum = sc.nextInt();
        System.out.println("Please input startchar:");
        char startChar = sc.next().charAt(0);
        code.set(startNum, startChar);
        code.printCode();
    }
    
}