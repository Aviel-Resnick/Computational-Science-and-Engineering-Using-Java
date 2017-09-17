/*
 * Write a method called squareRoot that takes a double as a parameter and
 * that returns an approximation of the square root of the parameter, using this
 * technique.  You may not use Math.sqrt
 *
 */
package squareroot;

/**
 *
 * @author Aviel Resnick
 */
public class SquareRoot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test case should result in 3
        double a = 9;
        double x0 = a/2;
        
        // Output of the test case
        System.out.println(squareRoot(a, x0));
    }
    
    public static double squareRoot(double a, double x0){
        // initial calculation
        double x1 = (x0 + (a/x0))/2;
        
        // loop checking for difference
        while (Math.abs(x1-x0) > 0.0001){
            x0 = x1;
            x1 = (x0 + (a/x0))/2;
        }
        
        // once the difference is small enough, return x1
        return(x1);
    }
    
}
