// Problem: Implement Stack using Queues
// Difficulty: Easy
// Topic: Queue
// LeetCode Link: https://leetcode.com/problems/implement-stack-using-queues/

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    Queue<Integer> q = new LinkedList<>();

    public ImplementStackUsingQueues() {

    }

    public void push(int x) {
        q.add(x);
    }

    public int pop() {

        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }

        return q.remove();
    }

    public int top() {

        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }

        int x = q.peek();
        q.add(q.remove());

        return x;
    }

    public boolean empty() {
        if (q.size() == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        ImplementStackUsingQueues stack =
                new ImplementStackUsingQueues();

        // Test 1
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Test 1 - top: " + stack.top());
        System.out.println("Test 1 - pop: " + stack.pop());

        // Test 2
        stack.push(4);

        System.out.println("Test 2 - top: " + stack.top());
        System.out.println("Test 2 - pop: " + stack.pop());

        // Test 3 - edge case
        ImplementStackUsingQueues stack2 =
                new ImplementStackUsingQueues();

        System.out.println("Test 3 - empty: " + stack2.empty());
    }
}