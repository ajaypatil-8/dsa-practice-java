// Problem: Add Two Numbers II
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/add-two-numbers-ii/

public class AddTwoNumbersII {

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

    public ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {

            // reverse list
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {

        head1 = reverse(head1);
        head2 = reverse(head2);

        int carry = 0;

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (head1 != null || head2 != null) {

            int sum = 0;

            if (head1 == null) {
                sum = head2.val + carry;
            } else if (head2 == null) {
                sum = head1.val + carry;
            } else {
                sum = head1.val + head2.val + carry;
            }

            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;

            carry = sum / 10;

            if (head1 != null) {
                head1 = head1.next;
            }

            if (head2 != null) {
                head2 = head2.next;
            }
        }

        if (carry != 0) {
            dummy.next = new ListNode(carry);
        }

        return reverse(temp.next);
    }

    public static void main(String[] args) {

        AddTwoNumbersII solution = new AddTwoNumbersII();

        // Test 1: 7243 + 564 = 7807
        ListNode l1 = new ListNode(7,
                new ListNode(2,
                new ListNode(4,
                new ListNode(3))));

        ListNode l2 = new ListNode(5,
                new ListNode(6,
                new ListNode(4)));

        // Test 2: 999 + 1 = 1000
        ListNode l3 = new ListNode(9,
                new ListNode(9,
                new ListNode(9)));

        ListNode l4 = new ListNode(1);

        // Test 3: 0 + 0 = 0 (edge case)
        ListNode l5 = new ListNode(0);
        ListNode l6 = new ListNode(0);

        System.out.print("Test 1: ");
        printList(solution.addTwoNumbers(l1, l2));

        System.out.print("Test 2: ");
        printList(solution.addTwoNumbers(l3, l4));

        System.out.print("Test 3: ");
        printList(solution.addTwoNumbers(l5, l6));
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