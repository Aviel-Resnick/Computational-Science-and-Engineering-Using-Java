/*
 * Calculates all Prime Factors

 * Utilizes: 
    Recursion
    Math
    Arrays
    Input/Output Using JOptionPane
    Applets
 */


/**
 *
 * @author Aviel Resnick
 */
import java.applet.Applet;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.util.*;

public class PrimeFactors extends Applet {
     public static ArrayList<Integer> list = new ArrayList<Integer>();
    
     public void paint(Graphics g) {
         g.drawString("Prime Factors", 125, 25);
         g.drawString("By Aviel Resnick", 25, 75);
         
         String a = JOptionPane.showInputDialog(null, "What's your number?");
         
         int intA = Integer.parseInt(a);
         g.drawString("The Prime Factors are: " + primeFactorsOf(intA), 25, 100);

     } 
     
    public static ArrayList primeFactorsOf(int n) {
        if (isPrime(n)) 
        {
            list.add(n);
            return list;
        }

        int i = 2;
        while (i < n/2)
        {
            if (n % i == 0)
            {
                 if (isPrime(i))
                 {
                     primeFactorsOf(n/i);
                     list.add(i);
                 } 
            }
            i++;
        }
        return list;
    }
    public static boolean isPrime( int n ) {
        int i;

        if( n < 2 )
            return false;
        else
        {
            for( i = 2; i < n; i += 1 )
            {
                if( n % i == 0 ) 
                    return false;
            }
        }    

        return true;
    }
 }

