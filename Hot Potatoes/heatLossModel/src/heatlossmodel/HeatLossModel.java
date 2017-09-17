/*
 * Project 5-3 Hot Potatoes
 * A mathematical model which represents the loss of heat
 * Of an object, over the span of 60 min.
 * 
 */
package heatlossmodel;

/**
 *
 * @author Aviel Resnick
 */
public class HeatLossModel {

    /**
     * @param args the command line arguments
     */
    
    public static double heatLoss(double m, double To, double Ta) {
        // Formula for modeling heat loss
        double loss = To - m * (To - Ta);
        return loss;
    }
    
    public static void main(String[] args) {
        // Insulating Capacity
        double m = 0.1;
        // Original object Temp.
        double To = 52.0;
        // Air Temp.
        double Ta = 23.0;
        // New Temp.
        double Tn;
        
        System.out.println("Min: 0.0 " + "Temp: " + To);
        
        // For loop (Every Min for 60 Min.)
        for (double i = 1; i <= 60; i = i + 1) {
            Tn = heatLoss(m, To, Ta);
            To = Tn;
            System.out.println("Min: " + i + " Temp: " + To);
        }
    }

}
