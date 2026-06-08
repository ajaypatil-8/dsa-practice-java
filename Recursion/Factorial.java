// Problem: Factorial
// Difficulty: Easy
// Topic: Recursion
// GFG Link: https://www.geeksforgeeks.org/problems/factorial5739/1

public class Factorial {

    static int factorial(int n) {
        // base case
        if (n == 1 || n == 0) return 1;
        // n * factorial of rest
        int ans = n * factorial(n - 1);
        return ans;
    }

    public static void main(String[] args) {
        // 5! = 120
        System.out.println("Test 1: " + factorial(5));

        // 0! = 1
        System.out.println("Test 2: " + factorial(0));

        // 1! = 1
        System.out.println("Test 3: " + factorial(1));
    }
}