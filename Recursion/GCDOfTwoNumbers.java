// Problem: GCD of Two Numbers
// Difficulty: Easy
// Topic: Mathematics, Recursion
// GFG Link:

public class GCDOfTwoNumbers {

    public static int gcd(int a, int b) {
        // base case
        if (a == 0) return b;

        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        int test1 = gcd(20, 28);
        int test2 = gcd(60, 36);
        int test3 = gcd(0, 15); // edge case

        System.out.println("Test 1: " + test1);
        System.out.println("Test 2: " + test2);
        System.out.println("Test 3: " + test3);
    }
}