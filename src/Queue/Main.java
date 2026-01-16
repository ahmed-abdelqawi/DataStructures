package Queue;

public class Main {

    public static void main(String args[]) {
        Queue q = new Queue(3);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("Front: " + q.get_front());

        q.dequeue();
        System.out.println("Front: " + q.get_front());
        System.out.println("Rear: " + q.get_rear());

        q.enqueue(40);
    }
}
