/*
 * Rational.java
 */
package rational;

/**
 *
 * @author Aviel Resnick
 */
public class Rational {
    
    // Two integers; numerator and denomerator
    int num, den;
    
    // Constructor which takes no arguments, and sets num to 0, and den to 1
    public Rational() {
        this.num = 0;
        this.den = 1;
    }
    
    // A second constructor, which takes two integers, and initializes instance variables
    public Rational(int num, int den) {
        this.num = num;
        this.den = den;
    }
    // Takes a Rational object, and prints it in a "resonable" form
    public static void printRational(Rational r){
        System.out.println(r.num + "/" + r.den);
    }
    
    // Negates the numerator
    public static void negate(Rational r) {
        r.num = r.num * -1;
    }
    
    // Inverses the Fraction
    public static void inverse(Rational r) {
        int a = r.num;
        
        r.num = r.den;
        r.den = a;
    }
    
    // Expresses the fraction as a double
    public static double toDouble(Rational r) {
	double num = r.num;
	double den = r.den;
	return num/den;
    }
    
    // Recursivly Indentifies GCD
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        
        int r = a % b;
        return gcd(b, r);
    }
    
    // Simplifies Fractions
    public static void reduce(Rational r){
        int gcd = gcd(r.num, r.den);
        
        r.num = r.num / gcd;
        r.den = r.den / gcd;
    }
    
    // returns the sum of the two rational numbers
    public static Rational add(Rational r1, Rational r2) {
	int num = r1.num * r2.den + r1.den * r2.num;
	int den = r1.den * r2.den;
        
	Rational newRational = new Rational(num, den);
	reduce(newRational);
	return newRational;
}
    public static void main(String[] args) {
        // Test case (2/6)
        Rational rationalTest = new Rational();
        rationalTest.num = 2;
        rationalTest.den = 6;
        printRational(rationalTest);
        
        // Negates Numerator
        negate(rationalTest);
        printRational(rationalTest);
        
        // Inverses (Reciprical)
        inverse(rationalTest);
        printRational(rationalTest);
        
        // Check Bool Value
        System.out.println(toDouble(rationalTest));
        
        // Reduces
        reduce(rationalTest);
        printRational(rationalTest);
        
        // Creates two Rational Objects (1/2 & 3/4), and Adds them
        Rational rational2 = new Rational();
        rational2.num = 1;
        rational2.den = 2;
        
        Rational rational3 = new Rational();
        rational3.num = 1;
        rational3.den = 4;
        
        printRational(add(rational2, rational3));
    }
    
}
