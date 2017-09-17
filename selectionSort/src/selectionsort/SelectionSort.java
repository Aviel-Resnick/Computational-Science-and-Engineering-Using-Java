/*
 * Implementation of "The Not Very Efficient" Selection Sort
 */
package selectionsort;

/**
 *
 * @author Aviel Resnick
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    
    // Identifies Largest Int in an Array (and returns it)
    public static int indexOfMaxInRange(int[] array, int a, int b) {
        int maxIndex = 0;
        
        for (int i = a+1; i <= b; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    // Swaps two elements, given two indeces
    public static void swapElement(int[] array, int indexA, int indexB) {
        int updatedA = array[indexB];
        int updatedB = array[indexA];
        
        array[indexA] = updatedA;
        array[indexB] = updatedB;
    }
    
    // Sorts a provided array
    public static void selectionSort(int[] array) {
        int x = 1;
        for (int i = 0; i < array.length-1; i++) {
            int maxIndex = indexOfMaxInRange(array, i, array.length-1);
            swapElement(array, i, maxIndex); 
        }
        for (int i = 0; i < 1; i++) {
            swapElement(array, x, x-1);
            swapElement(array, x, x+1);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    
    // Test Case, should return 6,5,4,3,2,1
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        selectionSort(array);
    }
}
