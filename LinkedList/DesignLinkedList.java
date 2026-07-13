// Problem: Design Linked List
// Difficulty: Medium
// Topic: Linked List
// LeetCode Link: https://leetcode.com/problems/design-linked-list/

public class DesignLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class MyLinkedList {

        ListNode head;
        ListNode tail;
        int size;

        public MyLinkedList() {

        }

        public int get(int idx) {

            if (idx < 0 || idx >= size) {
                return -1;
            }

            ListNode temp = head;

            // reach required index
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }

            return temp.val;
        }

        public void addAtHead(int val) {

            ListNode temp = new ListNode(val);

            if (head == null) {
                head = tail = temp;
            } else {
                temp.next = head;
                head = temp;
            }

            size++;
        }

        public void addAtTail(int val) {

            ListNode temp = new ListNode(val);

            if (head == null) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public void addAtIndex(int idx, int val) {

            if (idx < 0 || idx > size) {
                return;
            }

            if (idx == 0) {
                addAtHead(val);
                return;
            }

            if (idx == size) {
                addAtTail(val);
                return;
            }

            ListNode node = new ListNode(val);
            ListNode temp = head;

            // reach previous node
            for (int i = 1; i < idx; i++) {
                temp = temp.next;
            }

            node.next = temp.next;
            temp.next = node;

            size++;
        }

        public void deleteAtIndex(int idx) {

            if (idx < 0 || idx >= size) {
                return;
            }

            if (idx == 0) {

                head = head.next;

                if (head == null) {
                    tail = null;
                }

                size--;
                return;
            }

            ListNode temp = head;

            // reach previous node
            for (int i = 1; i < idx; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;

            if (idx == size - 1) {
                tail = temp;
            }

            size--;
        }
    }

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        // Test 1
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);

        System.out.println("Test 1 (get 1): " + list.get(1));

        list.deleteAtIndex(1);

        System.out.println("Test 1 (get 1 after delete): " + list.get(1));

        // Test 2
        MyLinkedList list2 = new MyLinkedList();

        list2.addAtHead(10);
        list2.addAtHead(20);
        list2.addAtTail(30);

        System.out.println("Test 2 (get 0): " + list2.get(0));
        System.out.println("Test 2 (get 2): " + list2.get(2));

        // Test 3 (edge case)
        MyLinkedList list3 = new MyLinkedList();

        System.out.println("Test 3 (empty list): " + list3.get(0));
    }
}