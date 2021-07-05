/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author holden
 */
public class Week4_Chapter4_14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = null;
        try{
            sc = new Scanner(new FileInputStream("Week4_Chapter4_14.csv"));
        } catch (FileNotFoundException e){
            System.out.println("Someting wrong!");
            System.exit(0);
        }
        String words = "";
        while(sc.hasNextLine()){
            words += sc.nextLine() + ",";
        }
        
        StringTokenizer st = new StringTokenizer(words, "\n,");
        String[] name = new String[5];
        for(int i = 0; i < 5; i++){
            name[i] = st.nextToken();
        }
        
        ArrayList<Integer> star = new ArrayList<Integer>();
        for(int i = 0; i < 5; i++){
            System.out.printf("%s ",name[i]);
        }
        System.out.println("");
        int j = 0;
        double count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;
        double sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0, sum5 = 0;
        while(st.hasMoreTokens()){
            int k = Integer.parseInt(st.nextToken());
            System.out.print(k + " ");
            switch (j % 5){
                case 0:
                    if(k == 0){
                        break;
                    }
                    count1++;
                    sum1 += k;
                    break;
                case 1:
                    if(k == 0){
                        break;
                    }
                    count2++;
                    sum2 += k;
                    break;
                case 2:
                    if(k == 0){
                        break;
                    }
                    count3++;
                    sum3 += k;
                    break;
                case 3:
                    if(k == 0){
                        break;
                    }
                    count4++;
                    sum4 += k;
                    break;
                case 4:
                    System.out.println("");
                    if(k == 0){
                        break;
                    }
                    count5++;
                    sum5 += k;
                    break;
                default:
                    break;
            }
            j++;
        }
        
        System.out.println(name[0] + " " + sum1/count1);
        System.out.println(name[1] + " " + sum2/count2);
        System.out.println(name[2] + " " + sum3/count3);
        System.out.println(name[3] + " " + sum4/count4);
        System.out.println(name[4] + " " + sum5/count5);
    } 
}

