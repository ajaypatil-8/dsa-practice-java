// Problem: Find Minimum and Maximum in Array
// Difficulty: Easy
// Topic: Arrays
// GFG Link:https://www.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1

import java.util.ArrayList;

public class MinMax {

    static ArrayList<Integer> getMinMax(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        ArrayList<Integer> newarr = new ArrayList<>();

        // single loop to find both min and max
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // min first, max second
        newarr.add(min);
        newarr.add(max);
        return newarr;
    }

    public static void main(String[] args) {
        // min 1, max 90
        int[] arr1 = {3, 2, 1, 56, 10, 90};
        System.out.println("Test 1: " + getMinMax(arr1));

        // all same elements
        int[] arr2 = {5, 5, 5, 5};
        System.out.println("Test 2: " + getMinMax(arr2));

        // single element
        int[] arr3 = {7};
        System.out.println("Test 3: " + getMinMax(arr3));
    }
}