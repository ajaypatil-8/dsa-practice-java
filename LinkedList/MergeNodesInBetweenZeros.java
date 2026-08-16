// Problem: Merge Nodes in Between Zeros
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/merge-nodes-in-between-zeros/

public class MergeNodesInBetweenZeros {

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

    public ListNode mergeNodes(ListNode head) {

        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;

        int sum = 0;

        while (temp != null) {

            if (temp.val != 0) {
                sum += temp.val;
            } else {

                if (sum > 0) {
                    ListNode s = new ListNode(sum);

                    dummy.next = s;
                    sum = 0;
                    dummy = dummy.next;
                }
            }

            temp = temp.next;
        }

        return ans.next;
    }

    public static void main(String[] args) {

        MergeNodesInBetweenZeros solution =
                new MergeNodesInBetweenZeros();

        // Test 1: 0 -> 3 -> 1 -> 0 -> 4 -> 5 -> 2 -> 0
        ListNode test1 = new ListNode(0,
                new ListNode(3,
                new ListNode(1,
                new ListNode(0,
                new ListNode(4,
                new ListNode(5,
                new ListNode(2,
                new ListNode(0))))))));

        // Test 2: 0 -> 1 -> 0 -> 3 -> 0
        ListNode test2 = new ListNode(0,
                new ListNode(1,
                new ListNode(0,
                new ListNode(3,
                new ListNode(0)))));

        // Test 3: 0 -> 5 -> 0 (edge case)
        ListNode test3 = new ListNode(0,
                new ListNode(5,
                new ListNode(0)));

        System.out.print("Test 1: ");
        printList(solution.mergeNodes(test1));

        System.out.print("Test 2: ");
        printList(solution.mergeNodes(test2));

        System.out.print("Test 3: ");
        printList(solution.mergeNodes(test3));
    }

    private static void printList(ListNode head) {

        if (head == null) {
            System.out.println("null");
            return;
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