/*
Info about Doubly Linked Lists:

1. Dynamic Size:
   - The list grows and shrinks at runtime.
   - No fixed size is required.

2. Non-Contiguous Memory:
   - Nodes are scattered in memory.
   - Each node stores data + two references.

3. Bidirectional Traversal:
   - Each node points to:
     a) the next node
     b) the previous node
   - Traversal is possible in both directions.

4. Structure:
   - Each node contains:
     a) value (data)
     b) next (reference to the next node)
     c) previous (reference to the previous node)

Why Doubly Linked Lists exist?

--> They improve upon singly linked lists by allowing
    backward traversal.
--> Deletion becomes easier because each node knows
    its previous node.
--> With head and tail pointers, insertions and deletions
    at both ends are O(1).

Time Complexity:

1. Access by index: O(n).
2. Traversal (forward/backward): O(n).
3. Search: O(n).
4. Insertion @ head: O(1).
5. Insertion @ tail: O(1).
6. Insertion @ index: O(n).
7. Deletion @ head: O(1).
8. Deletion @ tail: O(1).
9. Deletion @ index: O(n).

Trade-offs vs Singly Linked Lists:

+ Bidirectional traversal.
+ Easier deletion of nodes.
+ Efficient operations at both ends.
- Extra memory for an additional pointer.
- Slightly more complex implementation.

--> code by Silver.
*/

package DoubleLinkedList;

class Node {
    int value;
    Node next;
    Node previous;

    Node() {
        value = 0;
        next = null;
        previous = null;
    }
}

public class DoubleLinkedList {
    private Node head;
    private Node tail;

    DoubleLinkedList() {
        head = null;
        tail = null;
    }

    // insert a new node @ head.
    public void insert_at_head(int key_value) {

        // 1. memory allocation.
        Node new_node = new Node();
        new_node.value = key_value;

        // edge case (1): the first node.
        if (head == null && tail == null) {
            head = new_node;
            tail = new_node;

            System.out.println("First key added!");
            return;
        }

        // 2. linking logic.
        head.previous = new_node;
        new_node.next = head;
        head = new_node;
        System.out.println("A Node with the value " + key_value + " is the new HEAD!");
    }

    // insert @ tail.
    public void insert_at_tail(int key_value) {

        // 1. memory allocation.
        Node new_node = new Node();
        new_node.value = key_value;

        // edge case (1): the first node.
        if (head == null && tail == null) {
            head = new_node;
            tail = new_node;

            System.out.println("First Key added!");
            return;
        }

        // 2. linking logic (using tail).
        new_node.previous = tail;
        tail.next = new_node;
        tail = new_node;
        System.out.println("A Node with the value " + key_value + " is the new TAIL!");
    }

    // insert @ position.
    public void insert_at_index(int key_value, int index) {

        // edge case (1): Invalid index.
        if (index < 0) {
            System.out.println("ERROR: Invalid Index!");
            return;
        }
        if (index == 0) { // edge case (2): the node is @ index 0.
            insert_at_head(key_value);
            return;
        }

        // 1. memory allocation.
        Node new_node = new Node();
        new_node.value = key_value;

        // 2. traversal till index - 1.
        Node temp = head;
        for (int i = 0; i < index - 1; ++i) {
            temp = temp.next;

            // edge case (2): index is bigger than the list itself --> PROBLEMS!
            if (temp == null) {
                System.out.println("ERROR: Invalid Index!");
                return;
            }
        }

        // 3. linking logic.

        // damn that! (I'm nuts!)
        Node nextNode = temp.next;

        new_node.next = nextNode;
        new_node.previous = temp;
        temp.next = new_node;

        if (nextNode != null) { // just to be extra safe!
            nextNode.previous = new_node;
        }

        System.out.println("A Node with value " + key_value + " is @ index " + index);
    }

    // delete a node @ position.
    public void delete_index(int index) {

        // edge case (1): the list is empty.
        if (head == null) {
            System.out.println("ERROR: List is EMPTY!");
            return;
        }
        if (index < 0) { // edge case (2): index < 0.
            System.out.println("ERROR: Invalid Index!");
            return;
        }

        // edge case (3): delete the head node.
        if (index == 0) {

            if (head == tail) { // only one node
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.previous = null;
            }

            System.out.println("Head Terminated!");
            return;
        }

        // 1. find index - 1.
        Node temp = head;
        for (int i = 0; i < index - 1; ++i) {
            temp = temp.next;

            // edge case (4): index is bigger than the list itself --> PROBLEMS!
            if (temp == null) {
                System.out.println("ERROR: Invalid Index!");
                return;
            }
        }

        // 2. deleting logic.

        Node toDelete = temp.next;

        if (toDelete == null) {
            System.out.println("ERROR: Invalid Index!");
            return;
        }

        Node nextNode = toDelete.next;
        temp.next = nextNode;

        if (nextNode != null) {
            nextNode.previous = temp;
        } else {
            tail = temp;
        }

        System.out.println("The element at index " + index + " was Terminated!");
    }

    // traversal (forward).
    public void traverse_forward() {

        System.out.print("List: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.value + " ");
        }
        System.out.println();
    }
}
