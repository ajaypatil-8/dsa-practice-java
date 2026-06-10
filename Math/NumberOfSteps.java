// Problem: Number of Steps to Reduce a Number to Zero
// Difficulty: Easy
// Topic: Math
// Leetcode Link: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
// GFG Link:

public class NumberOfSteps {

    static int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            // even, divide by 2
            if (num % 2 == 0) {
                num = num / 2;
                count++;
            }
            // odd, subtract 1
            else {
                num--;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 14 takes 6 steps
        System.out.println("Test 1: " + numberOfSteps(14));

        // 8 takes 4 steps
        System.out.println("Test 2: " + numberOfSteps(8));

        // 0 takes 0 steps
        System.out.println("Test 3: " + numberOfSteps(0));
    }
}