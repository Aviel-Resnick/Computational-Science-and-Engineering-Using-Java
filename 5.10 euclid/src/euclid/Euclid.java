/*
 * Exercise 6.10
 * 
 * The following algorithm is known as Euclid's Algorithm because it appears 
 * in Euclid's Elements (Book 7, ca. 300 B.C.).  It may be the oldest 
 * nontrivial algorithm.  
 * 
 * The algorithm is based on the observation that, if r is the remainder when
 * a is divided by b, then the common divisors of a and b are the same as the 
 * common divisors of b and r.  Thus we can use the equation
 *     gcd(a,b) = gcd(b,r)
 * to successively reduce the problem of computing a GCD to the problem of 
 * computing the GCD of smaller and smaller pairs of integers.  For example,
 *     gcd(36,20) = gcd(20,16) = gcd(16,4) = gcd(4,0) = 4
 * implies that the GCD of 36 and 20 is 4.  It can be shown that for any two
 * starting numbers, this repeated reduction eventually produces a pair when
 * the second number is 0.  Then the GCD is the other number in the pair.
 * 
 * Write a method called gcd that takes two integer parameters and that uses
 * Euclid's algorithm to compute and return the greatest common divisor of the
 * two numbers.  
 * 
 */
package euclid;

/**
 *
 * @author Aviel
 */
public class Euclid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 32;
        int b = 64;
        
        System.out.println(gcd(a,b));
    }
    
    public static int gcd(int a, int b) {
        int gcdResult = 0;
        
        if (b == 0){
            gcdResult = a;
        }
        else {
            gcdResult = gcd(b, a % b);
        }
        return gcdResult;
    } 
}
