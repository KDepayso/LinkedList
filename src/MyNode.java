public class MyNode<T> {
    private T data;
    private MyNode<T> nextNode;

    public MyNode(T dataValue){
        data = dataValue;
        nextNode = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(MyNode<T> node) {
        nextNode = node;
    }
}
