/*
Info about Stacks:

1. LIFO Principle:

   * Stack follows Last In, First Out.
   * The last element added is the first one removed.

2. Restricted Access:

   * Elements can only be accessed from one end.
   * This end is called the TOP.
   * No access to middle or bottom elements.

3. Fixed Size (Array-Based Implementation):

   * Stack has a predefined capacity.
   * Size does not grow dynamically.
   * Overflow occurs when capacity is exceeded.

4. Structure:

   * Implemented using:
     a) an array to store elements
     b) an integer (top) to track the top element

Why Stacks exist?

--> They model real-world scenarios like stacked objects.
--> They are essential for managing function calls.
--> They simplify problems that require reversal or backtracking.
--> They enforce strict access control to data.

Basic Operations:

1. push(x):

   * Insert an element at the top.
   * Causes overflow if the stack is full.

2. pop():

   * Removes and returns the top element.
   * Causes underflow if the stack is empty.

3. peek():

   * Returns the top element without removing it.

Time Complexity:

1. push(): O(1).
2. pop(): O(1).
3. peek(): O(1).
4. Access (by index): Not allowed.

Space Complexity:

* O(n) where n is the stack capacity.

Trade-offs vs Other Data Structures:

* Simple and fast operations.
* Predictable behavior.
* Excellent for recursion and backtracking.

- Limited access (very restrictive).
- Fixed size in array-based implementations.

--> code by Silver.
*/

package Stack;

public class Stack {

    private int capacity; // maximum size the stack can hold.
    private int arr[]; // stack itself (LIFO implemented using arrays).
    private int top; // index of the top element.

    private int item_counter;

    Stack(int size) {

        // I don't trust humans, not after what happened!
        if (size <= 0) {
            throw new IllegalArgumentException("Stack size must be greater than 0");
        }

        capacity = size;
        arr = new int[capacity];
        top = -1; // initial top value is always -1.

        item_counter = 0;
    }

    // inserting a new item (pushing as we say).
    public void push(int item) {

        // check for stack overflow (not the anime, lol. don't google is tho!).
        if (top == (capacity - 1)) {
            System.out.println("ERROR: Stack Overflow!");
            return;
        }

        // pushing logic.
        top++; // increment top by 1.
        arr[top] = item; // store the new item @ the current top position.t

        item_counter++;
        System.out.println(item + " is the current top!");
    }

    // deleting the top element (popping as we say).
    public int pop() {

        // check for stack underflow.
        if (top == -1) {
            System.out.println("ERROR: Stack Underflow!");
            return -1;
        }

        int popped_item = arr[top]; // store the current top item.
        top--; // decrement top by 1.

        item_counter--;
        return popped_item; // return the removed item.
    }

    // peeking (0-0)
    public int peek() {

        // checking for stack underflow.
        if (top == -1) {
            System.out.println("ERROR: Stack Underflow!");
            return -1;
        }

        return arr[top];
    }

    // getting the stack size.
    public int get_size() {
        return item_counter;
    }
}
