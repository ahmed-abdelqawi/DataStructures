/*
Info about Circular Queues:

1. FIFO Principle:

   * Circular Queue follows First In, First Out.
   * The first element added is the first one removed.

2. Circular Behavior:

   * The queue connects the end back to the beginning.
   * Indices wrap around using modulo arithmetic.
   * This allows reuse of freed space.

3. Fixed Size (Array-Based Implementation):

   * Queue has a predefined capacity.
   * Size does not grow dynamically.
   * Overflow occurs when the queue is full.

4. Structure:

   * Implemented using:
     a) an array to store elements
     b) an integer (front) pointing to the first element
     c) an integer (size) tracking number of elements

Why Circular Queues exist?

--> Standard array-based queues waste space after dequeue.
--> Circular queues reuse memory efficiently.
--> They eliminate element shifting.
--> Both insertion and deletion become O(1).

Basic Operations:

1. enqueue(x):

   * Inserts an element at the rear.
   * Rear index is calculated using:
     (front + size) % capacity
   * Causes overflow if the queue is full.

2. dequeue():

   * Removes and returns the front element.
   * Front moves forward circularly using modulo.
   * Causes underflow if the queue is empty.

3. peek_front():

   * Returns the front element without removing it.

4. peek_rear():

   * Returns the last element without removing it.

Time Complexity:

1. enqueue(): O(1).
2. dequeue(): O(1).
3. peek_front(): O(1).
4. peek_rear(): O(1).

Space Complexity:

* O(n) where n is the queue capacity.

Trade-offs vs Simple Array Queue:

* No wasted space.
* No element shifting.
* Optimal performance.

- Slightly more complex logic.
- Requires careful index calculations.

--> code by Silver.
*/

package CircularQueue;

public class CircularQueue {

    private int capacity;
    private int arr[];

    private int size;
    private int front;

    CircularQueue(int passed_size) {

        // I'm Dracula, blah...blah...blah.
        if (passed_size <= 0) {
            throw new IllegalArgumentException("Queue size must be greater than 0");
        }

        capacity = passed_size;
        arr = new int[capacity];

        front = 0;
        size = 0;
    }

    // adding an element to the queue (enqueueing (it's a word!)).
    public void enqueue(int item) {

        // checking for a full queue.
        if (size == capacity) {
            System.out.println("ERROR: Queue is FULL!");
            return;
        }

        // calculate rear = (front + size) % capacity "this ensures circular behavior".
        int rear = (front + size) % capacity;

        arr[rear] = item;
        size++;
    }

    // deleting the first element in the queue (dequeueing).
    public int dequeue() {

        // checking for an empty queue.
        if (size == 0) {
            System.out.println("ERROR: Queue is EMPTY!");
            return -1;
        }

        int dequeued_element = arr[front];

        front = (front + 1) % capacity; // move front forward: front = (front + 1) % capacity circular movement.
        size--;

        return dequeued_element;
    }

    // getting the last element in the queue.
    public int get_rear() {

        // checking for an empty queue.
        if (size == 0) {
            System.out.println("ERROR: Queue is Empty!");
            return -1;
        }

        // compute rear index: rear = (front + size - 1) % capacity.
        int rear = (front + size - 1) % capacity;

        return arr[rear];
    }

    // peek (0-0).
    public int get_front() {

        // checking for an empty queue.
        if (size == 0) {
            System.out.println("ERROR: Queue is EMPTY!");
            return -1;
        }

        return arr[front];
    }
}
