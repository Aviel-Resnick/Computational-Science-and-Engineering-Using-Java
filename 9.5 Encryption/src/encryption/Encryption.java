/*
 * 
 * Many encryption algorithms depend on the ability to raise large integers
 * to an integer power.  Here is a method that implements a (reasonably) fast
 * algorithm for integer exponentiation.  
 * public static int pow(int x, int n) {
 *     if (n==0) return 1;
 *     
 *     // find x to the n/2 recursively
 *     int t = pow(x, n/2);
 *     
 *     // if n is even, the result is t squared
 *     // if n is odd, the result is t squared times x
 *     
 *     if (n%2 == 0) {
 *         return t*t;
 *     } else {
 *         return t*t*x;
 *     }
 * }
 * 
 * The problem with this method is that it will only work if the result is 
 * smaller than 2 billion.  Rewrite it so that the result is a BigInteger.
 * The parameters should still be integers, though.
 * 
 * You can use the BigInteger methods add and multiply, but don't use the 
 * built-in pow method, which would spoil the fun.
 * 
 */

package encryption;

/**
 *
 * @author Aviel
 */

import java.math.BigInteger;
public class Encryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test case
        System.out.println(pow(30, 30));
    }
    
    public static BigInteger pow(int x, int n) {
                // 0! = 1
		if (n == 0) return BigInteger.valueOf(1);
		
		// find x to the n/2 recursively. (Converted to BigInteger)
		BigInteger t = pow(x, n/2);
		
		// if n is even, the result is t squared
		// if n is odd, the result is t squared times x
		
                // Same procces, just using .multiply instead of *
		if (n%2 == 0) {
			return t.multiply(t);
		} else {
			return t.multiply(t).multiply(BigInteger.valueOf(x)); 
		}
	}
}