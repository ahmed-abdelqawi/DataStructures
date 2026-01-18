/*

Info about Selection Sort:

1. Comparison-Based:

   * The algorithm sorts elements by comparing values.
   * No assumptions are made about the data distribution.

2. In-Place Sorting:

   * Sorting is done within the original array.
   * No extra memory is allocated.

3. Dividing the Array:

   * The array is conceptually divided into two parts:

     1. Sorted part (left side)
     2. Unsorted part (right side)

4. Minimum Selection:

   * On each iteration, the algorithm:

     * Assumes the first element of the unsorted part is the minimum.
     * Scans the remaining elements to find the true minimum.
     * Places the minimum element at its correct position.

Why Selection Sort works?

--> The algorithm guarantees that:
- After each pass, the smallest remaining element
is placed in its final sorted position.
- The sorted portion grows one element at a time.

--> No matter the input order:
- The same number of comparisons is performed.

Time Complexity:

1. Best Case:    O(n^2)
2. Average Case: O(n^2)
3. Worst Case:   O(n^2)
   // Because it always scans the unsorted part fully

Space Complexity:

1. O(1)

   * Uses constant extra space.
   * Sorting is done in-place.

Characteristics:

* Simple and easy to understand.
* Performs well for very small datasets.
* Predictable performance.

- Very slow for large datasets.
- More comparisons than necessary.
- Not stable (relative order of equal elements may change).

Notes on this implementation:

--> An XOR swap is used instead of a temporary variable.
--> XOR swap must NOT be used when both indices are the same,
otherwise the value will be corrupted.

--> code by Silver.
*/

package SortingAlgorithms;

public class SelectionSort {

    public static void main(String args[]) {

        int[] arr = { 64, 25, 12, 22, 11 };

        System.out.print("Original Array: ");
        display_array(arr);

        selection_sort(arr);
        System.out.print("Sorted Array: ");
        display_array(arr);
    }

    static void selection_sort(int arr[]) {

        int len = arr.length; // the length (size) of the array.

        for (int i = 0; i < len; ++i) {

            int min_index = i; // assuming the minimum index is the current one.
            for (int j = i + 1; j < len; ++j) {

                // walkthrough the entire array till we find the minimum,
                // element's index if found!
                if (arr[j] < arr[min_index]) {
                    min_index = j; // bingo!
                }
            }

            // move the minimum element to it's position.
            // this is an XOR swap google it :) "hint: a^b^b = a"
            if (min_index != i) {
                arr[i] = arr[i] ^ arr[min_index];
                arr[min_index] = arr[i] ^ arr[min_index];
                arr[i] = arr[i] ^ arr[min_index];
            }
        }
    }

    static void display_array(int arr[]) {
        int len = arr.length;

        for (int i = 0; i < len; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
