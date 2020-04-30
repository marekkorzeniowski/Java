import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    // Create a program using arrays that sorts a list of integers in descending order.
    // Descending order is highest value to lowest.
    // In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
    // ultimately have an array with 106,81,26, 15, 5 in it.

    // TASKS
    // 1 Set up the program so that the numbers to sort are read in from the keyboard.

    // 2 Implement the following methods - getIntegers, printArray, and sortIntegers

    // 3 getIntegers returns an array of entered integers from keyboard

    // 4 printArray prints out the contents of the array
    // 5 and sortIntegers should sort the array and return a new array containing the sorted numbers

    // 6 you will have to figure out how to copy the array elements from the passed array into a new
    // array and sort them and return the new sorted array.

    public static void main(String[] args) {

        reverseArray(getInteger(5));
    }

    public static int[] getInteger (int capacity) {
        int[] array = new int[capacity];

        System.out.println("Enter " + capacity + " numbers");
        for (int i=0;i<array.length; i++) {
            array[i]= input.nextInt();
        }
        System.out.println("Your array is: " + Arrays.toString(array));
        return array;
    }

    public static int[] sortArray (int[] array) {

        int[] copiedArray = Arrays.copyOf(array,array.length);

        int temp;
        boolean flag = true;

        while (flag) {
            flag=false;

            for(int i=0;i<copiedArray.length-1;i++) {
                if(copiedArray[i]<copiedArray[i+1]){
                    temp=copiedArray[i];
                    copiedArray[i]=copiedArray[i+1];
                    copiedArray[i+1]=temp;
                    flag =true;
                }
            }
        }
        System.out.println("Your sorted array is: " + Arrays.toString(copiedArray));
        return copiedArray;
    }

    public static int minAndMaxValue (int[] array) {

        int min=array[0];
        int max=array[0];

        for(int i=1;i<array.length;i++) {
            if (array[i]>=max){
                max=array[i];
            }
            if (array[i]<=min){
                min=array[i];
            }
        }
        System.out.println("Max value is :" + max + " and Min value is :" + min);
        return min;
    }

    public static int[] reverseArray (int[] array) {

        int[] copiedArray = Arrays.copyOf(array,array.length);


        for(int i=0;i<array.length/2;i++) {

            copiedArray[i]=array[array.length-(1+i)];
            copiedArray[array.length-(1+i)]=array[i];
        }
        System.out.println("Your reversed array is : " + Arrays.toString(copiedArray));
        return copiedArray;
    }


























}
