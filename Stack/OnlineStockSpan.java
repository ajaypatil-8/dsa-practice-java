// Problem: Online Stock Span
// Difficulty: Medium
// Topic: Stack
// LeetCode Link: https://leetcode.com/problems/online-stock-span/

import java.util.ArrayDeque;
import java.util.Deque;

class Pair {
    int val;
    int idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

public class OnlineStockSpan {

    Deque<Pair> st;
    int idx = 1;

    public OnlineStockSpan() {
        st = new ArrayDeque<>();
    }

    public int next(int price) {

        if (!st.isEmpty() && price < st.peek().val) {
            Pair pr = new Pair(price, idx);
            st.push(pr);
            idx++;
            return 1;
        } else if (!st.isEmpty() && price >= st.peek().val) {

            while (!st.isEmpty() && st.peek().val <= price) {
                st.pop();
            }
        }

        int ridx = idx;

        if (st.isEmpty()) {
            Pair pr = new Pair(price, idx);
            st.push(pr);
            idx++;
            return ridx;
        }

        int ans = idx - st.peek().idx;

        Pair pr = new Pair(price, idx);
        st.push(pr);
        idx++;

        return ans;
    }

    public static void main(String[] args) {

        OnlineStockSpan spanner = new OnlineStockSpan();

        // Test 1: standard example
        System.out.println("Test 1: " + spanner.next(100));
        System.out.println("Test 1: " + spanner.next(80));
        System.out.println("Test 1: " + spanner.next(60));
        System.out.println("Test 1: " + spanner.next(70));
        System.out.println("Test 1: " + spanner.next(60));
        System.out.println("Test 1: " + spanner.next(75));
        System.out.println("Test 1: " + spanner.next(85));

        // Test 2
        OnlineStockSpan spanner2 = new OnlineStockSpan();
        System.out.println("Test 2: " + spanner2.next(10));
        System.out.println("Test 2: " + spanner2.next(20));

        // Test 3: single value
        OnlineStockSpan spanner3 = new OnlineStockSpan();
        System.out.println("Test 3: " + spanner3.next(50));
    }
}