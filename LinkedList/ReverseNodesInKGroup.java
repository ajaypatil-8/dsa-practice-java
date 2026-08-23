// Problem: Reverse Nodes in k-Group
// Difficulty: Hard
// Topic: Linked List

public class ReverseNodesInKGroup {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode fwd = null;

        while (curr != null) {
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }

        return prev;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        int size = 0;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (size == k) {
            return reverse(head);
        }

        int r = size / k;
        int s = size % k;

        temp = reverse(head);
        ListNode d = temp;

        if (s != 0) {
            for (int i = 0; i < s - 1; i++) {
                temp = temp.next;
            }
        }

        ListNode prev = temp;
        temp = temp.next;

        if (s == 0) {
            prev = new ListNode(0);
            temp = d;
        }

        for (int i = 0; i < r; i++) {

            ListNode pre = null;
            ListNode curr = temp;
            ListNode fwd = null;

            for (int j = 0; j < k; j++) {
                fwd = curr.next;
                curr.next = pre;
                pre = curr;
                curr = fwd;
            }

            prev.next = pre;

            if (i == 0 && s == 0) {
                d = pre;
            }

            prev = temp;
            temp.next = curr;
            temp = curr;
        }

        ListNode a = reverse(d);

        return a;
    }

    public static void main(String[] args) {

        // Test 1: 1 -> 2 -> 3 -> 4 -> 5, k = 2
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        // Test 2: 1 -> 2 -> 3 -> 4 -> 5, k = 3
        ListNode test2 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5)))));

        // Test 3: 1 -> 2, k = 3 (edge case)
        ListNode test3 = new ListNode(1,
                new ListNode(2));

        System.out.print("Test 1: ");
        printList(reverseKGroup(test1, 2));

        System.out.print("Test 2: ");
        printList(reverseKGroup(test2, 3));

        System.out.print("Test 3: ");
        printList(reverseKGroup(test3, 3));
    }

    private static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }
}