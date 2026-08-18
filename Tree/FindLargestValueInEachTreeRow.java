// Problem: Find Largest Value in Each Tree Row
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {

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

        Pair(TreeNode root, int level) {
            this.root = root;
            this.level = level;
        }
    }

    public List<Integer> largestValues(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        if (root == null) {
            return list;
        }

        q.add(new Pair(root, 0));

        int curr = 0;
        int max = Integer.MIN_VALUE;

        while (q.size() > 0) {

            Pair front = q.poll();

            if (curr != front.level) {
                list.add(max);
                curr++;
                max = Integer.MIN_VALUE;
            }

            if (curr == front.level) {
                max = Math.max(max, front.root.val);
            }

            if (front.root.left != null) {
                q.add(new Pair(front.root.left, front.level + 1));
            }

            if (front.root.right != null) {
                q.add(new Pair(front.root.right, front.level + 1));
            }
        }

        list.add(max);

        return list;
    }

    public static void main(String[] args) {

        FindLargestValueInEachTreeRow solution =
                new FindLargestValueInEachTreeRow();

        // Test 1: [1,3,2,5,3,null,9]
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(3);
        test1.right = new TreeNode(2);
        test1.left.left = new TreeNode(5);
        test1.left.right = new TreeNode(3);
        test1.right.right = new TreeNode(9);

        // Test 2: [1,2,3]
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);

        // Test 3: single node
        TreeNode test3 = new TreeNode(7);

        System.out.println("Test 1: " + solution.largestValues(test1));
        System.out.println("Test 2: " + solution.largestValues(test2));
        System.out.println("Test 3: " + solution.largestValues(test3));
    }
}