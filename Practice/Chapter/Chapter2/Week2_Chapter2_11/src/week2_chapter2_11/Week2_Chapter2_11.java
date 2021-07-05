/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2_chapter2_11;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week2_Chapter2_11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        DecimalFormat percent = new DecimalFormat("00.00%");
        String name[] = new String[3];
        int score[] = new int[3];
        int possScore[] = new int[3];
        int totalScore = 0, totalPossScore = 0;
        for(int i = 0; i < 3; i++){
            System.out.printf("Name of exercise %d:%n",i + 1);
            name[i] = sc.nextLine();
            System.out.printf("Score of exercise %d:%n",i + 1);
            score[i] = sc.nextInt();
            totalScore += score[i];
            System.out.printf("Possbile score of exercise %d:%n",i + 1);
            possScore[i] = sc.nextInt();
            totalPossScore += possScore[i];
            sc.nextLine();
        }
        System.out.printf("%-15s%-5s%-15s%n", "Exercise", "Score", "Total Possible");
        for(int i = 0; i < 3; i++){
            System.out.printf("%-15s%-5d%-15d%n", name[i], score[i], possScore[i]);
        }
        System.out.printf("%-15s%-5d%-15d%n", "Total", totalScore, totalPossScore);

        System.out.printf("Your score is %d out of %d, or %s. %n", totalScore, totalPossScore, percent.format((double)totalScore/totalPossScore));
        
        /*
        String table[][] = new String[5][3];
        table[0][0] = "Exercise";
        table[0][1] = "Score";
        table[0][2] = "Total Possible";
        for(int i = 1; i < 4; i++){
            int j = 0;
            System.out.printf("Name of exercise %d:",i);
            table[i][j] = sc.nextLine();
            j++;
            System.out.printf("Score received for exercise %d:", i);
            table[i][j] = sc.nextLine();
            j++;
            System.out.printf("Total points possible for exercise %d:", i);
            table[i][j] = sc.nextLine();
        }
        int score = 0, totalProcess = 0;
        for(int i = 1; i < 4 ; i++){
            for(int j = 1; j < 3; j++){
                score += (int)table[i][j];
            }
        }
*/
        
    }
    
}
