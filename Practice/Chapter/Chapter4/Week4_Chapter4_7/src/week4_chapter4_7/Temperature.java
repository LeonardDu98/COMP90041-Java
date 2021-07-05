/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_7;

/**
 *
 * @author holden
 */
public class Temperature {
    private double temperature;
    private char scale;
    
    public Temperature(){
        temperature = 0;
        scale = 'C';
    }
    
    public Temperature(double a){
        temperature = a;
        scale = 'C';
    }
    
    public Temperature(double a, char b){
        temperature = a;
        scale = b;
    }
    
    public Temperature(char b){
        temperature = 0;
        scale = b;
    }
    
    public double getTemperatureCelsius(){
        if(scale == 'C'){
            return temperature;
        }
        return 5 * (temperature - 32) / 9;
    }
    
    public double getTemperatureFahrenheit(){
        if(scale == 'F'){
            return temperature;
        }
        return (9 * temperature / 5) + 32;
    }
    
    public void setTemperature(double a){
        temperature = a;
    }
    
    public void setTemperature(double a, char b){
        temperature = a;
        scale = b;
    }
    
    public void setTemperature(char b){
        scale = b;
    }
    
    public boolean equals(Temperature x){
        double a = x.getTemperatureCelsius();
        double b = this.getTemperatureCelsius();
        return Math.abs(a - b) < 0.1;
    }
    
    public boolean greater(Temperature x){
        double a = x.getTemperatureCelsius();
        double b = this.getTemperatureCelsius();
        return b - a > 0.1;
    }
    
    public boolean smaller(Temperature x){
        double a = x.getTemperatureCelsius();
        double b = this.getTemperatureCelsius();
        return b - a < -0.1;
    }
    public void getString(){
        System.out.printf("Temperature : %.1f %c.%n", temperature, scale);
    }
}
