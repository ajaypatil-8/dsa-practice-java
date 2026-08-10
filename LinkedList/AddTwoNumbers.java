// Problem: Add Two Numbers
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        int sum = 0;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode dummy = new ListNode(0);
        ListNode rt = dummy;

        while (temp1 != null || temp2 != null) {

            if (temp1 == null) {
                sum = temp2.val + carry;

                ListNode ans = new ListNode(sum % 10);
                dummy.next = ans;
                dummy = ans;

            } else if (temp2 == null) {
                sum = temp1.val + carry;

                ListNode ans = new ListNode(sum % 10);
                dummy.next = ans;
                dummy = ans;

            } else {
                sum = temp2.val + temp1.val + carry;

                ListNode ans = new ListNode(sum % 10);
                dummy.next = ans;
                dummy = ans;
            }

            carry = sum / 10;

            if (temp1 != null) {
                temp1 = temp1.next;
            }

            if (temp2 != null) {
                temp2 = temp2.next;
            }
        }

        if (carry != 0) {
            ListNode ans = new ListNode(1);
            dummy.next = ans;
        }

        return rt.next;
    }

    public static void main(String[] args) {

        AddTwoNumbers solution = new AddTwoNumbers();

        // Test 1: 342 + 465 = 807
        ListNode l1 = new ListNode(2,
                new ListNode(4,
                new ListNode(3)));

        ListNode l2 = new ListNode(5,
                new ListNode(6,
                new ListNode(4)));

        // Test 2: 999 + 1 = 1000
        ListNode l3 = new ListNode(9,
                new ListNode(9,
                new ListNode(9)));

        ListNode l4 = new ListNode(1);

        // Test 3: 0 + 0 = 0
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