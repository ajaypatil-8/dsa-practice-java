// Problem: Find Median from Data Stream
// Difficulty: Hard
// Topic: Heap
// LeetCode Link: https://leetcode.com/problems/find-median-from-data-stream/

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    PriorityQueue<Integer> minpq = new PriorityQueue<>();
    PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

    int mins = 0;
    int maxs = 0;

    public FindMedianFromDataStream() {

    }

    public void addNum(int num) {

        if (mins == 0 && maxs == 0) {
            maxpq.add(num);
            maxs++;
        } else if (mins == maxs) {

            if (num > maxpq.peek()) {
                minpq.add(num);
                mins++;
            } else {
                maxpq.add(num);
                maxs++;
            }

        } else {

            if (num > maxpq.peek()) {
                minpq.add(num);
                mins++;
            } else {
                maxpq.add(num);
                maxs++;
            }
        }

        if (mins - maxs > 1) {
            maxpq.add(minpq.remove());
            mins--;
            maxs++;
        }

        if (maxs - mins > 1) {
            minpq.add(maxpq.remove());
            mins++;
            maxs--;
        }
    }

    public double findMedian() {

        if (maxs > mins) {
            return maxpq.peek() / 1.0;
        } else if (mins == maxs) {
            return (minpq.peek() + maxpq.peek()) / 2.0;
        }

        return minpq.peek();
    }

    public static void main(String[] args) {

        FindMedianFromDataStream solution =
                new FindMedianFromDataStream();

        // Test 1
        solution.addNum(1);
        solution.addNum(2);

        System.out.println("Test 1: " + solution.findMedian());

        solution.addNum(3);

        System.out.println("Test 1 after 3: " + solution.findMedian());

        // Test 2
        FindMedianFromDataStream solution2 =
                new FindMedianFromDataStream();

        solution2.addNum(5);
        solution2.addNum(3);
        solution2.addNum(8);
        solution2.addNum(9);

        System.out.println("Test 2: " + solution2.findMedian());

        // Test 3: single element
        FindMedianFromDataStream solution3 =
                new FindMedianFromDataStream();

        solution3.addNum(10);

        System.out.println("Test 3: " + solution3.findMedian());
    }
}