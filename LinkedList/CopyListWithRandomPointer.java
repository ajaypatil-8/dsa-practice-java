// Problem: Copy List with Random Pointer
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/copy-list-with-random-pointer/

public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    public Node deepcopy(Node head) {

        Node temp1 = head;
        Node dummy = new Node(0);
        Node head2 = dummy;

        while (temp1 != null) {

            dummy.next = new Node(temp1.val);
            dummy = dummy.next;
            temp1 = temp1.next;
        }

        return head2.next;
    }

    public void merge(Node head, Node head2) {

        Node dummy = new Node(0);
        Node h1 = head;
        Node h2 = head2;

        // insert copied nodes
        while (h2 != null) {

            dummy.next = h1;
            h1 = h1.next;
            dummy = dummy.next;

            dummy.next = h2;
            h2 = h2.next;
            dummy = dummy.next;
        }
    }

    public void random(Node head, Node head2) {

        Node temp1 = head;
        Node temp2 = head2;

        // assign random pointers
        while (temp1.next.next != null) {

            if (temp1.random == null) {
                temp2.random = null;
            } else {
                temp2.random = temp1.random.next;
            }

            temp1 = temp2.next;
            temp2 = temp1.next;
        }

        if (temp1.random == null) {
            temp2.random = null;
        } else {
            temp2.random = temp1.random.next;
        }
    }

    public void split(Node head) {

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);

        Node temp1 = dummy1;
        Node temp2 = dummy2;
        Node t = head;

        // separate original and copied lists
        while (t != null) {

            temp1.next = t;
            t = t.next;
            temp1 = temp1.next;

            temp2.next = t;
            t = t.next;
            temp2 = temp2.next;
        }

        temp1.next = null;
    }

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node head2 = deepcopy(head);

        merge(head, head2);
        random(head, head2);
        split(head);

        return head2;
    }

    public static void main(String[] args) {

        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();

        // Test 1
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Node copy1 = solution.copyRandomList(n1);
        System.out.println("Test 1: " + (copy1 != null));

        // Test 2
        Node a = new Node(1);
        a.random = a;

        Node copy2 = solution.copyRandomList(a);
        System.out.println("Test 2: " + (copy2.random == copy2));

        // Test 3 (edge case)
        Node copy3 = solution.copyRandomList(null);
        System.out.println("Test 3: " + (copy3 == null));
    }
}