// Problem: Binary Tree Level Order Traversal II
// Difficulty: Medium
// Topic: Tree

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.size() > 0) {

            List<Integer> list = new ArrayList<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {

                TreeNode front = q.remove();

                list.add(front.val);

                if (front.left != null) {
                    q.add(front.left);
                }

                if (front.right != null) {
                    q.add(front.right);
                }
            }

            ans.add(list);
        }

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {

        BinaryTreeLevelOrderTraversalII solution =
                new BinaryTreeLevelOrderTraversalII();

        // Test 1: [3,9,20,null,null,15,7]
        TreeNode test1 = new TreeNode(3);
        test1.left = new TreeNode(9);
        test1.right = new TreeNode(20);
        test1.right.left = new TreeNode(15);
        test1.right.right = new TreeNode(7);

        // Test 2: [1]
        TreeNode test2 = new TreeNode(1);

        // Test 3: empty tree
        TreeNode test3 = null;

        System.out.println("Test 1: " + solution.levelOrderBottom(test1));
        System.out.println("Test 2: " + solution.levelOrderBottom(test2));
        System.out.println("Test 3: " + solution.levelOrderBottom(test3));
    }
}