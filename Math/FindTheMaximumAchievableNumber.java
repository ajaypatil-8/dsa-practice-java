// Problem: Find the Maximum Achievable Number
// Difficulty: Easy
// Topic: Math
// LeetCode Link: https://leetcode.com/problems/find-the-maximum-achievable-number/
// GFG Link:

public class FindTheMaximumAchievableNumber {

    public int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }

    public static void main(String[] args) {
        FindTheMaximumAchievableNumber solution =
                new FindTheMaximumAchievableNumber();

        int test1 = solution.theMaximumAchievableX(4, 1);
        int test2 = solution.theMaximumAchievableX(3, 2);
        int test3 = solution.theMaximumAchievableX(0, 0); // edge case

        System.out.println("Test 1: " + test1);
        System.out.println("Test 2: " + test2);
        System.out.println("Test 3: " + test3);
    }
}