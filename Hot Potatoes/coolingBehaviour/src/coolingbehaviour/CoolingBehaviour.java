/*
*   Prompt user for the initial values: Told, Tnew, Tair
*   using JOptionPane 
*
*   Calculate m for the given values.
*
*   Display the m value using a JOptionPane
*   message dialog box
 */
package coolingbehaviour;

/**
 *
 * @author Aviel Resnick, Sean Nemtzow, Bethany Reeve, Tyler Roystan (Group 3)
 */

import javax.swing.JOptionPane;

public class CoolingBehaviour {

    /**
     * @param args the command line arguments
     */
    
    public static double heatLoss(double tOld, double tNew, double tAir) {
        // Calcute m from the provided formula, give tOld, tNew, and tAir
        double m = (tOld - tNew) / (tOld - tAir);
        return m;
    }
    
    public static void main(String[] args) {
        // Dialog boxes for data input
        String tOldString = JOptionPane.showInputDialog("Please enter a value for tOld");
        String tNewString = JOptionPane.showInputDialog("Please enter a value for tNew");
        String tAirString = JOptionPane.showInputDialog("Please enter a value for tAir");
        
        // Converting the inputed strings to booleans
        // I didn't add a clause to test if the input isn't a bool, 
        // but I don't think that's necessary
        double tOld = Double.parseDouble(tOldString);
        double tNew = Double.parseDouble(tNewString);
        double tAir = Double.parseDouble(tAirString);
        
        // Print the result, and close the window when done
        JOptionPane.showMessageDialog( null, "M = " + heatLoss(tOld, tNew, tAir), "Result", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }
}
