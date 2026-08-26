// Problem: Linked List Random Node
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/linked-list-random-node/

import java.util.concurrent.ThreadLocalRandom;

public class LinkedListRandomNode {

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

    ListNode head;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    public int getRandom() {

        ListNode temp = head;
        int size = 0;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int max = size;

        temp = head;

        int randomNum = ThreadLocalRandom.current().nextInt(0, max);

        for (int i = 0; i < randomNum; i++) {
            temp = temp.next;
        }

        return temp.val;
    }

    public static void main(String[] args) {

        // Test 1: 1 -> 2 -> 3
        ListNode test1 = new ListNode(1,
                new ListNode(2,
                new ListNode(3)));

        LinkedListRandomNode solution1 =
                new LinkedListRandomNode(test1);

        System.out.println("Test 1: " + solution1.getRandom());

        // Test 2: 10 -> 20 -> 30 -> 40 -> 50
        ListNode test2 = new ListNode(10,
                new ListNode(20,
                new ListNode(30,
                new ListNode(40,
                new ListNode(50)))));

        LinkedListRandomNode solution2 =
                new LinkedListRandomNode(test2);

        System.out.println("Test 2: " + solution2.getRandom());

        // Test 3: single node
        ListNode test3 = new ListNode(7);

        LinkedListRandomNode solution3 =
                new LinkedListRandomNode(test3);

        System.out.println("Test 3: " + solution3.getRandom());
    }
}