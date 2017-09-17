/*
 * Aviel Resnick
 * Tests Fermat's last theorem using ints: a,b,c,n
 */
package checkfermat;

/**
 *
 * @author Aviel Resnick
 */
public class CheckFermat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test Cases
        int a = 1;
        int b = 2;
        int c = 3;
        int n = 4;
        
        // Checks for valid n term, and then tests the cases for validation
        if (n > 2 && checkFermat(a,b,c,n) == true) {
            System.out.println("Holy smokes, Fermat was wrong!");
        }
        // All others cases result in the following output
        else {
            System.out.println("No, that doesn’t work.");
        }
    }
    
    public static boolean checkFermat (int a, int b, int c, int n) {
        // a,b,c to the power of n
        int newA = raiseToPow(a,n);
        int newB = raiseToPow(b,n);
        int newC = raiseToPow(c,n);
        
        // Tests in terms of the theorem
        if (newA + newB == newC) {
            return true;
        }
        else{
            return false;
        }
    }
    
    // raiseToPow (Copied from the lesson)
    public static int raiseToPow (int x, int n) {
        double xn;
        xn = Math.pow((double)x, (double)n);
        return (int)xn;
    }
}
