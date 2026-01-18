/*

Info about Bubble Sort:

1. Comparison-Based:

   * The algorithm sorts elements by comparing adjacent values.
   * Swaps are performed when elements are in the wrong order.

2. In-Place Sorting:

   * Sorting is done within the original array.
   * No additional memory is required.

3. Repeated Passes:

   * The algorithm makes multiple passes over the array.
   * After each pass, the largest element "bubbles up"
     to its correct position at the end.

4. Adjacent Swapping:

   * Only neighboring elements are compared and swapped.
   * This process continues until the array is sorted.

Why Bubble Sort works?

--> The algorithm guarantees that:
- After each full pass, the largest unsorted element
is placed in its final sorted position.
- The unsorted portion of the array shrinks over time.

--> With optimization:
- If a full pass completes with no swaps,
the array is already sorted and the algorithm stops early.

Time Complexity:

1. Best Case:    O(n)
   // When the array is already sorted (with early-exit optimization)
2. Average Case: O(n^2)
3. Worst Case:   O(n^2)
   // When the array is sorted in reverse order

Space Complexity:

1. O(1)

   * Uses constant extra space.
   * Sorting is done in-place.

Characteristics:

* Very simple and intuitive.
* Easy to implement and debug.
* Can detect already-sorted arrays early.

- Extremely slow for large datasets.
- Performs many unnecessary comparisons.
- Generally outperformed by other simple sorts.

Notes on this implementation:

--> Uses a boolean flag to detect if any swap occurred
during a full pass.
--> The early-exit check must be done AFTER the inner loop,
not inside it.

--> code by Silver.
*/

package SortingAlgorithms;

public class BubbleSort {

    public static void main(String args[]) {

        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.print("Original Array: ");
        display_array(arr);

        bubble_sort(arr);
        System.out.print("Sorted Array: ");
        display_array(arr);
    }

    static void bubble_sort(int arr[]) {

        int len = arr.length; // get the length of the array.
        boolean flag; // we will ue this for knowing if we swapped any elements

        int temp = 0; // for swapping (normal swapping this time).
        for (int i = 0; i < len; ++i) {
            flag = false; // each time this will start as false.

            for (int j = 0; j < len - i - 1; ++j) {

                // if the current element is bigger than the,
                // one next to it we will swap them.
                if (arr[j] > arr[j + 1]) {

                    // swapping...
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = true;
                }
            }

            // if the inner loop didn't swap any elements,
            // then bingo! the elements are sorted.
            if (flag == false) { // PUT IT IN THE OUTER LOOP DUMMY!
                break;
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
