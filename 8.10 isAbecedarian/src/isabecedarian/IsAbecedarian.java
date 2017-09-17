/*
 * 1.  Describe  a  process  for  checking  whether  a  given  word  (String)  
 * is abecedarian, assuming that the word contains only lower-case letters.
 * Your process can be iterative or recursive.
 * 
*  2.  Implement your process in a method called isAbecedarian
 *
 * A possible approach to checking weather a given word, "string" is abecedarian,
 * assuming only lower-case letters, is to cycke iterativly through each letter
 * (Traverse the string), and compare its numeric value to the next one.
 * If at any point the value is smaller, return False, else return True.
*/

package isabecedarian;

/**
 *
 * @author Aviel Resnick
 */

public class IsAbecedarian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test Cases (True then False)
        String trueCase = "abdest";
        String falseCase = "zap";
        
        System.out.println(isAbecedarian(trueCase));
        System.out.println(isAbecedarian(falseCase));
    }
    
    public static boolean isAbecedarian(String word){
        boolean flag = true;
        int index = 0;
        int prev = 0;
        
        // Traverse and compare with the last letter
        while (index < word.length()){
            char letter = word.charAt(index);
            int value = (int) letter;
            
            if (value < prev){
                flag = false;
                break;
            }
            prev = value;
            ++index;
        }
        // Return bool flag
        return flag;
    }
}
