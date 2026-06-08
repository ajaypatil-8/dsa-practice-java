

// Problem: Sum of First N Natural Numbers
// Difficulty: Easy
// Topic: Recursion
// GFG Link: https://www.geeksforgeeks.org/problems/reverse-coding2452/1

public class FindSum {

    static int findsum(int n) {
        // base case
        if (n == 0) return 0;
        // add n to sum of rest
        return n + findsum(n - 1);
    }

    public static void main(String[] args) {
        // sum of 1 to 5 = 15
        System.out.println("Test 1: " + findsum(5));

        // sum of 1 to 10 = 55
        System.out.println("Test 2: " + findsum(10));

        // 0 returns 0
        System.out.println("Test 3: " + findsum(0));
    }
}