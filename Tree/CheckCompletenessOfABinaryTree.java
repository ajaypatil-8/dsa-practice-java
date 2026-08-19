// Problem: Check Completeness of a Binary Tree
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/check-completeness-of-a-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {

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

    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.size() > 0) {

            TreeNode front = q.remove();

            if (front == null) {

                // after null, no node should appear
                while (q.size() > 0) {
                    if (q.remove() != null) {
                        return false;
                    }
                }

                return true;
            }

            q.add(front.left);
            q.add(front.right);
        }

        return true;
    }

    public static void main(String[] args) {

        CheckCompletenessOfABinaryTree solution =
                new CheckCompletenessOfABinaryTree();

        // Test 1: [1,2,3,4,5,6]
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(3);
        test1.left.left = new TreeNode(4);
        test1.left.right = new TreeNode(5);
        test1.right.left = new TreeNode(6);

        // Test 2: [1,2,3,4,5,null,7]
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);
        test2.left.left = new TreeNode(4);
        test2.left.right = new TreeNode(5);
        test2.right.right = new TreeNode(7);

        // Test 3: single node
        TreeNode test3 = new TreeNode(1);

        System.out.println("Test 1: " + solution.isCompleteTree(test1));
        System.out.println("Test 2: " + solution.isCompleteTree(test2));
        System.out.println("Test 3: " + solution.isCompleteTree(test3));
    }
}