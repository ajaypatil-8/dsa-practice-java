// Problem: Same Tree
// Difficulty: Easy
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/same-tree/

public class SameTree {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        SameTree solution = new SameTree();

        // Test 1: [1,2,3] and [1,2,3]
        TreeNode test1a = new TreeNode(1);
        test1a.left = new TreeNode(2);
        test1a.right = new TreeNode(3);

        TreeNode test1b = new TreeNode(1);
        test1b.left = new TreeNode(2);
        test1b.right = new TreeNode(3);

        // Test 2: [1,2] and [1,null,2]
        TreeNode test2a = new TreeNode(1);
        test2a.left = new TreeNode(2);

        TreeNode test2b = new TreeNode(1);
        test2b.right = new TreeNode(2);

        // Test 3: empty trees
        TreeNode test3a = null;
        TreeNode test3b = null;

        System.out.println("Test 1: " + solution.isSameTree(test1a, test1b));
        System.out.println("Test 2: " + solution.isSameTree(test2a, test2b));
        System.out.println("Test 3: " + solution.isSameTree(test3a, test3b));
    }
}