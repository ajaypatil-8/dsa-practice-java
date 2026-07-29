// Problem: GCD of Odd and Even Sums
// Difficulty: Easy
// Topic: Math
// LeetCode Link: https://leetcode.com/problems/gcd-of-odd-and-even-sums/

public class GCDOfOddEvenSums {

    public int gcdOfOddEvenSums(int n) {
        return n;
    }

    public static void main(String[] args) {

        GCDOfOddEvenSums solution = new GCDOfOddEvenSums();

        // Test 1
        System.out.println("Test 1: " + solution.gcdOfOddEvenSums(1));

        // Test 2
        System.out.println("Test 2: " + solution.gcdOfOddEvenSums(4));

        // Test 3 (edge case)
        System.out.println("Test 3: " + solution.gcdOfOddEvenSums(1000));
    }
}