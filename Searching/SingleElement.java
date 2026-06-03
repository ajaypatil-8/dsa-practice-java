// Problem: Find the Element that Appears Once in Sorted Array
// Difficulty: Medium
// Topic: Searching
// Leetcode Link: https://leetcode.com/problems/single-element-in-a-sorted-array/submissions/2021213516/
// GFG Link: https://www.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array0624/1

public class SingleElement {

    static int single(int[] arr) {
        int low = 0, high = arr.length - 1, n = arr.length;

        // edge cases first
        if (arr.length == 1) return arr[0];
        if (arr[0] != arr[1]) return arr[0];
        if (arr[n - 1] != arr[n - 2]) return arr[n - 1];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // mid is not equal to either neighbor, its the single one
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }

            // find which side the pair is on
            int first = mid, second = mid;
            if (arr[mid] == arr[mid + 1]) {
                second = mid + 1;
            } else if (arr[mid] == arr[mid - 1]) {
                first = mid - 1;
            }

            // if left count is even, single is on right side
            int leftc = first - low;
            int rightc = high - second;
            if (leftc % 2 == 0) {
                low = second + 1;
            } else {
                high = first - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // single element is 2
        int[] arr1 = {1, 1, 2, 3, 3, 4, 4};
        System.out.println("Test 1: " + single(arr1));

        // single element is 4
        int[] arr2 = {1, 1, 2, 2, 3, 3, 4};
        System.out.println("Test 2: " + single(arr2));

        // only one element
        int[] arr3 = {7};
        System.out.println("Test 3: " + single(arr3));
    }
}