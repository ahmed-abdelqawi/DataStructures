/*

Info about Arrays:

1. Fixed Size:
   - The size of the array is defined at creation time.
   - It cannot grow or shrink dynamically.

2. Homogeneous:
   - All elements stored in an array are of the same data type.

3. Indexed Access:
   - Each element is accessed using its index (position).
   - Indexing starts from 0.

4. Contiguous Memory:
   - Elements are stored in consecutive memory locations.

Why Arrays are fast?

--> The computer knows:
    - The address of the first element.
    - The size of each element.
--> Using pointer arithmetic, it can calculate the address
    of any element instantly.

Time Complexity:

1. Accessing an index (read/write): O(1).
2. Traversal: O(n).
3. Search (unsorted): O(n).
4. Search (sorted): O(log n).   // Binary Search
5. Insertion @ end: O(1).       // If space is available
6. Insertion @ end (resize): O(n).
7. Insertion @ index: O(n).     // Elements must be shifted
8. Deletion @ end: O(1).
9. Deletion @ index: O(n).      // Elements must be shifted

Trade-offs vs Linked Lists:

+ Very fast access.
+ Memory-efficient (no extra pointers).
+ Cache-friendly.
- Fixed size.
- Slow insertions and deletions (except at the end).

--> code by Silver.
*/

package Arrays;

public class Arr {
    private int array_size;
    private int element_count;

    private int memory_pool[];

    Arr(int passed_size) {

        if (passed_size <= 0) {
            System.out.println("ERROR: Invalid Size.");
            return;
        }

        array_size = passed_size;
        element_count = 0;

        memory_pool = new int[array_size];
    }

    // helper function: checking if the memory_pool is full.
    private boolean isFull() {
        return element_count == array_size;
    }

    // inserting a new element at the end.
    public void normal_insert(int new_item) {

        // 1. check if the memory_pool is full.
        if (isFull()) {
            System.out.println("ERROR: Array is FULL!");
            return;
        }

        // 2. add the new element to the memory_pool.
        int index = element_count;
        memory_pool[index] = new_item;
        element_count++;
        System.out.println(new_item + " added to the index: " + index);
    }

    // inserting at an index.
    public void index_insert(int item, int index) {

        // 1. checking if the memory_pool is full or the index is invalid.
        if (isFull()) {
            System.out.println("ERROR: Array is FULL!");
            return;
        } else if (index < 0 || index > element_count) {
            System.out.println("ERROR: Invalid Index!");
            return;
        }

        // 2. shift the elements on step forward (right).
        for (int i = element_count; i > index; --i) {
            memory_pool[i] = memory_pool[i - 1];
        }

        // 3. add the element in it's index.
        memory_pool[index] = item;
        element_count++;
        System.out.println(item + " added at index: " + index);
    }

    // deleting an element @ an index.
    public void delete(int index) {

        // 1. check if the memory_pool is empty or the index is invalid.
        if (element_count == 0) {
            System.out.println("ERROR: Array is Empty!");
            return;
        } else if (index < 0 || index >= element_count) {
            System.out.println("ERROR: Invalid Index!");
            return;
        }

        // 2. shift the element backwards (left shift).
        for (int i = index; i < element_count - 1; i++) {
            memory_pool[i] = memory_pool[i + 1];
        }

        element_count--;
        System.out.println("Element @ index: " + index + " has been Terminated!");
    }

    // display the elements @ the memory_pool.
    public void display_pool() {
        System.out.print("Array: ");
        for (int i = 0; i < element_count; ++i) {
            System.out.print(memory_pool[i] + " ");
        }
        System.out.println();
    }
}
