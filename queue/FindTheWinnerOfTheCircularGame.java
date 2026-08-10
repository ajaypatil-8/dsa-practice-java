// Problem: Find the Winner of the Circular Game
// Difficulty: Medium
// Topic: Queue
// LeetCode Link: https://leetcode.com/problems/find-the-winner-of-the-circular-game/

import java.util.LinkedList;
import java.util.Queue;

public class FindTheWinnerOfTheCircularGame {

    public int findTheWinner(int n, int k) {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {

            // move k-1 players to back
            for (int i = 1; i < k; i++) {
                q.add(q.remove());
            }

            q.remove();
        }

        return q.peek();
    }

    public static void main(String[] args) {

        FindTheWinnerOfTheCircularGame solution =
                new FindTheWinnerOfTheCircularGame();

        // Test 1
        System.out.println("Test 1: " + solution.findTheWinner(5, 2));

        // Test 2
        System.out.println("Test 2: " + solution.findTheWinner(6, 5));

        // Test 3 (edge case)
        System.out.println("Test 3: " + solution.findTheWinner(1, 1));
    }
}