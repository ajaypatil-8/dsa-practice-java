// Problem: Convert BST to Greater Tree
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/convert-bst-to-greater-tree/

public class ConvertBSTToGreaterTree {

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

    public static void in(TreeNode root, int[] sum) {

        if (root == null) {
            return;
        }

        in(root.right, sum);

        root.val = root.val + sum[0];
        sum[0] = root.val;

        in(root.left, sum);
    }

    public TreeNode convertBST(TreeNode root) {

        int[] sum = {0};

        in(root, sum);

        return root;
    }

    public static void main(String[] args) {

        ConvertBSTToGreaterTree solution =
                new ConvertBSTToGreaterTree();

        // Test 1: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        TreeNode test1 = new TreeNode(4);
        test1.left = new TreeNode(1);
        test1.right = new TreeNode(6);
        test1.left.left = new TreeNode(0);
        test1.left.right = new TreeNode(2);
        test1.left.right.right = new TreeNode(3);
        test1.right.left = new TreeNode(5);
        test1.right.right = new TreeNode(7);
        test1.right.right.right = new TreeNode(8);

        solution.convertBST(test1);

        System.out.println("Test 1: ");
        printInorder(test1);
        System.out.println();

        // Test 2: [0,null,1]
        TreeNode test2 = new TreeNode(0);
        test2.right = new TreeNode(1);

        solution.convertBST(test2);

        System.out.println("Test 2: ");
        printInorder(test2);
        System.out.println();

        // Test 3: single node
        TreeNode test3 = new TreeNode(5);

        solution.convertBST(test3);

        System.out.println("Test 3: ");
        printInorder(test3);
        System.out.println();
    }

    private static void printInorder(TreeNode root) {

        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}