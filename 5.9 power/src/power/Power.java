/*
 * Exercise 6.9
 * Write a recursive method called power that takes a double x
 * and an integer n and that returns x^n
 *
 * Aviel Resnick
 */
package power;

/**
 *
 * @author Aviel
 */
public class Power {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test 3^3 (Expected Result = 9)
        System.out.println("The result of the test case 3^3 is: " + power(3,3));
    }
    
    public static double power(double x, int n) {
        // Always equal to 1
        double result = 0.0;
        if (n == 0) {
            result = 1.0;
        }
        
        // Recursive portion, until n is 0
        else if (n > 0) {
            result = x * power(x, n - 1);
        }
        
        return result;
    }
}
