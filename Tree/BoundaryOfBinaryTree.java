// Problem: Boundary of Binary Tree
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/boundary-of-binary-tree/description/
// GFG Link: https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {

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

    public void leftBoundary(TreeNode root, List<Integer> ans) {

        if (root.left == null && root.right == null) {
            return;
        }

        ans.add(root.val);

        if (root.left != null) {
            leftBoundary(root.left, ans);
        } else {
            leftBoundary(root.right, ans);
        }
    }

    public void leafBoundary(TreeNode root, List<Integer> ans) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ans.add(root.val);
        }

        leafBoundary(root.left, ans);
        leafBoundary(root.right, ans);
    }

    public void rightBoundary(TreeNode root, List<Integer> ans) {

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.right != null) {
            rightBoundary(root.right, ans);
        } else {
            rightBoundary(root.left, ans);
        }

        ans.add(root.val);
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        ans.add(root.val);

        if (root.left == null && root.right == null) {
            return ans;
        }

        if (root.left != null) {
            leftBoundary(root.left, ans);
        }

        leafBoundary(root, ans);

        if (root.right != null) {
            rightBoundary(root.right, ans);
        }

        return ans;
    }

    public static void main(String[] args) {

        BoundaryOfBinaryTree solution = new BoundaryOfBinaryTree();

        // Test 1: [1,2,3,4,5,6,7]
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(3);
        test1.left.left = new TreeNode(4);
        test1.left.right = new TreeNode(5);
        test1.right.left = new TreeNode(6);
        test1.right.right = new TreeNode(7);

        // Test 2: [1,null,2,3,4]
        TreeNode test2 = new TreeNode(1);
        test2.right = new TreeNode(2);
        test2.right.left = new TreeNode(3);
        test2.right.right = new TreeNode(4);

        // Test 3: single node
        TreeNode test3 = new TreeNode(1);

        System.out.println("Test 1: " + solution.boundaryOfBinaryTree(test1));
        System.out.println("Test 2: " + solution.boundaryOfBinaryTree(test2));
        System.out.println("Test 3: " + solution.boundaryOfBinaryTree(test3));
    }
}