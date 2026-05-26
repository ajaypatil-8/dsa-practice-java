// Problem: First and Last Occurrence of an Element
// Difficulty: Easy
// Topic: Arrays
// GFG Link:https://www.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1

import java.util.ArrayList;

public class FirstLastOccurrence {

    static ArrayList<Integer> find(int[] arr, int x) {
        int first = -1;
        int last = -1;

        // left to right for first occurrence
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                first = i;
                break;
            }
        }

        // right to left for last occurrence
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) {
                last = i;
                break;
            }
        }

        ArrayList<Integer> found = new ArrayList<>();
        found.add(first);
        found.add(last);
        return found;
    }

    public static void main(String[] args) {
        // first at 1, last at 4
        int[] arr1 = {1, 2, 2, 3, 2, 4};
        System.out.println("Test 1: " + find(arr1, 2));

        // element not present, both -1
        int[] arr2 = {1, 3, 5, 7};
        System.out.println("Test 2: " + find(arr2, 4));

        // single element matches
        int[] arr3 = {5};
        System.out.println("Test 3: " + find(arr3, 5));
    }
}