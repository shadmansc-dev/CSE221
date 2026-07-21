import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {            //offset(for comparison)
        int[] array = {4, 2, 2, 8, 3, 3, 1};

        int max = array[0];                             //int min = array[0], max = array[0];              
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {                       //if (array[i] < min) min = array[i];
                max = array[i];                         //if (array[i] > max) max = array[i];
            }
        }

        int[] count = new int[max + 1];                 //int[] count = new int[max - min + 1];

        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;                          //count[array[i] - min]++;
        }

        for (int i = 1; i <= max; i++) { //i<count.length
            count[i] += count[i - 1];
        }

        int[] sortedArray = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[--count[array[i]]] = array[i];  //sorted[--count[array[i] - min]] = array[i];
        }

        System.out.println(Arrays.toString(sortedArray));
    }
}