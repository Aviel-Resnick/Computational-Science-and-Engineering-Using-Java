/*
 * Given two strings; Checks if you can spell one using the letters of another
 * Also accounts for wildcards.
 */
package scrabble;

import java.util.Arrays;

/**
 *
 * @author Aviel Resnick
 */
public class Scrabble {

    /**
     * @param args the command line arguments
     */
    
    public static boolean canSpell(String a, String b) {
        String[] array = a.split("");
        String[] word = b.split("");
        Boolean finalResult = true;
        String wildString = "*";
        int wildInt = 0;
        
        // Counts wildcards
        for(String i : array){
            if(i.equals(wildString)){
                wildInt++;
            }
        }
        
        // For each letter in the word that is being spelled
        for(int i = 0; i < b.length(); i++) {
            String letter = word[i];
            Boolean flag = false;
            
            // Check each letter in the longer string
            for(int x = 0; x < a.length(); x++) {
                if(array[x].equals(letter)) {
                    flag = true;   
                    array[x] = "-";
                    break;
                }
            }
            
            if(flag == false) {
                // Wildcard check
                if (wildInt > 0){
                    wildInt--;
                }
                // Return false, and break (only one false is needed)
                else{
                    finalResult = false;
                    break;
                }
            }
        }
        
        // Output
        String testString = Arrays.toString(array);
        System.out.println(testString);
        return finalResult;
    }
    
    public static void main(String[] args) {
        // Test case (should be true), also checks wildcards
        String a = "qui*ibo";
        String b = "jib";
        System.out.println(canSpell(a,b));
    }
    
}
