package org.example.heapsort;

public class HeapSort {
    public static void sort(int[] arr) {
        int n = arr.length;

        // Build a max-heap from the input array
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Repeatedly extract the maximum element from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move the root node (maximum element) to the end of the array
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Fix the heap property of the remaining heap
            heapify(arr, i, 0);
        }
    }

    // Heapify a subtree rooted at index i
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            // Swap arr[i] with arr[largest]
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }
    /* A utility function to print array of size n */
    public static void printArray(int arr[])
    {
        int N = arr.length;

        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
