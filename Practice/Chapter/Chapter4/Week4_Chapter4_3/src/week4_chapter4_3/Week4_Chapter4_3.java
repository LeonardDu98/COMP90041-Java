/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_3;

import java.util.Scanner;

/**
 *
 * @author holden
 */
public class Week4_Chapter4_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vehicle ve = new Vehicle();
        Scanner sc = new Scanner(System.in);
        System.out.print("Size of tank:");
        int TankSize = sc.nextInt();
        System.out.print("Fuel in tank :");
        int fuelInTank = sc.nextInt();
        System.out.print("Efficiency(how many kilometers does vehicle run in 1 litre fuel):");
        int Efficiency = sc.nextInt();
        ve.setEfficieny(Efficiency);
        ve.setFuelInTank(fuelInTank);
        ve.setTanksize(TankSize);
        int needToAdd = ve.addPetrol();
        int maxDistance = ve.driveTo();
        System.out.printf("You need to add %d litres to make full.%n", needToAdd);
        System.out.printf("You can run %d kilometers using left fuels.%n", maxDistance);
    }
    
}
