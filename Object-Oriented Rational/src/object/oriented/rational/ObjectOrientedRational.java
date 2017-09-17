/*
 * Question 1:
 * Transform the methods in the Rational class from class methods to
 * object methods, and make the necessary changes in main.
 *
 * Question 2:
 * Make a few mistakes. Try invoking class methods as if they were object
 * methods and vice-versa. Try to get a sense for what is legal and what
 * is not, and for the error messages that you get when you mess up.
 *
 * Question 3:
 * Think about the pros and cons of class and object methods. Which
 * is more concise (usually)? Which is a more natural way to express
 * computation (or, maybe more fairly, what kind of computations can be
 * expressed most naturally using each style)?
 */
package object.oriented.rational;

/**
 *
 * @author Aviel Resnick
 */
public class ObjectOrientedRational {
    
    int numerator;
    int denominator;

    // A constructor which takes no arguments
    public ObjectOrientedRational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    // Constructer with parameters n and d (numerator and denominator)
    public ObjectOrientedRational(int n, int d) {
        this.numerator = n;
        this.denominator = d;
    }
    
    public static void main(String[] args) {
        // NULL
    }
    
    // Prints a rational object
    public void printRational() {
        System.out.println(this.numerator +  "/"  + this.denominator);
    }

    // Reverses the sign of a rational number
    public void negate() {
        this.numerator = this.numerator * -1;
        if(this.denominator <= 0) {
            this.numerator = this.numerator * -1;
            this.denominator = this.denominator * -1;
        }
    }

    // Reverses Numerator and Denominator
    public void invert() {
        int tempA = this.numerator;
        int tempB = this.denominator;

        this.numerator = tempA;
        this.denominator = tempB;
    }

    // Convert to double
    public double toDouble() {
        return ((double) this.numerator) / ((double) this.denominator);
    }

    // Reduces and prints a rational value
    public void reduce() {
        int remain, num1, num2;
        num1 = this.numerator;
        num2 = this.denominator;
        remain = num1 % num2;
        while(remain != 0) {
            remain = num1 % num2 ;
            num1 = num2;
            num2 = remain;
        }
        int GCD = num1;

        ObjectOrientedRational ret = new ObjectOrientedRational(this.numerator/GCD, this.denominator/GCD);

        ret.printRational();
    }

    // Adds two rational values
    public ObjectOrientedRational add(ObjectOrientedRational that) {
        ObjectOrientedRational retAdd = new ObjectOrientedRational(0, 0);
        if(this.denominator == that.denominator) 
        {
            retAdd.numerator = this.numerator + that.numerator;
            retAdd.denominator = this.denominator;
            return retAdd;
        } 
        else 
        {
            retAdd.numerator = this.numerator * that.denominator;
            retAdd.denominator = this.denominator * that.denominator;

            that.numerator = that.numerator * this.denominator;
            that.denominator = that.denominator * this.denominator;

            retAdd.numerator += that.numerator;

            int remain, num1, num2;
            num1 = retAdd.numerator;
            num2 = retAdd.denominator;
            remain = num1 % num2;
            while(remain != 0) {
                remain = num1 % num2 ;
                num1 = num2;
                num2 = remain;
            }
            int GCD = num1;

            retAdd.numerator = retAdd.numerator/GCD;
            retAdd.denominator = retAdd.denominator/GCD;

            return retAdd;
        }
    }
}