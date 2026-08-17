// Problem: Range Sum of BST
// Difficulty: Easy
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/range-sum-of-bst/

public class RangeSumOfBST {

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

    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }

        // skip unnecessary subtree
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        return root.val
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }

    public static void main(String[] args) {

        RangeSumOfBST solution = new RangeSumOfBST();

        // Test 1: [10,5,15,3,7,null,18], low = 7, high = 15
        TreeNode test1 = new TreeNode(10);
        test1.left = new TreeNode(5);
        test1.right = new TreeNode(15);
        test1.left.left = new TreeNode(3);
        test1.left.right = new TreeNode(7);
        test1.right.right = new TreeNode(18);

        // Test 2: [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
        TreeNode test2 = new TreeNode(10);
        test2.left = new TreeNode(5);
        test2.right = new TreeNode(15);
        test2.left.left = new TreeNode(3);
        test2.left.right = new TreeNode(7);
        test2.right.left = new TreeNode(13);
        test2.right.right = new TreeNode(18);
        test2.left.left.left = new TreeNode(1);
        test2.left.right.left = new TreeNode(6);

        // Test 3: single node
        TreeNode test3 = new TreeNode(5);

        System.out.println("Test 1: " + solution.rangeSumBST(test1, 7, 15));
        System.out.println("Test 2: " + solution.rangeSumBST(test2, 6, 10));
        System.out.println("Test 3: " + solution.rangeSumBST(test3, 5, 5));
    }
}