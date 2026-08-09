// Problem: Maximal Rectangle
// Difficulty: Hard
// Topic: Stack

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {

    public int largestRectangleArea(int[] arr) {

        int[] pse = new int[arr.length];
        int[] nse = new int[arr.length];

        nse[arr.length - 1] = arr.length;

        Deque<Integer> st = new ArrayDeque<>();

        // previous smaller element
        for (int i = 0; i < arr.length; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                pse[i] = st.peek();
            } else {
                pse[i] = -1;
            }

            st.push(i);
        }

        while (!st.isEmpty()) {
            st.pop();
        }

        // next smaller element
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                nse[i] = st.peek();
            } else {
                nse[i] = arr.length;
            }

            st.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < arr.length; i++) {
            int area = arr[i] * (nse[i] - pse[i] - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] arr) {

        int m = arr.length;
        int n = arr[0].length;

        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = arr[i][j] - '0';
            }
        }

        // build histogram heights
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        int max = 0;

        for (int[] row : matrix) {
            int area = largestRectangleArea(row);
            max = Math.max(area, max);
        }

        return max;
    }

    public static void main(String[] args) {

        MaximalRectangle solution = new MaximalRectangle();

        char[][] test1 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        char[][] test2 = {
                {'0'}
        };

        char[][] test3 = {
                {'1'}
        };

        System.out.println("Test 1: " + solution.maximalRectangle(test1));
        System.out.println("Test 2: " + solution.maximalRectangle(test2));
        System.out.println("Test 3: " + solution.maximalRectangle(test3));
    }
}