/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checker;

/**
 *
 * @author holden
 */
public class Checker {
    private boolean isRed;
    private int row;
    private int column;
    
    public Checker(boolean isRed){
        row = 1;
        column = 1;
        this.isRed = isRed;
    }
    
    public Checker(boolean isRed, int row, int column){
        this.isRed = isRed;
        if(isAvailable(row, column)){
            this.row = row;
            this.column = column;
        } else {
            this.row = 1;
            this.column = 1;
        }
    }
    
    public void move(int rows, int columns){
        if((rows != 1 && rows != -1) || (columns != 1 && columns != -1)){
            return;
        }
        if((rows > 0 && isRed == true) || (rows < 0 && isRed == false)){
            return;
        }
        if(!isAvailable(row + rows, column + columns)){
            return;
        }
        row += rows;
        column += columns;
    }
    
    public boolean isRed(){
        return isRed;
    }
    
    public int getRow(){
        return row;
    }
    
    public int getColumn(){
        return column;
    }
            
    private boolean isAvailable(int row, int column){
        return row >= 1 &&
                row <= 8 &&
                column >= 1 &&
                column <= 8 &&
                row % 2 == column % 2;
    }
}
