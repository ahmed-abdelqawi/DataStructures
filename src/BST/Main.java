package BST;

public class Main {

    public static void main(String args[]) {
        BST tree = new BST();

        tree.insert(85);
        tree.insert(504);
        tree.insert(69);
        tree.insert(56);
        tree.insert(0);
        tree.insert(1);
        tree.insert(80);
        tree.insert(46);
        tree.insert(55);
        tree.insert(8);

        tree.inorder_display();
        tree.postorder_display();
        tree.preorder_display();
        System.out.println();

        tree.search(504);
        tree.search(8);
        tree.search(0);
        tree.search(1050);
        System.out.println();

        tree.delete(504);
        tree.delete(0);
        tree.delete(46);
        tree.delete(5050);

        tree.inorder_display();
        tree.postorder_display();
        tree.preorder_display();
        System.out.println();
    }
}
