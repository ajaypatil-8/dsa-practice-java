// Problem: Missing Number in Array
// Difficulty: Easy
// Topic: Arrays
// GFG Link:

public class MissingNumber {

    static int missingNum(int arr[]) {
        // n is total numbers including the missing one
        long n = arr.length + 1;
        // sum of 1 to n using formula
        long nsum = n * (n + 1) / 2;
        long sum = 0;
        // add all elements present in array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        // difference gives the missing number
        return (int) (nsum - sum);
    }

    public static void main(String[] args) {
        // missing number is 4
        int[] arr1 = {1, 2, 3, 5};
        System.out.println("Test 1: " + missingNum(arr1));

        // missing number is 6
        int[] arr2 = {8, 2, 4, 5, 3, 7, 1};
        System.out.println("Test 2: " + missingNum(arr2));

        // only one element, missing is 1
        int[] arr3 = {2};
        System.out.println("Test 3: " + missingNum(arr3));
    }
}