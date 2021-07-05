/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week4_chapter4_10;

/**
 *
 * @author holden
 */
public class Week4_Chapter4_10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pet a = new Pet();
        System.out.println(a.toString());
        Pet b = new Pet("bbb");
        System.out.println(b.toString());
        Pet c = new Pet(3);
        System.out.println(c.toString());
        Pet d = new Pet(4.4);
        System.out.println(d.toString());
        Pet e = new Pet("eee", 5, 5.5, "cat");
        System.out.println(e.toString());
        System.out.println("------------------");
        
        a.setAge(1);
        a.setName("aaa");
        a.setType("cat");
        a.setWeight(1.1);
        System.out.println(a.getAge());
        System.out.println(a.getName());
        System.out.println(a.getType());
        System.out.println(a.getWeight());
        
        Pet f = new Pet();
        f.set("fff", 6, 6.6, "cat");
        System.out.println(f.toString());
        
        System.out.printf("%.6f%n",a.acepromazine());
        System.out.printf("%.6f%n",f.acepromazine());
        
        System.out.printf("%.6f%n",a.carprofen());
        System.out.printf("%.6f%n",f.carprofen());
    }
    
}
