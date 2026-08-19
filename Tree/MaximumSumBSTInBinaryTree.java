// Problem: Maximum Sum BST in Binary Tree
// Difficulty: Hard
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

public class MaximumSumBSTInBinaryTree {

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

    static class Quad {
        int min;
        int max;
        int sum;
        boolean isBst;

        Quad(int min, int max, int sum, boolean isBst) {
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.isBst = isBst;
        }
    }

    public static Quad helper(TreeNode root, int[] arr) {

        if (root == null) {
            return new Quad(
                    Integer.MAX_VALUE,
                    Integer.MIN_VALUE,
                    0,
                    true
            );
        }

        Quad lst = helper(root.left, arr);
        Quad rst = helper(root.right, arr);

        int max = Math.max(
                root.val,
                Math.max(lst.max, rst.max)
        );

        int min = Math.min(
                root.val,
                Math.min(lst.min, rst.min)
        );

        int sum = root.val + lst.sum + rst.sum;

        boolean isBst =
                lst.isBst &&
                rst.isBst &&
                lst.max < root.val &&
                rst.min > root.val;

        if (isBst) {
            arr[0] = Math.max(arr[0], sum);
        }

        return new Quad(min, max, sum, isBst);
    }

    public int maxSumBST(TreeNode root) {

        int[] arr = {0};

        if (root == null) {
            return arr[0];
        }

        helper(root, arr);

        return arr[0];
    }

    public static void main(String[] args) {

        MaximumSumBSTInBinaryTree solution =
                new MaximumSumBSTInBinaryTree();

        // Test 1: [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
        // Expected: 20
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(4);
        test1.right = new TreeNode(3);

        test1.left.left = new TreeNode(2);
        test1.left.right = new TreeNode(4);

        test1.right.left = new TreeNode(2);
        test1.right.right = new TreeNode(5);

        test1.right.right.left = new TreeNode(4);
        test1.right.right.right = new TreeNode(6);

        // Test 2: [4,3,null,1,2]
        // Expected: 2
        TreeNode test2 = new TreeNode(4);
        test2.left = new TreeNode(3);
        test2.left.left = new TreeNode(1);
        test2.left.right = new TreeNode(2);

        // Test 3: single node
        // Expected: 5
        TreeNode test3 = new TreeNode(5);

        System.out.println("Test 1: " + solution.maxSumBST(test1));
        System.out.println("Test 2: " + solution.maxSumBST(test2));
        System.out.println("Test 3: " + solution.maxSumBST(test3));
    }
}