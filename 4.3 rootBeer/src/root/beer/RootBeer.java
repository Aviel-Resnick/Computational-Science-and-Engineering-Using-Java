/*
 * 4.3
 * Prints the lyrics to the song "Bottles of [Root] Beer"
 */
package root.beer;

/**
 * @author Aviel Resnick
 */
public class RootBeer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i = 99; i > 0; i--){
              // First line
              if (i == 99){
                  System.out.println("99 bottles of root beer on the wall, 99 bottles of root beer, ya’ take one\n" +
"down, ya’ pass it around, 98 bottles of root beer on the wall.");
              }
              
              // Grammer Control
              if (i == 2){
                  System.out.println("1 bottle of root beer on the wall, 1 bottle of root beer, ya’ take one\n" +
"down, ya’ pass it around, 0 bottles of root beer on the wall.");
              }
              
              // Last line
              if (i == 1){
                  System.out.println("No bottles of root beer on the wall, no bottles of root beer, ya’ can’t take\n" +
"one down, ya’ can’t pass it around, ’cause there are no more\n" +
"bottles of root beer on the wall!");
              }
              
              // Song progression
              else if (i != 2){
                  int num = i - 1;
                  int num2 = i - 2;
                  System.out.println(num + " bottle of root beer on the wall, " + num + " bottle of root beer, ya’ take one\n" +
"down, ya’ pass it around, " + num2 + " bottle of root beer on the wall.");
              }
         }
    }   
}
