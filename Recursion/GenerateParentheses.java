import java.util.*;

// Problem: Generate Parentheses
// Difficulty: Medium
// Topic: Recursion, Backtracking
// LeetCode Link: https://leetcode.com/problems/generate-parentheses/
// GFG Link: https://www.geeksforgeeks.org/problems/generate-all-possible-parentheses/1

public class GenerateParentheses {

    public void createstr(int lt, int rt, int n, String str, List<String> ans) {

        // got a valid string
        if (rt == n) {
            ans.add(str);
            return;
        }

        // add opening bracket
        if (lt < n) {
            createstr(lt + 1, rt, n, str + "(", ans);
        }

        // add closing bracket if possible
        if (rt < lt) {
            createstr(lt, rt + 1, n, str + ")", ans);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        createstr(0, 0, n, "", ans);
        return ans;
    }

    public static void main(String[] args) {
        GenerateParentheses sol = new GenerateParentheses();

        // GFG Example 1
        System.out.println("Test 1: " + sol.generateParenthesis(1));

        // GFG / LeetCode Example
        System.out.println("Test 2: " + sol.generateParenthesis(3));

        // Edge Case
        System.out.println("Test 3: " + sol.generateParenthesis(0));
    }
}