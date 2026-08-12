// Problem: Root to Leaf Paths
// Difficulty: Medium
// Topic: Tree
// GFG Link: 

import java.util.ArrayList;

public class RootToLeafPaths {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            this.data = val;
            left = null;
            right = null;
        }
    }

    public void dfs(Node root, ArrayList<ArrayList<Integer>> ans,
                    ArrayList<Integer> arr) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            arr.add(root.data);

            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(arr);
            ans.add(list);

            arr.remove(arr.size() - 1);
            return;
        }

        arr.add(root.data);

        dfs(root.left, ans, arr);
        dfs(root.right, ans, arr);

        arr.remove(arr.size() - 1);
    }

    public ArrayList<ArrayList<Integer>> paths(Node root) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        dfs(root, ans, arr);

        return ans;
    }

    public static void main(String[] args) {

        RootToLeafPaths solution = new RootToLeafPaths();

        // Test 1
        Node test1 = new Node(1);
        test1.left = new Node(2);
        test1.right = new Node(3);
        test1.left.left = new Node(4);
        test1.left.right = new Node(5);

        // Test 2
        Node test2 = new Node(1);
        test2.left = new Node(2);
        test2.right = new Node(3);

        // Test 3: single node
        Node test3 = new Node(1);

        System.out.println("Test 1: " + solution.paths(test1));
        System.out.println("Test 2: " + solution.paths(test2));
        System.out.println("Test 3: " + solution.paths(test3));
    }
}