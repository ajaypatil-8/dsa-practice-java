// Problem: Flatten a Multilevel Doubly Linked List
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

public class FlattenAMultilevelDoublyLinkedList {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node(int val) {
            this.val = val;
        }
    }

    public Node flatten(Node head) {

        if (head == null) {
            return head;
        }

        Node curr = head;

        while (curr != null) {

            if (curr.child == null) {
                curr = curr.next;
            } else {

                Node nex = curr.next;

                // flatten child list
                Node c = flatten(curr.child);

                curr.child = null;
                curr.next = c;
                c.prev = curr;

                // reach end of child list
                Node temp = c;
                while (temp.next != null) {
                    temp = temp.next;
                }

                // attach remaining list
                temp.next = nex;

                if (nex != null) {
                    nex.prev = temp;
                }

                curr = nex;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        FlattenAMultilevelDoublyLinkedList solution =
                new FlattenAMultilevelDoublyLinkedList();

        // Test 1: 1-2-3 with 2 having child 4-5
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.next = two;
        two.prev = one;
        two.next = three;
        three.prev = two;

        two.child = four;
        four.next = five;
        five.prev = four;

        System.out.print("Test 1: ");
        printList(solution.flatten(one));

        // Test 2: 1 with child 2
        Node a = new Node(1);
        Node b = new Node(2);
        a.child = b;

        System.out.print("Test 2: ");
        printList(solution.flatten(a));

        // Test 3: null (edge case)
        System.out.print("Test 3: ");
        printList(solution.flatten(null));
    }

    private static void printList(Node head) {

        if (head == null) {
            System.out.println("null");
            return;
        }

        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" <-> ");
            }
            head = head.next;
        }

        System.out.println();
    }
}