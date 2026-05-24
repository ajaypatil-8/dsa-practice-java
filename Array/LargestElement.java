// Problem: Largest Element in Array
// Difficulty: Easy
// Topic: Arrays
// GFG Link:https://www.geeksforgeeks.org/problems/find-the-largest-element-in-an-array-1587115620/1

public class LargestElement {

    static int largest(int[] arr) {
        // start with first element as max
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // largest is 90
        int[] arr1 = {10, 20, 4, 45, 90};
        System.out.println("Test 1: " + largest(arr1));

        // all same elements
        int[] arr2 = {5, 5, 5, 5};
        System.out.println("Test 2: " + largest(arr2));

        // single element
        int[] arr3 = {7};
        System.out.println("Test 3: " + largest(arr3));
    }
}