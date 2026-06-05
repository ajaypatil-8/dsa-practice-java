// Problem: Kth Smallest Element
// Difficulty: Medium
// Topic: Sorting
// GFG Link: https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1

public class KthSmallest {

    static int kthSmallest(int[] arr, int k) {
        // sort the array then return kth index
        mergeSort(arr, 0, arr.length - 1);
        return arr[k - 1];
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // temp left and right halves
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // merge both halves back
        int i = 0, j = 0, idx = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[idx++] = L[i++];
            } else {
                arr[idx++] = R[j++];
            }
        }

        // copy remaining elements
        while (i < n1) {
            arr[idx++] = L[i++];
        }
        while (j < n2) {
            arr[idx++] = R[j++];
        }
    }

    public static void main(String[] args) {
        // 3rd smallest is 7
        int[] arr1 = {7, 10, 4, 3, 20, 15};
        System.out.println("Test 1: " + kthSmallest(arr1, 3));

        // 2nd smallest is 2
        int[] arr2 = {4, 7, 2, 9, 1};
        System.out.println("Test 2: " + kthSmallest(arr2, 2));

        // single element, k=1
        int[] arr3 = {5};
        System.out.println("Test 3: " + kthSmallest(arr3, 1));
    }
}