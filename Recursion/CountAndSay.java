// Problem: Count and Say
// Difficulty: Medium
// Topic: Recursion, Strings
// LeetCode Link: https://leetcode.com/problems/count-and-say/

public class CountAndSay {

    public String countAndSay(int n) {

        // base case
        if (n == 1) {
            return "1";
        }

        String prev = countAndSay(n - 1);

        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < prev.length()) {

            int count = 1;

            // count same consecutive digits
            while (i + 1 < prev.length()
                    && prev.charAt(i) == prev.charAt(i + 1)) {
                count++;
                i++;
            }

            ans.append(count);
            ans.append(prev.charAt(i));

            i++;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        CountAndSay solution = new CountAndSay();

        System.out.println("Test 1: " + solution.countAndSay(1));
        System.out.println("Test 2: " + solution.countAndSay(4));
        System.out.println("Test 3: " + solution.countAndSay(5));
    }
}