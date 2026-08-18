// Problem: Validate Binary Search Tree
// Difficulty: Medium
// Topic: Tree

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

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

    public static void dfs(TreeNode root, List<Integer> arr) {

        if (root == null) {
            return;
        }

        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
    }

    public boolean isValidBST(TreeNode root) {

        if (root.right == null && root.left == null) {
            return true;
        }

        List<Integer> arr = new ArrayList<>();

        dfs(root, arr);

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) >= arr.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        ValidateBinarySearchTree solution =
                new ValidateBinarySearchTree();

        // Test 1: [2,1,3]
        TreeNode test1 = new TreeNode(2);
        test1.left = new TreeNode(1);
        test1.right = new TreeNode(3);

        // Test 2: [5,1,4,null,null,3,6]
        TreeNode test2 = new TreeNode(5);
        test2.left = new TreeNode(1);
        test2.right = new TreeNode(4);
        test2.right.left = new TreeNode(3);
        test2.right.right = new TreeNode(6);

        // Test 3: single node
        TreeNode test3 = new TreeNode(1);

        System.out.println("Test 1: " + solution.isValidBST(test1));
        System.out.println("Test 2: " + solution.isValidBST(test2));
        System.out.println("Test 3: " + solution.isValidBST(test3));
    }
}