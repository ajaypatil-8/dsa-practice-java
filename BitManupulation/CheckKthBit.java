// Problem: Check K-th Bit
// Difficulty: Easy
// Topic: Bit Manipulation
// GFG Link: https://www.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1

public class CheckKthBit {

    static boolean checkKthBit(int n, int k) {

        // shift kth bit to end
        return ((n >> k) % 2 == 1);
    }

    public static void main(String[] args) {

        // Test 1
        System.out.println("Test 1: " + checkKthBit(4, 2));

        // Test 2
        System.out.println("Test 2: " + checkKthBit(4, 1));

        // Test 3: edge case
        System.out.println("Test 3: " + checkKthBit(0, 0));
    }
}