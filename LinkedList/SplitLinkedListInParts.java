// Problem: Split Linked List in Parts
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/split-linked-list-in-parts/

public class SplitLinkedListInParts {

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

    public ListNode[] splitListToParts(ListNode head, int k) {

        if (head == null) {
            return new ListNode[k];
        }

        ListNode[] arr = new ListNode[k];

        int count = 0;
        ListNode temp = head;

        // count nodes
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int base = count / k;
        int extra = count % k;

        ListNode curr = head;

        for (int j = 0; j < k; j++) {

            if (curr != null) {
                arr[j] = curr;
            }

            int list = base + (extra > 0 ? 1 : 0);

            if (extra > 0) {
                extra--;
            }

            if (curr == null) {
                continue;
            }

            // move to last node of current part
            for (int i = 1; i < list; i++) {
                curr = curr.next;
            }

            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }

        return arr;
    }

    public static void main(String[] args) {

        SplitLinkedListInParts solution = new SplitLinkedListInParts();

        // Test 1: 1 -> 2 -> 3, k = 5
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3)));

        ListNode[] ans1 = solution.splitListToParts(test1, 5);

        System.out.println("Test 1:");
        printParts(ans1);

        // Test 2: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10, k = 3
        ListNode test2 = new ListNode(1,
                new ListNode(2,
                new ListNode(3,
                new ListNode(4,
                new ListNode(5,
                new ListNode(6,
                new ListNode(7,
                new ListNode(8,
                new ListNode(9,
                new ListNode(10))))))))));

        ListNode[] ans2 = solution.splitListToParts(test2, 3);

        System.out.println("Test 2:");
        printParts(ans2);

        // Test 3: null list (edge case)
        ListNode[] ans3 = solution.splitListToParts(null, 3);

        System.out.println("Test 3:");
        printParts(ans3);
    }

    private static void printParts(ListNode[] parts) {

        for (ListNode head : parts) {

            if (head == null) {
                System.out.println("null");
                continue;
            }

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
}