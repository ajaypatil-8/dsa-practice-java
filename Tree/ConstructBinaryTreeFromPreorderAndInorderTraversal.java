// Problem: Construct Binary Tree from Preorder and Inorder Traversal
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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

    public TreeNode build(int plo, int phi, int inlo, int inhi,
                          int[] pre, int[] in) {

        if (plo > phi || inlo > inhi) {
            return null;
        }

        TreeNode root = new TreeNode(pre[plo]);

        int r = 0;

        // find root in inorder
        for (int i = inlo; i <= inhi; i++) {
            if (in[i] == pre[plo]) {
                r = i;
                break;
            }
        }

        int lst = r - inlo;

        root.left = build(
                plo + 1,
                plo + lst,
                inlo,
                r - 1,
                pre,
                in
        );

        root.right = build(
                plo + 1 + lst,
                phi,
                r + 1,
                inhi,
                pre,
                in
        );

        return root;
    }

    public TreeNode buildTree(int[] pre, int[] in) {

        int n = pre.length;

        return build(
                0,
                n - 1,
                0,
                n - 1,
                pre,
                in
        );
    }

    public static void main(String[] args) {

        ConstructBinaryTreeFromPreorderAndInorderTraversal solution =
                new ConstructBinaryTreeFromPreorderAndInorderTraversal();

        // Test 1: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        int[] pre1 = {3, 9, 20, 15, 7};
        int[] in1 = {9, 3, 15, 20, 7};

        TreeNode result1 = solution.buildTree(pre1, in1);

        // Test 2: preorder = [-1], inorder = [-1]
        int[] pre2 = {-1};
        int[] in2 = {-1};

        TreeNode result2 = solution.buildTree(pre2, in2);

        // Test 3: empty tree
        int[] pre3 = {};
        int[] in3 = {};

        TreeNode result3 = solution.buildTree(pre3, in3);

        System.out.println("Test 1: " + preorder(result1));
        System.out.println("Test 2: " + preorder(result2));
        System.out.println("Test 3: " + preorder(result3));
    }

    private static String preorder(TreeNode root) {

        if (root == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        buildPreorder(root, sb);

        return "[" + sb.toString().trim().replace(" ", ", ") + "]";
    }

    private static void buildPreorder(TreeNode root, StringBuilder sb) {

        if (root == null) {
            return;
        }

        sb.append(root.val).append(" ");
        buildPreorder(root.left, sb);
        buildPreorder(root.right, sb);
    }
}