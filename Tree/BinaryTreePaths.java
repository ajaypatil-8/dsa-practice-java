// Problem: Binary Tree Paths
// Difficulty: Easy
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/binary-tree-paths/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

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

    public void paths(List<String> list, TreeNode root, StringBuilder st) {

        if (root == null) {
            return;
        }

        int len = st.length();

        st.append(root.val);

        if (root.left == null && root.right == null) {
            list.add(st.toString());
            st.setLength(len);
            return;
        }

        st.append("->");

        paths(list, root.left, st);
        paths(list, root.right, st);

        st.setLength(len);
    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> list = new ArrayList<>();

        paths(list, root, new StringBuilder());

        return list;
    }

    public static void main(String[] args) {

        BinaryTreePaths solution = new BinaryTreePaths();

        // Test 1: [1,2,3,null,5]
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(3);
        test1.left.right = new TreeNode(5);

        // Test 2: [1]
        TreeNode test2 = new TreeNode(1);

        // Test 3: empty tree
        TreeNode test3 = null;

        System.out.println("Test 1: " + solution.binaryTreePaths(test1));
        System.out.println("Test 2: " + solution.binaryTreePaths(test2));
        System.out.println("Test 3: " + solution.binaryTreePaths(test3));
    }
}