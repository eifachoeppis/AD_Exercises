package ch.hslu.ad.sw03;

public class Node<T> {
    private Node<T> left;
    private Node<T> right;
    private T data;

    public Node(T data){
        this.data = data;
    }

    public T getData(){
        return this.data;
    }

    public Node<T> getLeft(){
        return this.left;
    }

    public Node<T> getRight(){
        return this.right;
    }

    public void setRight(Node<T> node){
        this.right = node;
    }

    public void setLeft(Node<T> node){
        this.left = node;
    }
}
