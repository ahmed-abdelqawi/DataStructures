package Stack;

public class Main {

    public static void main(String argc[]) {
        Stack s = new Stack(5);

        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5); // error
        System.out.println();

        System.out.println("testing peek (0-0): " + s.peek());
        System.out.println();

        int size = s.get_size();
        for (int i = 0; i < size; ++i) {
            System.out.println(s.pop());
        }
        System.out.println();
    }
}
