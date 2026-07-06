// Problem: Intersection of Two Linked Lists
// Difficulty: Easy
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/intersection-of-two-linked-lists/

public class IntersectionOfTwoLinkedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        // switch heads after reaching the end
        while (a != b) {

            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();

        // Common part: 8 -> 4 -> 5
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // Test 1
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        // Test 2
        ListNode common2 = new ListNode(2);
        common2.next = new ListNode(4);

        ListNode headC = new ListNode(1);
        headC.next = new ListNode(9);
        headC.next.next = new ListNode(1);
        headC.next.next.next = common2;

        ListNode headD = new ListNode(3);
        headD.next = common2;

        // Test 3: no intersection
        ListNode headE = new ListNode(2);
        headE.next = new ListNode(6);
        headE.next.next = new ListNode(4);

        ListNode headF = new ListNode(1);
        headF.next = new ListNode(5);

        ListNode result1 = solution.getIntersectionNode(headA, headB);
        ListNode result2 = solution.getIntersectionNode(headC, headD);
        ListNode result3 = solution.getIntersectionNode(headE, headF);

        System.out.println("Test 1: " + (result1 != null ? result1.val : "null"));
        System.out.println("Test 2: " + (result2 != null ? result2.val : "null"));
        System.out.println("Test 3: " + (result3 != null ? result3.val : "null"));
    }
}