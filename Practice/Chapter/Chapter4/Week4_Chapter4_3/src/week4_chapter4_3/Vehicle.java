/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_3;

/**
 *
 * @author holden
 */
public class Vehicle {
    private int tanksize = 0;
    private int fuelInTank = 0;
    private int efficiency = 0;
    public void setTanksize(int tanksize){
        this.tanksize = tanksize;
    }
    public void setFuelInTank(int fuelInTank){
        this.fuelInTank = fuelInTank;
    }
    public void setEfficieny(int efficiency){
        this.efficiency = efficiency;
    }
    public int addPetrol(){
        return tanksize - fuelInTank;
    }
    public int driveTo(){
        return fuelInTank * efficiency;
    }
}
