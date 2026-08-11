// Problem: Binary Tree Preorder Traversal
// Difficulty: Easy
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/binary-tree-preorder-traversal/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

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

    public void dfs(TreeNode root, List<Integer> arr) {

        if (root == null) {
            return;
        }

        arr.add(root.val);

        // root -> left -> right
        dfs(root.left, arr);
        dfs(root.right, arr);
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);

        return arr;
    }

    public static void main(String[] args) {

        BinaryTreePreorderTraversal solution =
                new BinaryTreePreorderTraversal();

        // Test 1: [1,null,2,3]
        TreeNode test1 = new TreeNode(1);
        test1.right = new TreeNode(2);
        test1.right.left = new TreeNode(3);

        // Test 2: [1,2,3,4,5]
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);
        test2.left.left = new TreeNode(4);
        test2.left.right = new TreeNode(5);

        // Test 3: empty tree
        TreeNode test3 = null;

        System.out.println("Test 1: " + solution.preorderTraversal(test1));
        System.out.println("Test 2: " + solution.preorderTraversal(test2));
        System.out.println("Test 3: " + solution.preorderTraversal(test3));
    }
}