// Problem: Maximum Depth of Binary Tree
// Difficulty: Easy
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

public class MaximumDepthOfBinaryTree {

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

    int depth = 0;

    public void dfs(TreeNode root, int d) {

        if (root == null) {
            return;
        }

        depth = Math.max(depth, d);

        dfs(root.left, d + 1);
        dfs(root.right, d + 1);
    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        dfs(root, 1);

        return depth;
    }

    public static void main(String[] args) {

        // Test 1: [3,9,20,null,null,15,7]
        MaximumDepthOfBinaryTree solution1 =
                new MaximumDepthOfBinaryTree();

        TreeNode test1 = new TreeNode(3);
        test1.left = new TreeNode(9);
        test1.right = new TreeNode(20);
        test1.right.left = new TreeNode(15);
        test1.right.right = new TreeNode(7);

        System.out.println("Test 1: " + solution1.maxDepth(test1));

        // Test 2: [1,null,2]
        MaximumDepthOfBinaryTree solution2 =
                new MaximumDepthOfBinaryTree();

        TreeNode test2 = new TreeNode(1);
        test2.right = new TreeNode(2);

        System.out.println("Test 2: " + solution2.maxDepth(test2));

        // Test 3: single node
        MaximumDepthOfBinaryTree solution3 =
                new MaximumDepthOfBinaryTree();

        TreeNode test3 = new TreeNode(1);

        System.out.println("Test 3: " + solution3.maxDepth(test3));
    }
}