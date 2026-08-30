// Problem: Find K Closest Elements
// Difficulty: Medium
// Topic: Heap
// LeetCode Link: https://leetcode.com/problems/find-k-closest-elements/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {

    static class Pair implements Comparable<Pair> {
        int elem;
        int dist;

        Pair(int elem, int dist) {
            this.elem = elem;
            this.dist = dist;
        }

        public int compareTo(Pair p) {
            if (this.dist == p.dist) {
                return Integer.compare(this.elem, p.elem);
            }

            return Integer.compare(this.dist, p.dist);
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int elem : arr) {

            if (pq.size() >= k) {
                pq.add(new Pair(elem, Math.abs(elem - x)));
                pq.remove();
            } else {
                pq.add(new Pair(elem, Math.abs(elem - x)));
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (pq.size() > 0) {
            ans.add(pq.remove().elem);
        }

        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {

        FindKClosestElements solution =
                new FindKClosestElements();

        // Test 1: LeetCode example
        int[] test1 = {1, 2, 3, 4, 5};
        int k1 = 4;
        int x1 = 3;

        // Test 2: LeetCode example
        int[] test2 = {1, 2, 3, 4, 5};
        int k2 = 4;
        int x2 = -1;

        // Test 3: edge case
        int[] test3 = {1};
        int k3 = 1;
        int x3 = 1;

        System.out.println("Test 1: " +
                solution.findClosestElements(test1, k1, x1));

        System.out.println("Test 2: " +
                solution.findClosestElements(test2, k2, x2));

        System.out.println("Test 3: " +
                solution.findClosestElements(test3, k3, x3));
    }
}