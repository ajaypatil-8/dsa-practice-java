// Problem: Sum Root to Leaf Numbers
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/

public class SumRootToLeafNumbers {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans = 0;
    int sum = 0;

    public void dfs(TreeNode root) {

        if (root == null) {
            return;
        }

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null) {
            ans += sum;
            sum = sum / 10;
            return;
        }

        dfs(root.left);
        dfs(root.right);

        sum = sum / 10;
    }

    public int sumNumbers(TreeNode root) {

        dfs(root);

        return ans;
    }

    public static void main(String[] args) {

        // Test 1: [1,2,3] -> 25
        SumRootToLeafNumbers solution1 =
                new SumRootToLeafNumbers();

        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(3);

        System.out.println("Test 1: " + solution1.sumNumbers(test1));

        // Test 2: [4,9,0,5,1] -> 1026
        SumRootToLeafNumbers solution2 =
                new SumRootToLeafNumbers();

        TreeNode test2 = new TreeNode(4);
        test2.left = new TreeNode(9);
        test2.right = new TreeNode(0);
        test2.left.left = new TreeNode(5);
        test2.left.right = new TreeNode(1);

        System.out.println("Test 2: " + solution2.sumNumbers(test2));

        // Test 3: single node
        SumRootToLeafNumbers solution3 =
                new SumRootToLeafNumbers();

        TreeNode test3 = new TreeNode(7);

        System.out.println("Test 3: " + solution3.sumNumbers(test3));
    }
}