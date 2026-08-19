// Problem: Binary Tree Inorder Traversal
// Difficulty: Easy
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {

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

    public static void morrisTraversal(TreeNode root, List<Integer> arr) {

        TreeNode c = root;

        while (c != null) {

            if (c.left != null) {

                TreeNode pred = c.left;

                while (pred.right != null && pred.right != c) {
                    pred = pred.right;
                }

                if (pred.right == null) {

                    pred.right = c;
                    c = c.left;

                } else {

                    pred.right = null;
                    arr.add(c.val);
                    c = c.right;
                }

            } else {

                arr.add(c.val);
                c = c.right;
            }
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> arr = new ArrayList<>();

        morrisTraversal(root, arr);

        return arr;
    }

    public static void main(String[] args) {

        MorrisInorderTraversal solution =
                new MorrisInorderTraversal();

        // Test 1: [1,null,2,3]
        TreeNode test1 = new TreeNode(1);
        test1.right = new TreeNode(2);
        test1.right.left = new TreeNode(3);

        // Test 2: [1,2,3,4,5,null,6]
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);
        test2.left.left = new TreeNode(4);
        test2.left.right = new TreeNode(5);
        test2.right.right = new TreeNode(6);

        // Test 3: single node
        TreeNode test3 = new TreeNode(1);

        System.out.println("Test 1: " + solution.inorderTraversal(test1));
        System.out.println("Test 2: " + solution.inorderTraversal(test2));
        System.out.println("Test 3: " + solution.inorderTraversal(test3));
    }
}