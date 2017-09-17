/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multadd;

/**
 *
 * @author Aviel Resnick
 */
public class Multadd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // test case 1,2,3
        System.out.println("Test computation: " + multadd(1.0, 2.0, 3.0));
        
        // 1st computation: sin(PI/4)+(cos(PI/4)/2
        double a = Math.sin(Math.PI/4);
        double b = 2.0;
        double c = Math.cos(Math.PI/4);
        
        System.out.println("1st computation: " + multadd(a,b,c));
        
        // 2nd computation: log(10) + log(20)
        double a2 = 1.0;
        double b2 = Math.log(10.0);
        double c2 = Math.log(20.0);
        
        System.out.println("2nd computation: " + multadd(a2,b2,c2));
        
        // Test yikes with 10.0
        System.out.println("3nd computation: " + yikes(10.0));
    }
    
    public static double multadd(double a, double b, double c) {
        // compute and return a*b+c
        double multadditionzation = a*b+c;
        return multadditionzation;
    }
    
    public static double yikes(double x) {
        double a3 = x;
        double b3 = Math.exp(-x);
        double c3 = Math.sqrt(1.0 - b3);
        return multadd(a3,b3,c3);
    }
}
