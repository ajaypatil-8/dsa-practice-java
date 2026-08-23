// Problem: Find Bottom Left Tree Value
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/find-bottom-left-tree-value/

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

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

    static class Pair {
        TreeNode root;
        int level;

        Pair(int level, TreeNode root) {
            this.level = level;
            this.root = root;
        }
    }

    public int findBottomLeftValue(TreeNode root) {

        if (root.left == null && root.right == null) {
            return root.val;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));

        int ans = 0;
        int curr = 0;

        while (q.size() > 0) {

            Pair front = q.remove();

            if (front.level > curr) {
                ans = front.root.val;
                curr = front.level;
            }

            if (front.root.left != null) {
                q.add(new Pair(front.level + 1, front.root.left));
            }

            if (front.root.right != null) {
                q.add(new Pair(front.level + 1, front.root.right));
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        FindBottomLeftTreeValue solution =
                new FindBottomLeftTreeValue();

        // Test 1: [2,1,3]
        TreeNode test1 = new TreeNode(2);
        test1.left = new TreeNode(1);
        test1.right = new TreeNode(3);

        // Test 2: [1,2,3,4,null,5,6,null,null,7]
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);
        test2.left.left = new TreeNode(4);
        test2.right.left = new TreeNode(5);
        test2.right.right = new TreeNode(6);
        test2.right.left.left = new TreeNode(7);

        // Test 3: single node
        TreeNode test3 = new TreeNode(1);

        System.out.println("Test 1: " + solution.findBottomLeftValue(test1));
        System.out.println("Test 2: " + solution.findBottomLeftValue(test2));
        System.out.println("Test 3: " + solution.findBottomLeftValue(test3));
    }
}