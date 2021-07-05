/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week5_chapter4_15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author holden
 */
public class Week5_Chapter4_15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = null;
        try{
            sc = new Scanner(new FileInputStream("Week5_Chapter4_15.csv"));
        }catch(FileNotFoundException e){
            System.out.println("Wrong");
            System.exit(0);
        }
        
        String words = "";
        while(sc.hasNextLine()){
            words += sc.nextLine() + ",";
        }
        
        StringTokenizer st = new StringTokenizer(words, "\n,");
        for(int i = 0; i < 5; i++){
            st.nextToken();
        }
        
        int[][] num = new int[3][5];
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 5; i++){
                num[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Please input your poll(A-D):");
        int[] input = new int[4];
        for(int i = 0; i < 4; i++){
            input[i] = sc1.nextInt();
        }
        
        int flag = 1000;
        int result = 0;
        for(int i = 0; i < 3; i++){
            int temp = 0;
            for(int j = 0; j < 4; j++){
                temp += Math.abs(input[j] - num[i][j]);
            }
            if(temp < flag){
                flag = temp;
                result = i;
            }
        }
        System.out.println("I think your poll of E is " + num[result][4]);
    }
    
}
