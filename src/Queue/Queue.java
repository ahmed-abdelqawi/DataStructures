/*
Info about Queues:

1. FIFO Principle:

   * Queue follows First In, First Out.
   * The first element added is the first one removed.

2. Restricted Access:

   * Elements are added at the REAR.
   * Elements are removed from the FRONT.
   * No direct access to middle elements.

3. Fixed Size (Array-Based Implementation):

   * Queue has a predefined capacity.
   * Size does not grow dynamically.
   * Overflow occurs when capacity is exceeded.

4. Structure:

   * Implemented using:
     a) an array to store elements
     b) an integer (size) to track the number of elements

Why Queues exist?

--> They model real-world waiting lines.
--> They ensure fair ordering of tasks.
--> They are widely used in scheduling systems.
--> They are essential in buffering and resource management.

Basic Operations:

1. enqueue(x):

   * Inserts an element at the rear of the queue.
   * Causes overflow if the queue is full.

2. dequeue():

   * Removes and returns the front element.
   * Requires shifting elements in array-based queues.

3. peek_front():

   * Returns the front element without removing it.

4. peek_rear():

   * Returns the last element without removing it.

Time Complexity:

1. enqueue(): O(1).
2. dequeue(): O(n) due to shifting elements.
3. peek_front(): O(1).
4. peek_rear(): O(1).

Space Complexity:

* O(n) where n is the queue capacity.

Trade-offs vs Other Implementations:

* Simple and easy to understand.
* Efficient insertion.

- Inefficient deletion due to shifting.
- Wasted space after dequeue operations.

Why Circular Queues exist?

--> To eliminate unnecessary shifting.
--> To reuse freed space efficiently.
--> To make both enqueue and dequeue O(1).

--> code by Silver.
*/

package Queue;

public class Queue {
    private int arr[];
    private int capacity;
    private int size;

    Queue(int passed_size) {

        // I hate humans, in general :)
        if (passed_size <= 0) {
            throw new IllegalArgumentException("Queue size must be greater than 0");
        }

        capacity = passed_size;
        arr = new int[capacity];
        size = 0; // current number of elements in our queue.
    }

    // adding an element (enqueue-ing (i guess :D)).
    public void enqueue(int item) {

        // checking for a full queue.
        if (size == capacity) {
            System.out.println("ERROR: Queue is FULL!");
            return;
        }

        arr[size] = item; // add the item to its position.
        size++; // increment the size by 1.
        System.out.println(item + " Enqueued!");
    }

    // deleting an element (dequeue-ing (idk what I'm typing, lol)).
    public int dequeue() {

        // checking for an empty queue.
        if (size == 0) {
            System.out.println("ERROR: Queue is EMPTY!");
            return -1;
        }

        // store dequeued element.
        int dequeued_item = arr[0]; // first element in Queue.

        // shifting elements backward (left).
        for (int i = 1; i < size; ++i) {
            arr[i - 1] = arr[i];
        }
        size--;

        return dequeued_item;
    }

    // peek (0-0).
    public int get_front() {

        // checking for an empty queue.
        if (size == 0) {
            System.out.println("ERROR: Queue is EMPTY!");
            return -1;
        }

        return arr[0];
    }

    // getting the lase element.
    public int get_rear() {

        // checking for an empty queue.
        if (size == 0) {
            System.out.println("ERROR: Queue is EMPTY!");
            return -1;
        }

        return arr[size - 1];
    }
}
