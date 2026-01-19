/*

Info about Quick Sort:

1. Divide and Conquer:

   * The algorithm follows the divide-and-conquer paradigm.
   * The array is partitioned around a pivot element.

2. Comparison-Based:

   * Elements are sorted by comparing values to the pivot.
   * No assumptions are made about the input distribution.

3. Recursive Structure:

   * After partitioning:

     * Elements smaller than or equal to the pivot go to the left.
     * Elements greater than the pivot go to the right.
   * Each partition is recursively sorted.

4. Partitioning Process:

   * A pivot element is chosen (commonly the last element).
   * The array is rearranged so that:

     * All elements ≤ pivot come before it.
     * All elements > pivot come after it.
   * The pivot ends up in its final sorted position.

Why Quick Sort works?

--> The algorithm guarantees that:
- After partitioning, the pivot is in the correct position.
- Recursive sorting of both partitions produces
a fully sorted array.

--> Because of partitioning:
- Large problems are broken into smaller,
more manageable sub-problems.

Time Complexity:

1. Best Case:    O(n log n)
   // Balanced partitions
2. Average Case: O(n log n)
3. Worst Case:   O(n^2)
   // Highly unbalanced partitions (e.g., already sorted array)

Space Complexity:

1. O(log n)

   * Due to recursive call stack (average case).
   * In-place partitioning (no extra arrays).

Characteristics:

* Very fast in practice.
* Cache-friendly.
* In-place sorting (no extra memory for data).
* Widely used in real systems.

- Worst-case performance is poor.
- Not stable (relative order of equal elements may change).
- Performance depends heavily on pivot choice.

Notes on this implementation:

--> Uses Lomuto partition scheme.
--> Pivot is chosen as the last element of the sub-array.
--> The partition function must respect start/end boundaries.
--> Initial call should be:
quick_sort(arr, 0, arr.length - 1);

--> code by Silver.
*/

package SortingAlgorithms;

public class QuickSort {

    public static void main(String args[]) {

        int arr[] = { 8, 2, 4, 7, 1, 3, 9, 6, 5 };

        System.out.print("Original Array: ");
        display_elements(arr);
        System.out.println();

        int end = arr.length - 1;
        quick_sort(arr, 0, end);

        System.out.print("Sorted Array: ");
        display_elements(arr);
        System.out.println();
    }

    static void quick_sort(int arr[], int start, int end) {

        if (end <= start)
            return; // recursion base case.

        int pivot = partitioning(arr, start, end);

        // NOTE: when we call the function back we DO NOT include the pivot,
        // as its already in the correct place. :)
        quick_sort(arr, start, pivot - 1); // recursively sort the left partition.
        quick_sort(arr, pivot + 1, end); // recursively sort the right partition.
    }

    // partitioning the array using Lomuto Partition, because its all my small brain
    // can handel :D.
    static int partitioning(int arr[], int start, int end) {

        int pivot = arr[end]; // choose the last element as pivot
        int i = start - 1;
        int temp = 0;

        for (int j = start; j < end; j++) {

            // if the element @ index j <= the pivot,
            // we increment i and perform a swap between the elements @ i && j,
            // OTHERWISE: we just IGNORE it (just like my crush).
            if (arr[j] <= pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // perform a swap to put the pivot element in place.
        temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        // return pivot index. pivot lives @ arr[i + 1].
        return i + 1;
    }

    static void display_elements(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
