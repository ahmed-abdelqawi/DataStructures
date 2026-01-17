/*

SPOILERS: I HATE TRESS!!!!!!!!!!!!

Info about Binary Search Trees (BST):

1. Hierarchical Structure:

   * A BST is a non-linear data structure.
   * Data is stored in nodes arranged as a tree.
   * Each node can have at most two children.

2. BST Property:

   * For every node:
     a) All values in the LEFT subtree are smaller.
     b) All values in the RIGHT subtree are greater.
   * This property enables efficient searching.

3. Dynamic Size:

   * BST grows and shrinks dynamically.
   * No fixed size or contiguous memory required.

4. Structure:

   * Each node contains:
     a) value (data)
     b) left (reference to left child)
     c) right (reference to right child)

Why Binary Search Trees exist?

--> They allow faster search compared to linear structures.
--> They maintain data in a sorted hierarchical form.
--> They enable efficient insertion and deletion.
--> Inorder traversal outputs sorted data.

Basic Operations:

1. Insertion:

   * Insert recursively based on BST property.
   * Duplicates are typically ignored or handled separately.

2. Search:

   * Compare the key and move left or right accordingly.
   * Eliminates half of the tree at each step (if balanced).

3. Deletion:

   * Three cases:
     a) Node is a leaf
     b) Node has one child
     c) Node has two children
   * In the two-children case:
     --> Replace node with its inorder successor.

4. Traversals:

   * Inorder  (Left → Root → Right)
   * Preorder (Root → Left → Right)
   * Postorder(Left → Right → Root)

Time Complexity:

* Average Case (Balanced Tree):

  1. Insertion: O(log n)
  2. Search: O(log n)
  3. Deletion: O(log n)

* Worst Case (Skewed Tree):

  1. Insertion: O(n)
  2. Search: O(n)
  3. Deletion: O(n)

Space Complexity:

* O(n) for storing n nodes.
* Recursive operations use O(h) stack space,
  where h is the height of the tree.

Trade-offs vs Other Structures:

* Faster search than arrays and linked lists (on average).
* Maintains sorted data.
* Efficient dynamic operations.

- Performance degrades if tree becomes unbalanced.
- No guaranteed O(log n) without self-balancing.

Why Balanced Trees exist?

--> To guarantee logarithmic performance.
--> Examples include AVL Trees and Red-Black Trees.

--> code by Silver.
*/

package BST;

class Node {
    int value;
    Node right;
    Node left;

    Node(int key) {
        value = key;

        right = null;
        left = null;
    }
}

public class BST {
    private Node root;

    BST() {
        this.root = null;
    }

    public void insert(int key) {
        this.root = insert_key(this.root, key);
    }

    // (HELPER FUNCTION!) insert a new key. "Damn it, fr!"
    // note: I'm ignoring duplicate values, just to keep it simple... :)
    private Node insert_key(Node root, int key) {

        // this means we walked down the whole tree and we fond the correct spot,
        // for the newNode and this will return a new allocated node that will be the
        // left or right,
        // child of the previous root.
        // or the tree was empty when we started :)
        if (root == null)
            return new Node(key);

        // here we choose which subtree of the BST we will insert into,
        // following the BST algorithm.
        if (key < root.value)
            root.left = insert_key(root.left, key);
        else if (key > root.value)
            root.right = insert_key(root.right, key);

        // we return the root that we started with (Node root),
        // so we will not lose the root of the tree.
        return root;
    }

    // inorder display (left --> root --> right).
    public void inorder_display() {
        System.out.print("Inorder Display: ");
        left_root_right(this.root);
        System.out.println();
    }

    // HELPER FUNCTION
    private void left_root_right(Node root) {
        if (root != null) {
            // go left.
            left_root_right(root.left);

            // print the root, with a space :)
            System.out.print(root.value + " ");

            // go right.
            left_root_right(root.right);
        }
    }

    // postorder display (left --> right --> root).
    public void postorder_display() {
        System.out.print("Postorder Display: ");
        left_right_root(this.root);
        System.out.println();
    }

    // HELPER FUNCTION
    private void left_right_root(Node root) {
        if (root != null) {
            // go left.
            left_right_root(root.left);

            // go right.
            left_right_root(root.right);

            // print the root, with a space :)
            System.out.print(root.value + " ");
        }
    }

    // preorder display (root --> left --> right).
    public void preorder_display() {
        System.out.print("Preorder Display: ");
        root_left_right(this.root);
        System.out.println();
    }

    // HELPER FUNCTION
    private void root_left_right(Node root) {
        if (root != null) {
            // print the root, with a space :)
            System.out.print(root.value + " ");

            // go left.
            root_left_right(root.left);

            // go right.
            root_left_right(root.right);
        }
    }

    public void search(int key) {
        if (element_is_found(this.root, key))
            System.out.println("key " + key + " FOUND!");
        else
            System.out.println("key " + key + " NOT found!!");
    }

    // (HELPER FUNCTION) search average --> O(log(n)), worst O(n).
    private boolean element_is_found(Node root, int key) {
        // element not found!
        if (root == null)
            return false;

        // found!
        if (root.value == key)
            return true;

        // the searching stuff...
        if (key < root.value)
            return element_is_found(root.left, key);
        else
            return element_is_found(root.right, key);
    }

    // Delete a node "wtf, bro! I hate myself!!!!"
    public void delete(int key) {
        this.root = delete_key(this.root, key);
    }

    // HELPER FUNCTION 1, the deleting logic.
    private Node delete_key(Node root, int key) {
        // the tree is empty! or element is NOT found.
        if (root == null) {
            return root;
        }

        // normal binary search stuff.
        if (key < root.value)
            root.left = delete_key(root.left, key);
        else if (key > root.value)
            root.right = delete_key(root.right, key);
        else { // we found the key we're looking for (bingo!).

            // the node has only one child.
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // the node has 2 children.

            // first we find the minimum key in the right subtree.
            Node successor = find_min(root.right);

            // make the successor's value = root's value.
            root.value = successor.value;

            // deleting the successor's key from the right subtree.
            root.right = delete_key(root.right, successor.value);
        }

        // this is the main root!!!
        return root;
    }

    // HELPER FUNCTION 2, finding the left most node.
    private Node find_min(Node root) {
        // the base case.
        if (root.left == null)
            return root;

        return find_min(root.left);
    }
}
