package DoubleLinkedList;

public class Main {

    public static void main(String args[]) {
        DoubleLinkedList dl = new DoubleLinkedList();

        dl.insert_at_head(10);
        dl.insert_at_head(550);
        dl.insert_at_head(69);
        dl.insert_at_head(42);
        dl.insert_at_head(505);
        dl.traverse_forward();
        System.out.println();

        dl.insert_at_tail(0);
        dl.insert_at_tail(70);
        dl.insert_at_tail(88);
        dl.insert_at_tail(8008);
        dl.insert_at_tail(555);
        dl.traverse_forward();
        System.out.println();

        dl.insert_at_index(1000, 0);
        dl.traverse_forward();
        System.out.println();

        dl.insert_at_index(666, 3);
        dl.traverse_forward();
        System.out.println();

        dl.insert_at_index(888, 9);
        dl.traverse_forward();
        System.out.println();

        dl.insert_at_index(0, 14);
        dl.traverse_forward();
        System.out.println();

        dl.insert_at_index(777, -1);
        dl.traverse_forward();
        System.out.println();

        dl.delete_index(0); // List: 505 42 666 69 550 10 0 70 888 88 8008 555
        dl.traverse_forward();
        System.out.println();

        dl.delete_index(3); // List: 505 42 666 550 10 0 70 888 88 8008 555
        dl.traverse_forward();
        System.out.println();

        dl.delete_index(10); // List: 505 42 666 550 10 0 70 888 88 8008
        dl.traverse_forward();
        System.out.println();

        dl.delete_index(10); // error
        dl.traverse_forward();
        System.out.println();

        dl.delete_index(-1); // error
        dl.traverse_forward();
        System.out.println();
    }
}
