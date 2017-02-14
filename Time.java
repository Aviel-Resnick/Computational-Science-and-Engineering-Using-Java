/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

/**
 *
 * @author Aviel Resnick
 */
public class Time {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int hours = 11;
        int minutes = 50;
        int seconds = 32;
        int totalSeconds;
        
        // The current time expressed in seconds
        totalSeconds = (hours * 3600) + (minutes * 60) + seconds;
        
        // Seconds since midnight (Also the total seconds in the day)
        System.out.println("Seconds since midnight: " + totalSeconds);
        
        // Seconds left in the day (86400 is the amount of seconds in a day)
        System.out.println("Seconds remaining today: " + (86400-totalSeconds));
        
        //Percentage of the day which has passed
        double totalSecondsDouble = totalSeconds;
        double percentDouble = ((totalSecondsDouble/86400.0) * 100);
        int percent = (int)percentDouble;
        
        System.out.println("Percent elapsed: " + percent + "%");
    }
    
}
