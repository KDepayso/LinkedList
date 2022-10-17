import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {
//        MyNode<Integer> node1 = new MyNode<>(1);
//        MyNode<Integer> node2 = new MyNode<>(2);
//        MyNode<Integer> node3 = new MyNode<>(3);
//
//        node1.setNext(node2);
//        node2.setNext(node3);
//
//
//        System.out.println("Value of node1 is " + node1.getData());
//        System.out.println("Value of node2 is " + node1.getNext().getData());
//        System.out.println("Value of node3 is " + node1.getNext().getNext().getData());

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (int i = 1; i <= 4; i++){
            try {
                System.out.println("Peek = " + stack.peek());
                System.out.println("Pop = " + stack.pop());
            }
            catch (EmptyStackException e ){
                System.out.println("Exception");
            }

        }

        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println("Stack empty is " + stack.isEmpty());
        stack.clear();
        System.out.println("Stack empty is " + stack.isEmpty());

    }
}