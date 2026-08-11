// Problem: Path Sum
// Difficulty: Easy
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/path-sum/

public class PathSum {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                return true;
            } else {
                return false;
            }
        }

        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {

        PathSum solution = new PathSum();

        // Test 1: [5,4,8,11,null,13,4,7,2,null,null,null,1]
        TreeNode test1 = new TreeNode(5);
        test1.left = new TreeNode(4);
        test1.right = new TreeNode(8);
        test1.left.left = new TreeNode(11);
        test1.left.left.left = new TreeNode(7);
        test1.left.left.right = new TreeNode(2);
        test1.right.left = new TreeNode(13);
        test1.right.right = new TreeNode(4);
        test1.right.right.right = new TreeNode(1);

        // Test 2: [1,2,3]
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);

        // Test 3: [1] (edge case)
        TreeNode test3 = new TreeNode(1);

        System.out.println("Test 1: " + solution.hasPathSum(test1, 22));
        System.out.println("Test 2: " + solution.hasPathSum(test2, 5));
        System.out.println("Test 3: " + solution.hasPathSum(test3, 1));
    }
}