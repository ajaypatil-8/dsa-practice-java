// Problem: Convert Sorted Array to Binary Search Tree
// Difficulty: Easy
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

public class ConvertSortedArrayToBinarySearchTree {

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

    public TreeNode construct(int low, int high, int[] arr) {

        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;

        TreeNode root = new TreeNode(arr[mid]);

        // build both halves
        root.left = construct(low, mid - 1, arr);
        root.right = construct(mid + 1, high, arr);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        return construct(low, high, arr);
    }

    public static void main(String[] args) {

        ConvertSortedArrayToBinarySearchTree solution =
                new ConvertSortedArrayToBinarySearchTree();

        // Test 1: [-10,-3,0,5,9]
        int[] test1 = {-10, -3, 0, 5, 9};

        // Test 2: [1,3]
        int[] test2 = {1, 3};

        // Test 3: [1] - edge case
        int[] test3 = {1};

        System.out.print("Test 1: ");
        printPreorder(solution.sortedArrayToBST(test1));

        System.out.print("Test 2: ");
        printPreorder(solution.sortedArrayToBST(test2));

        System.out.print("Test 3: ");
        printPreorder(solution.sortedArrayToBST(test3));
    }

    private static void printPreorder(TreeNode root) {

        if (root == null) {
            System.out.println("[]");
            return;
        }

        System.out.print("[");

        boolean[] first = {true};
        preorder(root, first);

        System.out.println("]");
    }

    private static void preorder(TreeNode root, boolean[] first) {

        if (root == null) {
            return;
        }

        if (!first[0]) {
            System.out.print(", ");
        }

        System.out.print(root.val);
        first[0] = false;

        preorder(root.left, first);
        preorder(root.right, first);
    }
}