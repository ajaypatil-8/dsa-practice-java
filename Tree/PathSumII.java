// Problem: Path Sum II
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/path-sum-ii/

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

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

    List<Integer> list = new ArrayList<>();

    public void path(List<List<Integer>> ans, int tar, TreeNode root) {

        if (root == null) {
            return;
        }

        list.add(root.val);
        tar = tar - root.val;

        if (root.left == null && root.right == null) {

            if (tar == 0) {
                ans.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            }
        }

        path(ans, tar, root.left);
        path(ans, tar, root.right);

        list.remove(list.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int tar) {

        List<List<Integer>> ans = new ArrayList<>();

        path(ans, tar, root);

        return ans;
    }

    public static void main(String[] args) {

        PathSumII solution = new PathSumII();

        // Test 1: [5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode test1 = new TreeNode(5);
        test1.left = new TreeNode(4);
        test1.right = new TreeNode(8);

        test1.left.left = new TreeNode(11);
        test1.left.left.left = new TreeNode(7);
        test1.left.left.right = new TreeNode(2);

        test1.right.left = new TreeNode(13);
        test1.right.right = new TreeNode(4);
        test1.right.right.left = new TreeNode(5);
        test1.right.right.right = new TreeNode(1);

        System.out.println("Test 1: " + solution.pathSum(test1, 22));

        // Test 2: [1,2,3]
        PathSumII solution2 = new PathSumII();

        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);

        System.out.println("Test 2: " + solution2.pathSum(test2, 5));

        // Test 3: single node
        PathSumII solution3 = new PathSumII();

        TreeNode test3 = new TreeNode(1);

        System.out.println("Test 3: " + solution3.pathSum(test3, 1));
    }
}