// Problem: Second Largest Element in Array
// Difficulty: Easy
// Topic: Arrays
// GFG Link:https://www.geeksforgeeks.org/problems/second-largest3735/1

public class SecondLargest {

    static int getSecondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;

        // first pass - find the largest
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // second pass - find largest that isn't max
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > smax && max > arr[i]) {
                smax = arr[i];
            }
        }

        // no second largest found
        if (smax == Integer.MIN_VALUE) {
            return -1;
        }

        return smax;
    }

    public static void main(String[] args) {
        // second largest is 34
        int[] arr1 = {12, 35, 1, 10, 34, 1};
        System.out.println("Test 1: " + getSecondLargest(arr1));

        // second largest is 5
        int[] arr2 = {10, 5, 10, 1};
        System.out.println("Test 2: " + getSecondLargest(arr2));

        // all same, no second largest so -1
        int[] arr3 = {5, 5, 5};
        System.out.println("Test 3: " + getSecondLargest(arr3));
    }
}