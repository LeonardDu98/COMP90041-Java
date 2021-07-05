/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_1;

/**
 *
 * @author holden
 */
public class PrintCodeword {
    private int startNum;
    private char startChar;
    
    public void set(int startNum, char startChar){
        this.startNum = startNum;
        this.startChar = startChar;
    }
    
    public void printCode(){
        for(int i = 0; i < 26; i++){
            int num = (startNum + i) % 10;
            int a = (int)startChar;
            a = (a - 65 + i) % 26 + 65;
            System.out.printf("%s%d%n", (char)a, num);
        }
    }
}
