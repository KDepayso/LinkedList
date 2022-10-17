public class Main {
    public static void main(String[] args) {
        MyNode<Integer> node1 = new MyNode<>(1);
        MyNode<Integer> node2 = new MyNode<>(2);
        MyNode<Integer> node3 = new MyNode<>(3);

        node1.setNext(node2);
        node2.setNext(node3);


        System.out.println("Value of node1 is " + node1.getData());
        System.out.println("Value of node2 is " + node1.getNext().getData());
        System.out.println("Value of node3 is " + node1.getNext().getNext().getData());

    }
}