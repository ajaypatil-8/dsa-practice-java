// Problem: Populating Next Right Pointers in Each Node II
// Difficulty: Medium
// Topic: Tree
// LeetCode Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    static class Pair {
        Node root;
        int level;

        Pair(Node root, int level) {
            this.root = root;
            this.level = level;
        }
    }

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (q.size() > 0) {

            Pair front = q.remove();

            if (front.root.left != null) {
                q.add(new Pair(front.root.left, front.level + 1));
            }

            if (front.root.right != null) {
                q.add(new Pair(front.root.right, front.level + 1));
            }

            // connect next node on same level
            if (q.size() > 0 && front.level == q.peek().level) {
                front.root.next = q.peek().root;
            } else {
                front.root.next = null;
            }
        }

        return root;
    }

    public static void main(String[] args) {

        PopulatingNextRightPointersInEachNodeII solution =
                new PopulatingNextRightPointersInEachNodeII();

        // Test 1: [1,2,3,4,5,null,7]
        Node test1 = new Node(1);
        test1.left = new Node(2);
        test1.right = new Node(3);
        test1.left.left = new Node(4);
        test1.left.right = new Node(5);
        test1.right.right = new Node(7);

        solution.connect(test1);

        System.out.println("Test 1: " + printNextLevels(test1));

        // Test 2: [1,2,3,4,null,null,5]
        Node test2 = new Node(1);
        test2.left = new Node(2);
        test2.right = new Node(3);
        test2.left.left = new Node(4);
        test2.right.right = new Node(5);

        solution.connect(test2);

        System.out.println("Test 2: " + printNextLevels(test2));

        // Test 3: single node
        Node test3 = new Node(1);

        solution.connect(test3);

        System.out.println("Test 3: " + printNextLevels(test3));
    }

    private static String printNextLevels(Node root) {

        if (root == null) {
            return "null";
        }

        StringBuilder result = new StringBuilder();

        while (root != null) {

            Node curr = root;

            while (curr != null) {
                result.append(curr.val);

                if (curr.next != null) {
                    result.append(" -> ");
                } else {
                    result.append(" -> #");
                }

                curr = curr.next;
            }

            result.append(" | ");

            // move to next level
            if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return result.toString();
    }
}