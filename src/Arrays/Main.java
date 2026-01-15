package Arrays;

public class Main {
    public static void main(String args[]) {
        Arr arr = new Arr(10);

        System.out.println("==== Normal Insert ====");
        arr.normal_insert(1);
        arr.normal_insert(60);
        arr.normal_insert(8);
        arr.normal_insert(17);
        arr.normal_insert(10);
        arr.display_pool();

        System.out.println("==== Index Insert ====");
        arr.index_insert(1, 3);
        arr.index_insert(1, 5);
        arr.index_insert(9, 8);
        arr.index_insert(666, 10);
        arr.index_insert(404, 11);
        arr.index_insert(505, -7);
        arr.display_pool();

        System.out.println("==== Deleting ====");
        arr.delete(2); // Array: 1 60 1 17 1 10
        arr.delete(0); // Array: 60 1 17 1 10
        arr.delete(5); // error.
        arr.delete(4); // Array: 60 1 17 1
        arr.display_pool();
    }
}
