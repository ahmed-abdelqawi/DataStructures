/*

Info about Singly Linked Lists:

1. Dynamic Size:
   - The list grows and shrinks at runtime.
   - No fixed size like arrays.

2. Non-Contiguous Memory:
   - Nodes are scattered in memory.
   - Each node stores data + a reference (pointer) to the next node.

3. Sequential Access:
   - Elements cannot be accessed directly by index.
   - Traversal from the head is required.

4. Structure:
   - Each node contains:
     a) value (data)
     b) next (reference to the next node)

Why Linked Lists exist?

--> Unlike arrays, linked lists do NOT require contiguous memory.
--> Insertions and deletions do NOT require shifting elements.
--> Memory is allocated only when needed.

Time Complexity:

1. Access by index: O(n).
2. Traversal: O(n).
3. Search: O(n).
4. Insertion @ head: O(1).
5. Insertion @ tail: O(n).  // O(1) if tail pointer exists
6. Insertion @ index: O(n).
7. Deletion @ head: O(1).
8. Deletion @ tail: O(n).
9. Deletion @ index: O(n).

Trade-offs vs Arrays:

+ Fast insertions and deletions.
+ Dynamic size.
- Slower access.
- Extra memory for pointers.
- Poor cache locality.

--> code by Silver.
*/

package LinkedList;

class Node {
    int value;
    Node next;

    Node() {
        value = 0;
        next = null;
    }
}

public class SingleLinkedList {

    private Node head;

    SingleLinkedList() {
        head = null;
    }

    // insert a new node @ head.
    public void insert_at_head(int data) {

        // 1. allocate memory and set value.
        Node new_node = new Node();
        new_node.value = data;

        // 2. link the new_node.
        new_node.next = head;
        head = new_node;
        System.out.println("New Node with the value " + data + " is the new HEAD!");
    }

    // insert a new node @ tail.
    public void insert_at_tail(int data) {

        // 1. the list is empty.
        if (head == null) {
            insert_at_head(data);
            return;
        }

        // 2. allocate memory and set value.
        Node new_node = new Node();
        new_node.value = data;

        // 3. traverse the list till the end.
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        } // we're @ the last node. (aka tail)

        // 4. the link.
        temp.next = new_node;
        System.out.println("New Node with the value " + data + " is the new TAIL!");
    }

    // insert a new_node @ some position.
    public void insert_at_index(int data, int index) {

        // edge case: index < 0.
        if (index < 0) {
            System.out.println("ERROR: Invalid Index!");
            return;
        }

        // 1. index = 0 (insert @ head).
        if (index == 0) {
            insert_at_head(data);
            return;
        }

        // 2. allocation and set value.
        Node new_node = new Node();
        new_node.value = data;

        // 3. traverse till index - 1.
        Node temp = head;
        for (int i = 0; i < index - 1; ++i) {
            temp = temp.next;

            // the index is bigger than the list itself. this means problems :)
            if (temp == null) {
                System.out.println("ERROR: Invalid Index!");
                return;
            }

        } // wer're @ the node before the wanted index.

        // 4. the link.

        // WASTE OF MEMORY!!!!!!!
        // if (temp.next == null) { // insert @ the last index (new tail).
        // insert_at_tail(data);
        // return;
        // }

        new_node.next = temp.next;
        temp.next = new_node;
        System.out.println("The Node with the value " + data + " is @ index " + index);
    }

    public void delete_index(int index) {

        // edge case (0): the list is empty.
        if (head == null) {
            System.out.println("ERROR: List is Empty!");
            return;
        }

        // edge case (1): index < 0.
        if (index < 0) {
            System.out.println("ERROR: Invalid Index!");
            return;
        }

        // edge case (2): index = 0.
        if (index == 0) {
            head = head.next;
            System.out.println("The HEAD has been Terminated!");
            return;
        }

        // 1. traverse till index - 1.
        Node temp = head;
        for (int i = 0; i < index - 1; ++i) {
            temp = temp.next;

            // the index is bigger than the list itself. this means problems :)
            if (temp == null) {
                System.out.println("ERROR: Invalid Index!");
                return;
            }

        } // wer're @ the node before the wanted index.

        // 2. deletion.

        if (temp.next == null) { // checking for the tail.
            System.out.println("ERROR: Invalid Index!");
            return;
        }
        if (temp.next.next == null) { // the wanted node is the tail.
            temp.next = null;
            System.out.println("The TAIL has been Terminated!");
            return;
        }

        temp.next = temp.next.next;
        System.out.println("The node @ index " + index + " has been Terminated!");
    }

    // traverse the list.
    public void traverse_forward() {

        System.out.print("List: ");
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.value + " ");
        }
        System.out.println();
    }

}
