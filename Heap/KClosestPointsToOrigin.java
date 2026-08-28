// Problem: K Closest Points to Origin
// Difficulty: Medium
// Topic: Heap
// LeetCode Link: https://leetcode.com/problems/k-closest-points-to-origin/

import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    static class Helper implements Comparable<Helper> {
        int idx;
        int val;

        Helper(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        public int compareTo(Helper a) {
            return Integer.compare(this.val, a.val);
        }
    }

    public int[][] kClosest(int[][] arr, int k) {

        int[][] ans = new int[k][2];

        PriorityQueue<Helper> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {

            int val = (arr[i][0] * arr[i][0]) +
                      (arr[i][1] * arr[i][1]);

            if (pq.size() >= k) {
                pq.add(new Helper(i, val));
                pq.remove();
            } else {
                pq.add(new Helper(i, val));
            }
        }

        int i = 0;

        while (pq.size() > 0) {
            int temp = pq.remove().idx;

            ans[i][0] = arr[temp][0];
            ans[i][1] = arr[temp][1];

            i++;
        }

        return ans;
    }

    public static void main(String[] args) {

        KClosestPointsToOrigin solution =
                new KClosestPointsToOrigin();

        // Test 1: LeetCode example
        int[][] test1 = {
                {1, 3},
                {-2, 2}
        };
        int k1 = 1;

        // Test 2: LeetCode example
        int[][] test2 = {
                {3, 3},
                {5, -1},
                {-2, 4}
        };
        int k2 = 2;

        // Test 3: edge case
        int[][] test3 = {
                {1, 1}
        };
        int k3 = 1;

        System.out.println("Test 1:");
        printArray(solution.kClosest(test1, k1));

        System.out.println("Test 2:");
        printArray(solution.kClosest(test2, k2));

        System.out.println("Test 3:");
        printArray(solution.kClosest(test3, k3));
    }

    private static void printArray(int[][] arr) {

        for (int[] point : arr) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}