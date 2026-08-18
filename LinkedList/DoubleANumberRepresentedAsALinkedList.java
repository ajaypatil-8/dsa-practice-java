// Problem: Double a Number Represented as a Linked List
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/

public class DoubleANumberRepresentedAsALinkedList {

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

        ListNode pre = null;
        ListNode curr = head;
        ListNode fwd = null;

        while (curr != null) {
            fwd = curr.next;
            curr.next = pre;
            pre = curr;
            curr = fwd;
        }

        return pre;
    }

    public ListNode doubleIt(ListNode head) {

        ListNode temp = reverse(head);

        int carry = 0;
        ListNode t = temp;

        while (t != null) {

            int s = t.val * 2 + carry;

            t.val = (t.val * 2 + carry) % 10;

            if (s > 9) {
                carry = s / 10;
            } else {
                carry = 0;
            }

            t = t.next;
        }

        ListNode ans = reverse(temp);

        if (carry != 0) {
            ListNode k = new ListNode(carry);
            k.next = ans;
            return k;
        }

        return ans;
    }

    public static void main(String[] args) {

        DoubleANumberRepresentedAsALinkedList solution =
                new DoubleANumberRepresentedAsALinkedList();

        // Test 1: 123 -> 246
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3)));

        // Test 2: 999 -> 1998
        ListNode test2 = new ListNode(9,
                new ListNode(9,
                new ListNode(9)));

        // Test 3: 5 -> 10
        ListNode test3 = new ListNode(5);

        System.out.print("Test 1: ");
        printList(solution.doubleIt(test1));

        System.out.print("Test 2: ");
        printList(solution.doubleIt(test2));

        System.out.print("Test 3: ");
        printList(solution.doubleIt(test3));
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