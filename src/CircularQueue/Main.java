package CircularQueue;

public class Main {

    public static void main(String args[]) {

        CircularQueue q = new CircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.get_front() + " " + q.get_rear());
        q.dequeue();
        System.out.println(q.get_front() + " " + q.get_rear());
        q.enqueue(40);
        System.out.println(q.get_front() + " " + q.get_rear());
    }
}
