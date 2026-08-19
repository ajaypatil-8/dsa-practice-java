// Problem: Delete Node in a BST
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/delete-node-in-a-bst/

public class DeleteNodeInABST {

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

    public TreeNode deleteNode(TreeNode root, int tar) {

        if (root == null) {
            return null;
        }

        if (root.val > tar) {
            root.left = deleteNode(root.left, tar);

        } else if (root.val < tar) {
            root.right = deleteNode(root.right, tar);

        } else {

            // No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Only right child
            else if (root.left == null) {
                return root.right;
            }

            // Only left child
            else if (root.right == null) {
                return root.left;
            }

            // Two children
            else {
                TreeNode pred = root.left;

                while (pred.right != null) {
                    pred = pred.right;
                }

                root.left = deleteNode(root.left, pred.val);

                pred.left = root.left;
                pred.right = root.right;

                return pred;
            }
        }

        return root;
    }

    public static void main(String[] args) {

        DeleteNodeInABST solution =
                new DeleteNodeInABST();

        // Test 1: [5,3,6,2,4,null,7], delete 3
        TreeNode test1 = new TreeNode(5);
        test1.left = new TreeNode(3);
        test1.right = new TreeNode(6);
        test1.left.left = new TreeNode(2);
        test1.left.right = new TreeNode(4);
        test1.right.right = new TreeNode(7);

        TreeNode result1 = solution.deleteNode(test1, 3);

        System.out.print("Test 1: ");
        printInorder(result1);
        System.out.println();

        // Test 2: [5,3,6,2,4,null,7], delete 0
        TreeNode test2 = new TreeNode(5);
        test2.left = new TreeNode(3);
        test2.right = new TreeNode(6);
        test2.left.left = new TreeNode(2);
        test2.left.right = new TreeNode(4);
        test2.right.right = new TreeNode(7);

        TreeNode result2 = solution.deleteNode(test2, 0);

        System.out.print("Test 2: ");
        printInorder(result2);
        System.out.println();

        // Test 3: single node
        TreeNode test3 = new TreeNode(1);

        TreeNode result3 = solution.deleteNode(test3, 1);

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