// Problem: Count Frequency of an Element in Array
// Difficulty: Easy
// Topic: Arrays
// GFG Link:https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1

public class CountFrequency {

    static int countFreq(int[] arr, int target) {
        int count = 0;
        // count how many times target appears
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 2 appears 3 times
        int[] arr1 = {1, 2, 2, 3, 2, 4};
        System.out.println("Test 1: " + countFreq(arr1, 2));

        // target not in array
        int[] arr2 = {4, 5, 6, 7};
        System.out.println("Test 2: " + countFreq(arr2, 3));

        // single element matches
        int[] arr3 = {9};
        System.out.println("Test 3: " + countFreq(arr3, 9));
    }
}