// Problem: Square Root
// Difficulty: Easy
// Topic: Searching
// Leetcode Link: https://leetcode.com/problems/sqrtx/
// GFG Link: https://www.geeksforgeeks.org/problems/square-root/1

public class SquareRoot {

    static int mySqrt(int x) {
        // return (int)(Math.sqrt(x));
        long low = 0, high = x;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            // exact square root found
            if (mid * mid == x) return (int) mid;
            // mid too big, go left
            else if (mid * mid > x) high = mid - 1;
            // mid too small, go right
            else low = mid + 1;
        }

        // high is the floor of square root
        return (int) high;
    }

    public static void main(String[] args) {
        // sqrt(16) = 4
        System.out.println("Test 1: " + mySqrt(16));

        // sqrt(8) = 2 (floor)
        System.out.println("Test 2: " + mySqrt(8));

        // sqrt(0) = 0
        System.out.println("Test 3: " + mySqrt(0));
    }
}