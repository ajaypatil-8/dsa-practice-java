// Problem: BST to Max Heap
// Difficulty: Medium
// Topic: Tree
// GFG Link: https://www.geeksforgeeks.org/problems/bst-to-max-heap/1

import java.util.ArrayList;

public class BSTToMaxHeap {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void store(ArrayList<Integer> arr, Node root) {

        if (root == null) {
            return;
        }

        store(arr, root.left);
        arr.add(root.data);
        store(arr, root.right);
    }

    public static void post(ArrayList<Integer> arr, Node root, int[] idx) {

        if (root == null) {
            return;
        }

        post(arr, root.left, idx);
        post(arr, root.right, idx);

        root.data = arr.get(idx[0]);
        idx[0] = idx[0] + 1;
    }

    public static void convertToMaxHeap(Node root) {

        ArrayList<Integer> arr = new ArrayList<>();

        store(arr, root);

        int[] idx = {0};

        post(arr, root, idx);
    }

    public static void main(String[] args) {

        // Test 1: BST [4,2,6,1,3,5,7]
        Node test1 = new Node(4);
        test1.left = new Node(2);
        test1.right = new Node(6);
        test1.left.left = new Node(1);
        test1.left.right = new Node(3);
        test1.right.left = new Node(5);
        test1.right.right = new Node(7);

        convertToMaxHeap(test1);

        System.out.println("Test 1: ");
        printPreorder(test1);
        System.out.println();

        // Test 2: BST [4,2,5,1,3]
        Node test2 = new Node(4);
        test2.left = new Node(2);
        test2.right = new Node(5);
        test2.left.left = new Node(1);
        test2.left.right = new Node(3);

        convertToMaxHeap(test2);

        System.out.println("Test 2: ");
        printPreorder(test2);
        System.out.println();

        // Test 3: single node
        Node test3 = new Node(10);

        convertToMaxHeap(test3);

        System.out.println("Test 3: ");
        printPreorder(test3);
        System.out.println();
    }

    private static void printPreorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        printPreorder(root.left);
        printPreorder(root.right);
    }
}