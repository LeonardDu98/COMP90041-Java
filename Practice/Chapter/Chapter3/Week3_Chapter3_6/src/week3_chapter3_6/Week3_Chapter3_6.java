/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3_chapter3_6;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week3_Chapter3_6 {
    public static final int daysOfPeriod = 5;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int flag = 1;
        Scanner sc  =new Scanner(System.in);
        do{
            System.out.println("Please input the num of green cruds: ");
            int num = sc.nextInt();
            sc.nextLine();
            System.out.println("Please input the num of days: ");
            int days = sc.nextInt();
            sc.nextLine();
            int period = days / daysOfPeriod;
            int sumNow = 0, sumOld1 = 0, sumOld2 = num;
            for(int i = 0; i <= period; i++){
                sumNow = sumOld1 + sumOld2;
                sumOld2 = sumOld1;
                sumOld1 = sumNow;
                System.out.printf("In period %d, the num of beans is %d.%n", i, sumNow);
            }
            System.out.println("If you want to continue, please input 1");
            flag = sc.nextInt();
        } while(flag == 1);
     
    }
    
}
