package LinkedList;

public class Main {

    public static void main(String args[]) {
        SingleLinkedList sl = new SingleLinkedList();

        sl.insert_at_tail(101);
        System.out.println();

        sl.insert_at_head(5);
        sl.insert_at_head(10);
        sl.insert_at_head(16);
        sl.insert_at_head(99);
        sl.insert_at_head(69);
        sl.traverse_forward();
        System.out.println();

        sl.insert_at_tail(100);
        sl.insert_at_tail(1);
        sl.insert_at_tail(77);
        sl.insert_at_tail(666);
        sl.traverse_forward();
        System.out.println();

        sl.insert_at_index(660, 0); // List: 660 69 99 16 10 5 101 100 1 77 666
        sl.traverse_forward();
        System.out.println();

        sl.insert_at_index(19, 3); // List: 660 69 99 19 16 10 5 101 100 1 77 666
        sl.traverse_forward();
        System.out.println();

        sl.insert_at_index(19, 11); // List: 660 69 99 19 16 10 5 101 100 1 77 666
        sl.traverse_forward();
        System.out.println();

        sl.insert_at_index(20, 12); // List: 660 69 99 19 16 10 5 101 100 1 77 19 20 666
        sl.traverse_forward();
        System.out.println();

        sl.insert_at_index(1, -1); // error
        sl.traverse_forward();
        System.out.println();

        sl.insert_at_index(1, 15); // error
        sl.traverse_forward();
        System.out.println();

        // List: 660 69 99 19 16 10 5 101 100 1 77 19 20 666

        sl.delete_index(0); // List: 69 99 19 16 10 5 101 100 1 77 19 20 666
        sl.traverse_forward();
        System.out.println();

        sl.delete_index(3); // List: 69 99 19 10 5 101 100 1 77 19 20 666
        sl.traverse_forward();
        System.out.println();

        sl.delete_index(11); // List: 69 99 19 10 5 101 100 1 77 19 20
        sl.traverse_forward();
        System.out.println();

        sl.delete_index(12); // error
        sl.traverse_forward();
        System.out.println();

        sl.delete_index(-2); // error
        sl.traverse_forward();
        System.out.println();
    }
}
