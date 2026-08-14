// Problem: Diameter of Binary Tree
// Difficulty: Easy
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/diameter-of-binary-tree/

public class DiameterOfBinaryTree {

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

    int diameter = 0;

    public int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);

        return diameter;
    }

    public static void main(String[] args) {

        DiameterOfBinaryTree solution = new DiameterOfBinaryTree();

        // Test 1: [1,2,3,4,5]
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(3);
        test1.left.left = new TreeNode(4);
        test1.left.right = new TreeNode(5);

        // Test 2: [1,2]
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);

        // Test 3: single node
        TreeNode test3 = new TreeNode(1);

        System.out.println("Test 1: " +
                solution.diameterOfBinaryTree(test1));

        DiameterOfBinaryTree solution2 = new DiameterOfBinaryTree();

        System.out.println("Test 2: " +
                solution2.diameterOfBinaryTree(test2));

        DiameterOfBinaryTree solution3 = new DiameterOfBinaryTree();

        System.out.println("Test 3: " +
                solution3.diameterOfBinaryTree(test3));
    }
}