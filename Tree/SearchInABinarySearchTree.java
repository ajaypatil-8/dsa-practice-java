// Problem: Search in a Binary Search Tree
// Difficulty: Easy
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/search-in-a-binary-search-tree/

public class SearchInABinarySearchTree {

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

    TreeNode ans = null;

    public void find(TreeNode root, int val) {

        if (root == null) {
            return;
        }

        if (root.val == val) {
            ans = root;
        } else if (root.val > val) {
            find(root.left, val);
        } else {
            find(root.right, val);
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        find(root, val);
        return ans;
    }

    public static void main(String[] args) {

        SearchInABinarySearchTree solution =
                new SearchInABinarySearchTree();

        // Test 1: [4,2,7,1,3], val = 2
        TreeNode test1 = new TreeNode(4);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(7);
        test1.left.left = new TreeNode(1);
        test1.left.right = new TreeNode(3);

        TreeNode result1 = solution.searchBST(test1, 2);
        System.out.println("Test 1: " + (result1 != null ? result1.val : null));

        // Test 2: [4,2,7,1,3], val = 5
        SearchInABinarySearchTree solution2 =
                new SearchInABinarySearchTree();

        TreeNode result2 = solution2.searchBST(test1, 5);
        System.out.println("Test 2: " + (result2 != null ? result2.val : null));

        // Test 3: single node
        SearchInABinarySearchTree solution3 =
                new SearchInABinarySearchTree();

        TreeNode test3 = new TreeNode(1);
        TreeNode result3 = solution3.searchBST(test3, 1);

        System.out.println("Test 3: " + (result3 != null ? result3.val : null));
    }
}