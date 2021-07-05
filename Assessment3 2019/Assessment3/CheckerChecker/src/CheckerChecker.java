/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author holden
 */
public class CheckerChecker {
    public static void main(String[] args){
        //BUG1
        Checker a = new Checker(true);
        if(a.isRed() != true || a.getRow() != 1 || a.getColumn() != 1){
            System.out.println("BUG");
            System.exit(0);
        }
        Checker b = new Checker(false);
        if(b.isRed() != false || b.getRow() != 1 || b.getColumn() != 1){
            System.out.println("BUG");
            System.exit(0);
        }
        
        //BUG2
        Checker c = new Checker(true, 3, 5);
        if(c.isRed() != true || c.getRow() != 3 || c.getColumn() != 5){
            System.out.println("BUG");
            System.exit(0);
        }
        //BUG3
        c.move(-1, 1);
        if(c.isRed() != true || c.getRow() != 2 || c.getColumn() != 6){
            System.out.println("BUG");
            System.exit(0);
        }
        //BUG4
        c.move(1, 1);
        if(c.isRed() != true || c.getRow() != 2 || c.getColumn() != 6){
            System.out.println("BUG");
            System.exit(0);
        }
        //BUG5
        c.move(-1, -3);
        if(c.isRed() != true || c.getRow() != 2 || c.getColumn() != 6){
            System.out.println("BUG");
            System.exit(0);
        }
        c.move(-3, -1);
        if(c.isRed() != true || c.getRow() != 2 || c.getColumn() != 6){
            System.out.println("BUG");
            System.exit(0);
        }
        //BUG6
        Checker e = new Checker(true, 3, 1);
        e.move(-1, -1);
        if(e.isRed() != true || e.getRow() != 3 || e.getColumn() != 1){
            System.out.println("BUG");
            System.exit(0);
        }
        //BUG7
        Checker f = new Checker(true, 2, 8);
        f.move(-1, 1);
        if(f.isRed() != true || f.getRow() != 2 || f.getColumn() != 8){
            System.out.println("BUG");
            System.exit(0);
        }
        //BUG8
        Checker g = new Checker(false, 8, 2);
        g.move(1, 1);
        if(g.isRed() != false || g.getRow() != 8 || g.getColumn() != 2){
            System.out.println("BUG");
            System.exit(0);
        }
        //BUG9
        Checker h = new Checker(true, 1, 7);
        h.move(-1, 1);
        if(h.isRed() != true || h.getRow() != 1 || h.getColumn() != 7){
            System.out.println("BUG");
            System.exit(0);
        }
        //BUG10
        Checker j = new Checker(true, 3, 8);
        if(j.isRed() != true || j.getRow() != 1 || j.getColumn() != 1){
            System.out.println("BUG");
            System.exit(0);
        }
        System.out.println("CORRECT");
    }
}
