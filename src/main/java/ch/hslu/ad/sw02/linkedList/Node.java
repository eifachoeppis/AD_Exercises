package ch.hslu.ad.sw02.linkedList;

class Node <T> {
    private Node<T> next;
    private T data;

    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

    public Node<T> getNext(){
        return this.next;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public T getData(){
        return this.data;
    }
}
