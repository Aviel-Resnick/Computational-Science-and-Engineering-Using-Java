/*
 * Write an iterative factorial method.
 */
package iterativefactorial;

/**
 *
 * @author Aviel Resnick
 */
public class IterativeFactorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test case should return 3628800.0
        double x = 10.0;
        System.out.println(factorial(x));
    }
    
    public static double factorial(double x) {
        // Will be multiplied iterativly (and result in the answer)
        double product = 1;
        // Constant y
        double y = x;
        
        // Loop x times, decreasing the multiplier each time
        for(int i = 0; i < y; i = i + 1){
            product = product * x;
            x = x - 1.0;
        }
        
        return product;
    }
    
}
