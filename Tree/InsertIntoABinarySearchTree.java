// Problem: Insert into a Binary Search Tree
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/insert-into-a-binary-search-tree/

public class InsertIntoABinarySearchTree {

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

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {

        InsertIntoABinarySearchTree solution =
                new InsertIntoABinarySearchTree();

        // Test 1: [4,2,7,1,3], insert 5
        TreeNode test1 = new TreeNode(4);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(7);
        test1.left.left = new TreeNode(1);
        test1.left.right = new TreeNode(3);

        TreeNode result1 = solution.insertIntoBST(test1, 5);

        System.out.print("Test 1: ");
        printInorder(result1);
        System.out.println();

        // Test 2: [40,20,60,10,30,50,70], insert 25
        TreeNode test2 = new TreeNode(40);
        test2.left = new TreeNode(20);
        test2.right = new TreeNode(60);
        test2.left.left = new TreeNode(10);
        test2.left.right = new TreeNode(30);
        test2.right.left = new TreeNode(50);
        test2.right.right = new TreeNode(70);

        TreeNode result2 = solution.insertIntoBST(test2, 25);

        System.out.print("Test 2: ");
        printInorder(result2);
        System.out.println();

        // Test 3: empty tree
        TreeNode result3 = solution.insertIntoBST(null, 5);

        System.out.print("Test 3: ");
        printInorder(result3);
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