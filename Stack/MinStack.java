// Problem: Min Stack
// Difficulty: Medium
// Topic: Stack
// LeetCode Link: https://leetcode.com/problems/min-stack/

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    Deque<Long> st;
    long min;

    public MinStack() {
        st = new ArrayDeque<>();
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        if (st.size() == 0) {
            min = (long) val;
        }

        if ((long) val >= min) {
            st.push((long) val);
        } else {
            st.push(val + (val - min));
            min = val;
        }
    }

    public void pop() {
        if (min > st.peek()) {
            min = min + (min - st.peek());
        }

        st.pop();
    }

    public int top() {
        long a = st.peek();

        if (min > st.peek()) {
            return (int) min;
        } else {
            return (int) a;
        }
    }

    public int getMin() {
        return (int) min;
    }

    public static void main(String[] args) {

        MinStack stack = new MinStack();

        stack.push(-2);
        stack.push(0);
        stack.push(-3);

        System.out.println("Test 1 - getMin: " + stack.getMin());

        stack.pop();

        System.out.println("Test 1 - top: " + stack.top());
        System.out.println("Test 1 - getMin: " + stack.getMin());

        MinStack stack2 = new MinStack();

        stack2.push(1);

        System.out.println("Test 2 - top: " + stack2.top());

        MinStack stack3 = new MinStack();

        stack3.push(5);
        stack3.push(5);

        stack3.pop();

        System.out.println("Test 3 - getMin: " + stack3.getMin());
    }
}