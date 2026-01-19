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
