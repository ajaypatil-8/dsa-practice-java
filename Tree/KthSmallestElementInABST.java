// Problem: Kth Smallest Element in a BST
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

import java.util.*;

public class KthSmallestElementInABST {

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

    public void find(TreeNode root, int[] count) {

        if (root == null) {
            return;
        }

        find(root.left, count);

        if (count[0] == 1) {
            count[1] = root.val;
            count[0]--;
            return;
        } else {
            count[0]--;
        }

        find(root.right, count);
    }

    public int kthSmallest(TreeNode root, int k) {

        int[] count = {k, 0};

        find(root, count);

        return count[1];
    }

    public static void main(String[] args) {

        KthSmallestElementInABST solution =
                new KthSmallestElementInABST();

        // Test 1: [3,1,4,null,2], k = 1
        TreeNode test1 = new TreeNode(3);
        test1.left = new TreeNode(1);
        test1.right = new TreeNode(4);
        test1.left.right = new TreeNode(2);

        // Test 2: [5,3,6,2,4,null,null,1], k = 3
        TreeNode test2 = new TreeNode(5);
        test2.left = new TreeNode(3);
        test2.right = new TreeNode(6);
        test2.left.left = new TreeNode(2);
        test2.left.right = new TreeNode(4);
        test2.left.left.left = new TreeNode(1);

        // Test 3: single node
        TreeNode test3 = new TreeNode(1);

        System.out.println("Test 1: " +
                solution.kthSmallest(test1, 1));

        System.out.println("Test 2: " +
                solution.kthSmallest(test2, 3));

        System.out.println("Test 3: " +
                solution.kthSmallest(test3, 1));
    }
}