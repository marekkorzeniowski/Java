import java.util.Arrays;
import java.util.Scanner;

public class MinMaxValue {

    private static Scanner input = new Scanner(System.in);

    public static int[] readValues (int count) {

        int[] array = new int[count];

        System.out.println("Enter your numbers: \r");

        for (int i=0; i<count;i++) {
//            System.out.println("#" + i+1 + "number");
            array[i] =input.nextInt();
        }
        System.out.println("Array: " + Arrays.toString(array));
        return array;
    }

    public static int findMinMax (int[] array) {
        int min = array[0];
        int max= array[0];
        for (int i=1;i<array.length;i++) {
            if (array[i]>max) {
                max=array[i];
            }
            if (array[i]<min) {
                min= array[i];
            }
        }
        System.out.println("From array: " + Arrays.toString(array));
        System.out.println("Max was: " + max);
        System.out.println("Min was: " + min);

        return min;
    }

    public static int[] reversed (int[] array) {

        int[] reversedArray = new int[array.length];

        for (int i=0; i<array.length;i++) {
            reversedArray[i]=array[array.length-(i+1)];
        }
        System.out.println("reversed array is: " + Arrays.toString(reversedArray));
        return reversedArray;
    }

}
