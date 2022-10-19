import java.util.Arrays;
import java.util.Random;

public class PQueue<T extends Comparable<T>> implements PQueueInterface<T> {

    public static void main(String[] args){
        PQueue<Integer> pQueue = new PQueue<Integer>();
        Random random = new Random();
        Integer[] randomValues = new Integer[10];


//        for(int i = 0; i< randomValues.length; i++){
//            randomValues[i] = random.nextInt(1000);
//            //pQueue.enqueue(randomValues[i]);
//        }
        randomValues[0] = 1;
        randomValues[1] = 2;
        randomValues[2] = 3;
        randomValues[3] = 5;
        randomValues[4] = 4;
        randomValues[5] = 6;
        randomValues[6] = 7;
        randomValues[7] = 8;
        randomValues[8] = 9;

        for(int i =0; i < randomValues.length -1; i++){
            pQueue.enqueue(randomValues[i]);
        }


        System.out.println("Random array is " + Arrays.toString(randomValues));

        while(!pQueue.isEmpty()){
            System.out.println("Removing value " + pQueue.dequeue());
        }
    }



    private MyNode<T> front, rear;

    public PQueue() {
        front = null;
        rear = null;
    }




    public void enqueue(T newEntry){
        MyNode<T> newNode = new MyNode<T>(newEntry);
        if(front == null){
            front = newNode;
        }
        //If NewEntry is greater than front return 1
        else if(front.getData().compareTo(newNode.getData()) == -1){
            newNode.setNextNode(front);
            front = newNode;
        }
        else{
            MyNode<T> currentNode = front;
            while(currentNode.getNextNode() != null && currentNode.getNextNode().getData().compareTo(newNode.getData()) == 1){
                //currentNode.setData(currentNode.getNextNode().getData());
                newNode.setNextNode(currentNode.getNextNode());
                currentNode.setNextNode(newNode);

            }

        }

    }

    public T dequeue(){
        if(front == null) return null;
        else{
            T valueToReturn = front.getData();
            front = front.getNextNode();
            if(front == null) rear = null;
            return valueToReturn;
        }
    }

    public T getFront(){
        if(front == null) return null;
        else return front.getData();
    }

    public boolean isEmpty(){
        return (front == null);
    }

    public void clear(){
        front = null;
        rear = null;
    }



}
