// Problem: Symmetric Tree
// Difficulty: Easy
// Topic: Tree

public class SymmetricTree {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }

    public boolean isSymmetric(TreeNode root) {

        invertTree(root.left);

        return isSameTree(root.left, root.right);
    }

    public static void main(String[] args) {

        SymmetricTree solution = new SymmetricTree();

        // Test 1: [1,2,2,3,4,4,3]
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(2);
        test1.left.left = new TreeNode(3);
        test1.left.right = new TreeNode(4);
        test1.right.left = new TreeNode(4);
        test1.right.right = new TreeNode(3);

        // Test 2: [1,2,2,null,3,null,3]
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(2);
        test2.left.right = new TreeNode(3);
        test2.right.right = new TreeNode(3);

        // Test 3: [1] (edge case)
        TreeNode test3 = new TreeNode(1);

        System.out.println("Test 1: " + solution.isSymmetric(test1));
        System.out.println("Test 2: " + solution.isSymmetric(test2));
        System.out.println("Test 3: " + solution.isSymmetric(test3));
    }
}