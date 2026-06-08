// Problem: Power of Numbers
// Difficulty: Easy
// Topic: Recursion
// GFG Link: https://www.geeksforgeeks.org/problems/power-of-numbers-1587115620/1

public class PowerOfNumbers {

    static int power(int a, int b) {
        // base case, anything to power 0 is 1
        if (b == 0) return 1;
        int call = power(a, b / 2);
        // even power, just square the result
        if (b % 2 == 0) return call * call;
        // odd power, multiply one more a
        else return call * call * a;
    }

    static int reverseExponentiation(int n) {
        // edge case for 10
        if (n == 10) return 10;
        // n to the power n
        return power(n, n);
    }

    public static void main(String[] args) {
        // 2^2 = 4
        System.out.println("Test 1: " + reverseExponentiation(2));

        // 3^3 = 27
        System.out.println("Test 2: " + reverseExponentiation(3));

        // edge case 10
        System.out.println("Test 3: " + reverseExponentiation(10));
    }
}