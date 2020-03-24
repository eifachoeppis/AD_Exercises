package ch.hslu.ad.sw02.linkedList;

import java.util.Iterator;

class SingleLinkedListIterator<T> implements Iterator<T> {
    private Node<T> currentNode;

    public SingleLinkedListIterator(SingleLinkedList<T> list){
        this.currentNode = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public T next() {
        T data = currentNode.getData();
        currentNode = currentNode.getNext();
        return data;
    }
}
