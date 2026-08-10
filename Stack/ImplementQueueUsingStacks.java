// Problem: Implement Queue using Stacks
// Difficulty: Easy
// Topic: Queue
// LeetCode Link: https://leetcode.com/problems/implement-queue-using-stacks/

import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> st = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public ImplementQueueUsingStacks() {

    }

    public void push(int x) {
        st.push(x);
    }

    public int pop() {

        while (st.size() > 1) {
            helper.push(st.pop());
        }

        int ans = st.pop();

        while (!helper.isEmpty()) {
            st.push(helper.pop());
        }

        return ans;
    }

    public int peek() {

        while (st.size() > 1) {
            helper.push(st.pop());
        }

        int ans = st.peek();

        while (!helper.isEmpty()) {
            st.push(helper.pop());
        }

        return ans;
    }

    public boolean empty() {
        if (st.isEmpty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        ImplementQueueUsingStacks queue =
                new ImplementQueueUsingStacks();

        // Test 1
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println("Test 1 - peek: " + queue.peek());
        System.out.println("Test 1 - pop: " + queue.pop());

        // Test 2
        queue.push(4);

        System.out.println("Test 2 - peek: " + queue.peek());
        System.out.println("Test 2 - pop: " + queue.pop());

        // Test 3 - edge case
        ImplementQueueUsingStacks queue2 =
                new ImplementQueueUsingStacks();

        System.out.println("Test 3 - empty: " + queue2.empty());
    }
}