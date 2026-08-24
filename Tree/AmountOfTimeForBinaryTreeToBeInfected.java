// Problem: Amount of Time for Binary Tree to Be Infected
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AmountOfTimeForBinaryTreeToBeInfected {

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
        int time;

        Pair() {}

        Pair(TreeNode root, int time) {
            this.root = root;
            this.time = time;
        }
    }

    public static void dfs(Map<TreeNode, TreeNode> map,
                           TreeNode[] arr,
                           TreeNode root,
                           int target) {

        if (root == null) {
            return;
        }

        if (root.val == target) {
            arr[0] = root;
        }

        if (root.left != null) {
            map.put(root.left, root);
        }

        if (root.right != null) {
            map.put(root.right, root);
        }

        dfs(map, arr, root.left, target);
        dfs(map, arr, root.right, target);
    }

    public int amountOfTime(TreeNode root, int target) {

        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode[] arr = {null};

        dfs(map, arr, root, target);

        TreeNode tar = arr[0];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(tar, 0));

        Set<TreeNode> set = new HashSet<>();
        set.add(tar);

        int ans = 0;

        while (q.size() > 0) {

            Pair front = q.remove();

            TreeNode node = front.root;
            int time = front.time;

            ans = Math.max(ans, time);

            if (node.left != null && !set.contains(node.left)) {
                q.add(new Pair(node.left, time + 1));
                set.add(node.left);
            }

            if (node.right != null && !set.contains(node.right)) {
                q.add(new Pair(node.right, time + 1));
                set.add(node.right);
            }

            if (map.containsKey(node) && !set.contains(map.get(node))) {
                q.add(new Pair(map.get(node), time + 1));
                set.add(map.get(node));
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        AmountOfTimeForBinaryTreeToBeInfected solution =
                new AmountOfTimeForBinaryTreeToBeInfected();

        // Test 1: [1,5,3,null,4,10,6,9,2], target = 3
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(5);
        test1.right = new TreeNode(3);

        test1.left.right = new TreeNode(4);
        test1.left.right.left = new TreeNode(9);
        test1.left.right.right = new TreeNode(2);

        test1.right.left = new TreeNode(10);
        test1.right.right = new TreeNode(6);

        // Test 2: [1], target = 1
        TreeNode test2 = new TreeNode(1);

        // Test 3: [1,2,3], target = 2
        TreeNode test3 = new TreeNode(1);
        test3.left = new TreeNode(2);
        test3.right = new TreeNode(3);

        System.out.println("Test 1: " + solution.amountOfTime(test1, 3));
        System.out.println("Test 2: " + solution.amountOfTime(test2, 1));
        System.out.println("Test 3: " + solution.amountOfTime(test3, 2));
    }
}