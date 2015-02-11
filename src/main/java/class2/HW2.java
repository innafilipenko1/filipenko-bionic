package class2;

import java.util.Arrays;

/**
 * Created by ifilipenko on 2/10/2015.
 */
public class HW2 {

    // Речь идет о бинарном поиске в уже отсортированном массиве. Есть массива - нужно найти элемент

    public static void main(String[] args) {


        binarySearch(new int[]{1, 8, 2, 2}, 0);

    }

    public static int binarySearch(int[] array, int x) {

        Arrays.sort(array);
        System.out.println("The sorted array: " + Arrays.toString(array));

        int begin = 0;
        int end = array.length-1;
        int mid = (begin + (end - begin)) / 2;
        int count = 0;

        //System.out.println(+ array[mid]);

        if (x == array[mid]) System.out.println(array[mid]);

        for (int i = 0; i < array.length; i++) {
            if(array[i] != x) count++;
        }
        if (count == array.length) System.out.println(x + " - the element is not within the array");

        if (x < array[mid]) {

            for (int i = 0; i < mid; i++) {
                if (array[i] == x)  {
                        int index = i;
                    System.out.println("The array element " + array[i] + " is under index " + index);
                }

            }
        } else {

            for (int i = mid + 1; i < array.length; i++) {
                if (array[i] == x) {
                    int index = i;
                    System.out.println("The array element " + array[i] + " is under index " + index);
                }

            }

        }


        return x;

    }


}
