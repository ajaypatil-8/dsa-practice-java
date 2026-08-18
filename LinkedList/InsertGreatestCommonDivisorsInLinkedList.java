// Problem: Insert Greatest Common Divisors in Linked List
// Difficulty: Medium
// Topic: Linked List

public class InsertGreatestCommonDivisorsInLinkedList {

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

    public int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode temp = head;

        while (temp.next != null) {

            int gcd = gcd(temp.val, temp.next.val);

            ListNode a = new ListNode(gcd);

            a.next = temp.next;
            temp.next = a;

            temp = temp.next.next;
        }

        return head;
    }

    public static void main(String[] args) {

        InsertGreatestCommonDivisorsInLinkedList solution =
                new InsertGreatestCommonDivisorsInLinkedList();

        // Test 1: 18 -> 6 -> 10 -> 3
        ListNode test1 = new ListNode(18,
                new ListNode(6,
                new ListNode(10,
                new ListNode(3))));

        // Test 2: 7 -> 4 -> 8 -> 3 -> 5
        ListNode test2 = new ListNode(7,
                new ListNode(4,
                new ListNode(8,
                new ListNode(3,
                new ListNode(5)))));

        // Test 3: single node
        ListNode test3 = new ListNode(10);

        System.out.print("Test 1: ");
        printList(solution.insertGreatestCommonDivisors(test1));

        System.out.print("Test 2: ");
        printList(solution.insertGreatestCommonDivisors(test2));

        System.out.print("Test 3: ");
        printList(solution.insertGreatestCommonDivisors(test3));
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