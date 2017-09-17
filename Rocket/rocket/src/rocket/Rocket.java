/*
Rocket Trajectory Calculation through Numerical Differentiation

Application: Rocket Trajectory

Imagine the first stage of a rocket burning for about 35 seconds,
accelerating the rocket to a velocity of 1250 m/s.
Then, the rocket coasts for almost 2 minutes before reaching the lower levels
of the ionosphere at about 100 km. Gravity has slowed the rocket's ascent to
about 100 m/s at this point, but then the second stage of the rocket ignites and
accelerates the rocket into space.

The plot below shows the altitude measurements of the rocket as a function of time.
It contains data points at 10-second intervals along the altitude curve.

A program is needed to model the velocity and acceleration of the rocket.
It is important to note that the first derivative (the instantaneous rate of change)
of the altitude vs. time function represents the velocity of the rocket,
and the derivative (the instantaneous rate of change) of the velocity function
will represent the acceleration of the rocket! Write a program that will read the
altitude data from a file on disk and estimate the corresponding velocity and acceleration
information using numerical differentiation.
*/
package rocket;
import java.io.*;

/**
 *
 * @author Aviel Resnick
 */
public class Rocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException {
        BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream("altitude.txt")));
        String[] stringArray = new String[26];
        double[] doubleArray = new double[26];
        double[] firstDerivative = new double[26];
        double[] secondDerivative = new double[26];

        // Read from the altitude file
        for(int i = 0; i < 26; ++i){
            stringArray[i] = b.readLine();
        }

        // Convert into a doubleArray
        for(int i = 0; i < 26; ++i){
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }

        // Calculate First Derivative (Velocity)
        for(int k = 1; k < 25; ++k){
            // Y'k = (Yk+1 - Yk-1) / 2h
            firstDerivative[k] = (doubleArray[k+1] - doubleArray[k-1]) / (20);
        }

        // Calculate Second Derivative (Acceleration)
        for(int k = 1; k < 25; ++k){
            // Y'k = (Yk+1 - 2Yk + Yk - 1) / h^2
            secondDerivative[k] = (doubleArray[k+1] - (2 * doubleArray[k]) + doubleArray[k-1]) / (100);
        }

        // Print Velocity Calculation Results
        for(int i = 1; i < 25; ++i){
            System.out.println("Velocity at " + i * 10 + " seconds is " + firstDerivative[i]);
        }

        // Print Acceleration Calculation Results
        for(int i = 1; i < 25; ++i){
            System.out.println("Acceleration at " + i * 10 + " seconds is " + secondDerivative[i]);
        }
    }
}
