// Problem: Nth Node from End of Linked List
// Difficulty: Easy
// Topic: Linked List
// GFG Link: https://www.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1

public class NthNodeFromEndOfLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public int getKthFromLast(Node head, int k) {

        Node slow = head;
        Node fast = head;

        // move fast k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return -1;
            }
            fast = fast.next;
        }

        // move both together
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    public static void main(String[] args) {
        NthNodeFromEndOfLinkedList solution = new NthNodeFromEndOfLinkedList();

        // Test 1: 1 -> 2 -> 3 -> 4 -> 5, k = 2
        Node test1 = new Node(1);
        test1.next = new Node(2);
        test1.next.next = new Node(3);
        test1.next.next.next = new Node(4);
        test1.next.next.next.next = new Node(5);

        // Test 2: 10 -> 20 -> 30, k = 3
        Node test2 = new Node(10);
        test2.next = new Node(20);
        test2.next.next = new Node(30);

        // Test 3: 1 -> 2, k = 3 (edge case)
        Node test3 = new Node(1);
        test3.next = new Node(2);

        System.out.println("Test 1: " + solution.getKthFromLast(test1, 2));
        System.out.println("Test 2: " + solution.getKthFromLast(test2, 3));
        System.out.println("Test 3: " + solution.getKthFromLast(test3, 3));
    }
}