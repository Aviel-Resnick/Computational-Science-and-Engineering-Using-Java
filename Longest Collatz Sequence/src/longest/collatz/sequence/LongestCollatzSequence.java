/*
 * Project Euler 14:
 *   The following iterative sequence is defined for the set of positive integers:
 *
 *   n → n/2 (n is even)
 *   n → 3n + 1 (n is odd)
 *
 *   Using the rule above and starting with 13, we generate the following sequence:
 *
 *   13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *   It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 *   Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 *   Which starting number, under one million, produces the longest chain?
 */
package longest.collatz.sequence;
import java.util.*;
/**
 *
 * @author Aviel Resnick
 */
public class LongestCollatzSequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		
        LinkedList<Long> list = new LinkedList<Long>();

        long length = 0;
        int longest = 0;

        for(int x = 1; x < 1000000; x++)
        {
            long i = x;

            while (i != 1)
            {
                if (i % 2 == 0)
                {
                    i = i/2;
                    list.add(i);
                }
                else
                {
                    i = 3 * i + 1;
                    list.add(i);
                }
            }

            if(list.size() > length)
            {
                length = list.size();
                longest = x;
            }
            list.clear();
        }

        System.out.println(longest);
    }
}
