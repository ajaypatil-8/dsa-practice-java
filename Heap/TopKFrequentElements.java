// Problem: Top K Frequent Elements
// Difficulty: Medium
// Topic: Heap
// LeetCode Link: https://leetcode.com/problems/top-k-frequent-elements/

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    static class Pair implements Comparable<Pair> {
        int val;
        int freq;

        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        public int compareTo(Pair p) {
            if (p.freq == this.freq) {
                return this.val - p.val;
            }

            return Integer.compare(this.freq, p.freq);
        }
    }

    public int[] topKFrequent(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int elem : arr) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int key : map.keySet()) {

            int freq = map.get(key);

            if (pq.size() >= k) {
                pq.add(new Pair(key, freq));
                pq.remove();
            } else {
                pq.add(new Pair(key, freq));
            }
        }

        int[] ans = new int[k];
        int idx = 0;

        while (pq.size() > 0) {
            ans[idx++] = pq.remove().val;
        }

        return ans;
    }

    public static void main(String[] args) {

        TopKFrequentElements solution =
                new TopKFrequentElements();

        // Test 1: LeetCode example
        int[] test1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;

        // Test 2: LeetCode example
        int[] test2 = {1};
        int k2 = 1;

        // Test 3: all same
        int[] test3 = {5, 5, 5, 5};
        int k3 = 1;

        System.out.println("Test 1: ");
        printArray(solution.topKFrequent(test1, k1));

        System.out.println("Test 2: ");
        printArray(solution.topKFrequent(test2, k2));

        System.out.println("Test 3: ");
        printArray(solution.topKFrequent(test3, k3));
    }

    private static void printArray(int[] arr) {

        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}