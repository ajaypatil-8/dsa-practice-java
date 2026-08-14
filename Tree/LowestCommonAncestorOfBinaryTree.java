// Problem: Lowest Common Ancestor of a Binary Tree
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

public class LowestCommonAncestorOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l != null && r != null) {
            return root;
        }

        return (l == null) ? r : l;
    }

    public static void main(String[] args) {

        LowestCommonAncestorOfBinaryTree solution =
                new LowestCommonAncestorOfBinaryTree();

        // Test 1: [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;
        TreeNode q = root.right;

        System.out.println("Test 1: " +
                solution.lowestCommonAncestor(root, p, q).val);

        // Test 2: p = 5, q = 4
        TreeNode p2 = root.left;
        TreeNode q2 = root.left.right.right;

        System.out.println("Test 2: " +
                solution.lowestCommonAncestor(root, p2, q2).val);

        // Test 3: same node
        TreeNode p3 = root.left;
        TreeNode q3 = root.left;

        System.out.println("Test 3: " +
                solution.lowestCommonAncestor(root, p3, q3).val);
    }
}