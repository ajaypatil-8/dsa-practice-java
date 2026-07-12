// Problem: Palindrome Linked List
// Difficulty: Easy
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/palindrome-linked-list/

public class PalindromeLinkedList {

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

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {

            // reverse current link
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // find middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // split list
        ListNode head2 = slow.next;
        slow.next = null;

        // reverse second half
        head2 = reverseList(head2);

        // compare both halves
        while (head2 != null) {
            if (head.val != head2.val) {
                return false;
            }

            head = head.next;
            head2 = head2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();

        // Test 1: 1 -> 2 -> 2 -> 1
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(2,
                new ListNode(1))));

        // Test 2: 1 -> 2
        ListNode test2 = new ListNode(1,
                new ListNode(2));

        // Test 3: 1 (edge case)
        ListNode test3 = new ListNode(1);

        System.out.println("Test 1: " + solution.isPalindrome(test1));
        System.out.println("Test 2: " + solution.isPalindrome(test2));
        System.out.println("Test 3: " + solution.isPalindrome(test3));
    }
}