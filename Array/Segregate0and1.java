// Problem: Segregate 0s and 1s
// Difficulty: Easy
// Topic: Arrays
// GFG Link: https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1

import java.util.Arrays;

public class Segregate0and1 {

    static void segregate0and1(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        // two pointers, i from left j from right
        while (i < j) {
            if (arr[i] == 0) {
                i++;
            }

            if (arr[j] == 1) {
                j--;
            }

            if (i > j) break;

            // i is on 1 and j is on 0, swap them
            if (arr[i] == 1 && arr[j] == 0) {
                arr[i] = 0;
                arr[j] = 1;
            }
        }
    }

    public static void main(String[] args) {
        // all 0s before 1s
        int[] arr1 = {0, 1, 0, 1, 1, 0};
        segregate0and1(arr1);
        System.out.println("Test 1: " + Arrays.toString(arr1));

        // already segregated
        int[] arr2 = {0, 0, 1, 1};
        segregate0and1(arr2);
        System.out.println("Test 2: " + Arrays.toString(arr2));

        // single element
        int[] arr3 = {1};
        segregate0and1(arr3);
        System.out.println("Test 3: " + Arrays.toString(arr3));
    }
}