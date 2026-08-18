// Problem: Lowest Common Ancestor of a Binary Search Tree
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

public class LowestCommonAncestorOfABinarySearchTree {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {

        LowestCommonAncestorOfABinarySearchTree solution =
                new LowestCommonAncestorOfABinarySearchTree();

        // Test 1: [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        TreeNode test1 = new TreeNode(6);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(8);
        test1.left.left = new TreeNode(0);
        test1.left.right = new TreeNode(4);
        test1.left.right.left = new TreeNode(3);
        test1.left.right.right = new TreeNode(5);
        test1.right.left = new TreeNode(7);
        test1.right.right = new TreeNode(9);

        TreeNode result1 = solution.lowestCommonAncestor(
                test1, test1.left, test1.right
        );

        // Test 2: p = 2, q = 4
        TreeNode result2 = solution.lowestCommonAncestor(
                test1, test1.left, test1.left.right
        );

        // Test 3: single node
        TreeNode test3 = new TreeNode(1);

        TreeNode result3 = solution.lowestCommonAncestor(
                test3, test3, test3
        );

        System.out.println("Test 1: " + result1.val);
        System.out.println("Test 2: " + result2.val);
        System.out.println("Test 3: " + result3.val);
    }
}