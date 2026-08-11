// Problem: Invert Binary Tree
// Difficulty: Easy
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/invert-binary-tree/

public class InvertBinaryTree {

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

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        // swap left and right
        TreeNode inv = root.left;
        root.left = root.right;
        root.right = inv;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {

        InvertBinaryTree solution = new InvertBinaryTree();

        // Test 1: [4,2,7,1,3,6,9]
        TreeNode test1 = new TreeNode(4);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(7);
        test1.left.left = new TreeNode(1);
        test1.left.right = new TreeNode(3);
        test1.right.left = new TreeNode(6);
        test1.right.right = new TreeNode(9);

        // Test 2: [2,1,3]
        TreeNode test2 = new TreeNode(2);
        test2.left = new TreeNode(1);
        test2.right = new TreeNode(3);

        // Test 3: empty tree
        TreeNode test3 = null;

        System.out.print("Test 1: ");
        printPreorder(solution.invertTree(test1));

        System.out.print("Test 2: ");
        printPreorder(solution.invertTree(test2));

        System.out.print("Test 3: ");
        printPreorder(solution.invertTree(test3));
    }

    private static void printPreorder(TreeNode root) {

        if (root == null) {
            System.out.println("[]");
            return;
        }

        System.out.print("[");
        preorder(root);
        System.out.println("]");
    }

    private static void preorder(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
}