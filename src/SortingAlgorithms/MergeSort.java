/*

Info about Merge Sort:

1. Divide and Conquer:

   * The algorithm follows the divide-and-conquer paradigm.
   * The array is recursively divided into smaller sub-arrays
     until each sub-array contains a single element.

2. Comparison-Based:

   * Elements are sorted by comparing values during merging.
   * No assumptions are made about the input distribution.

3. Recursive Structure:

   * The algorithm uses recursion to split the array.
   * A helper function is used to merge sorted sub-arrays.

4. Merging Process:

   * Two sorted sub-arrays are merged into one sorted array
     by repeatedly selecting the smaller element.

Why Merge Sort works?

--> The algorithm guarantees that:
- Single-element arrays are inherently sorted.
- Merging two sorted arrays always produces a sorted result.
- Each merge step preserves ordering correctness.

--> Because of systematic splitting:
- The problem size is reduced at every recursive level.

Time Complexity:

1. Best Case:    O(n log n)
2. Average Case: O(n log n)
3. Worst Case:   O(n log n)
   // The array is always split into halves

Space Complexity:

1. O(n)

   * Requires extra memory for temporary sub-arrays.
   * Not an in-place sorting algorithm.

Characteristics:

* Very fast for large datasets.
* Predictable performance regardless of input order.
* Stable (preserves the order of equal elements).
* Well-suited for linked lists and external sorting.

- Uses additional memory.
- Recursive overhead.
- Slower than simple sorts for very small arrays.

--> code by Silver.
*/

package SortingAlgorithms;

public class MergeSort {
    public static void main(String args[]) {

        int arr[] = { 69, 504, 42, 1, 123, 55, 0, -1 };

        System.out.print("Original Array: ");
        display_array(arr);

        int len = arr.length;
        merge_sort(arr, 0, len - 1);

        System.out.print("Sorted Array: ");
        display_array(arr);
    }

    static void merge_sort(int arr[], int left_pointer, int right_pointer) {

        if (left_pointer < right_pointer) {

            int middle = left_pointer + (right_pointer - left_pointer) / 2;

            // divide and conquer.
            merge_sort(arr, left_pointer, middle); // sorting the left half of the array.
            merge_sort(arr, middle + 1, right_pointer); // sorting the right half of the array.

            // merge the sorted halves together.
            merge(arr, left_pointer, middle, right_pointer);
        }
    }

    // HELPER FUNCTION: for merging the splits together.
    static void merge(int arr[], int left_pointer, int middle, int right_pointer) {

        int size1 = middle - left_pointer + 1; // the size of the first half.
        int size2 = right_pointer - middle; // the size of the 2nd half.

        // temp arrays.
        int left_sub_array[] = new int[size1];
        int right_sub_array[] = new int[size2];

        // copy the data over to our temp arrays.
        for (int i = 0; i < size1; ++i) {
            left_sub_array[i] = arr[left_pointer + i];
        }
        for (int j = 0; j < size2; ++j) {
            right_sub_array[j] = arr[middle + 1 + j];
        }

        // the merging algorithm.

        int i = 0, j = 0; // the indices for the arrays.

        int k = left_pointer; // initial index of the merged sub-array.
        while (i < size1 && j < size2) {

            // if the element @ the left array is smaller than the element in the right
            // array,
            // then we will sore the left element first.
            if (left_sub_array[i] <= right_sub_array[j]) {
                arr[k] = left_sub_array[i];
                i++;
            } else { // its the literal opposite
                arr[k] = right_sub_array[j];
                j++;
            }
            k++; // increment the index of the sorted array.
        }

        // copy the remaining elements of the left_sub_array if any.
        while (i < size1) {
            arr[k] = left_sub_array[i];
            i++;
            k++;
        }

        // copy the remaining elements of the right_sub_array if any.
        while (j < size2) {
            arr[k] = right_sub_array[j];
            j++;
            k++;
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
