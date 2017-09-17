/*
1.  The  Captain  Crunch  decoder  ring  works  by  taking
each letter in a string and adding 13 to it.  For example, ’a’ becomes
’n’ and ’b’ becomes ’o’.  The letters “wrap around” at the end, so ’z’
becomes ’m’.

Write  a  method  that  takes  a  String  and  that  returns  a  new  String
containing  the  encoded  version.   You  should  assume  that  the  String
contains upper and lower case letters, and spaces, but no other punc-
tuation.  Lower case letters should be tranformed into other lower case
letters; upper into upper.  You should not encode the spaces.

2.  Generalize the Captain Crunch method so that instead of adding 13
to the letters, it adds any given amount.  Now you should be able to
encode things by adding 13 and decode them by adding -13.  Try it.
 */
package captaincrunch;

/**
 *
 * @author Aviel
 */
public class CaptainCrunch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test Case should output n M p
        String input = "a Z c";
        int key = 13;
        
        System.out.println(encode(input,key));
    }
    
    public static String encode(String input, int key){
        String output = "";
        
        for(int i = 0; i < input.length(); ++i){
            char letter = input.charAt(i);
            int value = (int) letter;
            
            // Space
            if (value == 32){
                output = output + " ";
            }
            
            // Lower Case Letters
            if (value > 90){
                int newValue = value + key;
                
                if (newValue > 122){
                    newValue = newValue - 26;
                }
                
                // Appending the new letter
                output = output + (char)(newValue);
            }
            
            // Upper Case Letters
            if (value < 91 && value > 64){
                int newValue = value + key;
                
                if (newValue > 90){
                    newValue = newValue - 26;
                }
                
                // Appending the new letter
                output = output + (char)(newValue);
            }
        }
        return output;
    }
}
