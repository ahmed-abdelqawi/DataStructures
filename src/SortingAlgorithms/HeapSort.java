/*

Info about Heap Sort:

1. Comparison-Based:

   * The algorithm sorts elements by comparing values.
   * Uses a binary heap data structure.

2. In-Place Sorting:

   * Sorting is done within the original array.
   * No additional memory is required.

3. Binary Heap Structure:

   * A binary heap is a complete binary tree.
   * In Heap Sort, a MAX heap is used:

     * The parent node is always greater than its children.

4. Two Main Phases:

   * Heap Construction:

     * The array is rearranged to satisfy the max-heap property.
   * Extraction Phase:

     * The maximum element (root) is swapped with the last element.
     * Heap size is reduced.
     * Heap property is restored using heapify.

Why Heap Sort works?

--> The algorithm guarantees that:
- The largest element is always at the root of the heap.
- After each extraction, the heap remains valid.
- Repeating this process produces a sorted array.

--> Because of heap properties:
- Finding and removing the maximum element is efficient.

Time Complexity:

1. Best Case:    O(n log n)
2. Average Case: O(n log n)
3. Worst Case:   O(n log n)
   // Heap structure guarantees log n operations

Space Complexity:

1. O(1)

   * Sorting is done in-place.
   * Only constant extra space is used.

Characteristics:

* Predictable performance.
* Works well for large datasets.
* No recursion required in the main algorithm.
* In-place sorting.

- Not stable (relative order of equal elements may change).
- Slower than Quick Sort in practice due to cache behavior.
- More complex than simple sorting algorithms.

--> code by Silver.
*/

package SortingAlgorithms;

public class HeapSort {

    public static void main(String args[]) {

        int arr[] = { 69, 435, 42, 10, 8008, 0, 7 };

        System.out.print("Original Array: ");
        display_elements(arr);
        System.out.println();

        heap_sort(arr);

        System.out.print("Sorted Array: ");
        display_elements(arr);
        System.out.println();
    }

    static void heap_sort(int arr[]) {
        int len = arr.length; // get the size (capacity) of the array.

        // building the heap (by rearranging the array elements).
        for (int i = (len / 2) - 1; i >= 0; --i) {
            heapify(arr, len, i);
        }

        // now we extract the elements one by one from the heap,
        // I like to call this milking the heap "if you know what I mean (0-0)"
        // and its in reverse (cool :D).
        for (int i = len - 1; i > 0; --i) {

            swap(arr, 0, i); // move the current root to the end.
            heapify(arr, i, 0); // heapify-ing (ig) the remaining elements.
        }
    }

    // building a MAX heap.
    static void heapify(int arr[], int len, int i) {

        int largest_element = i; // assume the largest element is the root.

        // get the left and right children of the root.
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        // here we make sure the binary tree has a max heap property,
        // by making sure the 2 children of a given node is always smaller than the
        // root.
        if (left < len && arr[left] > arr[largest_element]) {
            largest_element = left;
        }
        if (right < len && arr[right] > arr[largest_element]) {
            largest_element = right;
        }

        // now we do this sh*t recursively until we have a MAX heap.
        if (largest_element != i) {
            swap(arr, i, largest_element);
            heapify(arr, len, largest_element);
        }
    }

    // HELPER FUNCTION: for swapping 2 elements in the array.
    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void display_elements(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
