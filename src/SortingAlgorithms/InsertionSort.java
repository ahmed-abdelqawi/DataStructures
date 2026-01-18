/*

Info about Insertion Sort:

1. Comparison-Based:

   * The algorithm sorts elements by comparing values.
   * Elements are inserted into their correct position.

2. In-Place Sorting:

   * Sorting is done within the original array.
   * No additional memory is required.

3. Dividing the Array:

   * The array is conceptually divided into two parts:

     1. Sorted part (left side)
     2. Unsorted part (right side)

4. Insertion Mechanism:

   * On each iteration:

     * A key element is selected from the unsorted part.
     * Larger elements in the sorted part are shifted
       one position to the right.
     * The key is inserted into the correct position.

Why Insertion Sort works?

--> The algorithm guarantees that:
- The left portion of the array is always sorted.
- Each new element is placed into its final position
within the sorted portion.

--> Because of shifting (not swapping):
- Fewer operations are performed on nearly sorted arrays.

Time Complexity:

1. Best Case:    O(n)
   // When the array is already sorted
2. Average Case: O(n^2)
3. Worst Case:   O(n^2)
   // When the array is sorted in reverse order

Space Complexity:

1. O(1)

   * Uses constant extra space.
   * Sorting is done in-place.

Characteristics:

* Very efficient for small datasets.
* Fast on nearly sorted arrays.
* Stable (preserves the order of equal elements).
* Simple and intuitive.

- Slow for large datasets.
- Inefficient compared to advanced algorithms
  like Merge Sort or Quick Sort.

Notes on this implementation:

--> The algorithm uses shifting instead of swapping.
--> The first element is considered already sorted.

--> code by Silver.
*/

package SortingAlgorithms;

public class InsertionSort {

    public static void main(String args[]) {

        int arr[] = { 12, 11, 13, 5, 6 };

        System.out.print("Original Array: ");
        display_elements(arr);

        System.out.print("Sorted Array: ");
        insertion_sort(arr);
        display_elements(arr);

    }

    static void insertion_sort(int arr[]) {

        int len = arr.length; // get the length of the array (size).

        // so we start @ the 2nd index, cuz we assume,
        // the first element is sorted!
        for (int i = 1; i < len; ++i) {

            int current_key = arr[i]; // we store the current element
            // (the first element of the assumed to be the unsorted half of the array)

            int j = i - 1; // start comparing with elements to the left.
            while (j >= 0 && arr[j] > current_key) {
                arr[j + 1] = arr[j]; // crating a space for the key by shifting the bigger element right.
                j = j - 1; // just moving left so we can keep doing this.
            }
            arr[j + 1] = current_key; // insert the current_key to its correct position.
        }
    }

    static void display_elements(int arr[]) {
        int len = arr.length;
        for (int i = 0; i < len; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
