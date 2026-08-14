// Problem: Flatten Binary Tree to Linked List
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {

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

    public void dfs(TreeNode root, List<TreeNode> list) {

        if (root == null) {
            return;
        }

        list.add(root);

        dfs(root.left, list);
        dfs(root.right, list);
    }

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        List<TreeNode> list = new ArrayList<>();

        dfs(root, list);

        TreeNode curr = root;

        for (int i = 1; i < list.size(); i++) {

            curr.right = list.get(i);
            curr.left = null;

            curr = curr.right;
        }
    }

    public static void main(String[] args) {

        FlattenBinaryTreeToLinkedList solution =
                new FlattenBinaryTreeToLinkedList();

        // Test 1: [1,2,5,3,4,null,6]
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(5);
        test1.left.left = new TreeNode(3);
        test1.left.right = new TreeNode(4);
        test1.right.right = new TreeNode(6);

        solution.flatten(test1);

        System.out.print("Test 1: ");
        printFlattenedTree(test1);

        // Test 2: single node
        TreeNode test2 = new TreeNode(1);

        solution.flatten(test2);

        System.out.print("Test 2: ");
        printFlattenedTree(test2);

        // Test 3: empty tree
        TreeNode test3 = null;

        solution.flatten(test3);

        System.out.print("Test 3: ");
        printFlattenedTree(test3);
    }

    private static void printFlattenedTree(TreeNode root) {

        while (root != null) {

            System.out.print(root.val);

            if (root.right != null) {
                System.out.print(" -> ");
            }

            root = root.right;
        }

        System.out.println();
    }
}