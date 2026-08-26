// Problem: Nearly Sorted Array
// Difficulty: Medium
// Topic: Heap

import java.util.PriorityQueue;

public class NearlySortedArray {

    public void nearlySorted(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int idx = 0;

        for (int i = 0; i < arr.length; i++) {

            if (pq.size() > k) {
                pq.add(arr[i]);
                arr[idx++] = pq.remove();
            } else {
                pq.add(arr[i]);
            }
        }

        while (!pq.isEmpty()) {
            arr[idx++] = pq.remove();
        }
    }

    public static void main(String[] args) {

        NearlySortedArray solution = new NearlySortedArray();

        // Test 1
        int[] test1 = {6, 5, 3, 2, 8, 10, 9};
        solution.nearlySorted(test1, 3);

        // Test 2
        int[] test2 = {3, 2, 1, 5, 6, 4};
        solution.nearlySorted(test2, 2);

        // Test 3: edge case
        int[] test3 = {1};
        solution.nearlySorted(test3, 0);

        System.out.print("Test 1: ");
        printArray(test1);

        System.out.print("Test 2: ");
        printArray(test2);

        System.out.print("Test 3: ");
        printArray(test3);
    }

    private static void printArray(int[] arr) {

        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();
    }
}