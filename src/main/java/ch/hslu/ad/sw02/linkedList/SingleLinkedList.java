package ch.hslu.ad.sw02.linkedList;

import java.util.Iterator;

public class SingleLinkedList<T> implements LinkedList<T> {
    private Node<T> head = null;
    private int count = 0;

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element, head);
        head = newNode;
        count++;
    }

    @Override
    public void remove(T element) {
        if (element == null) {
            throw new IllegalArgumentException("ArgumentNullException argument 'element'.");
        }
        Node<T> node = head;
        Node<T> previousNode = null;
        while (node != null) {
            if (element.equals(node.getData())) {
                if (previousNode != null) {
                    previousNode.setNext(node.getNext());
                } else {
                    this.head = node.getNext();
                }
                count--;
                return;
            }
            previousNode = node;
            node = node.getNext();
        }
    }

    @Override
    public boolean contains(T element) {
        if (element == null) {
            throw new IllegalArgumentException("ArgumentNullException argument 'element'.");
        }
        Node<T> node = head;
        while (node != null) {
            if (element.equals(node.getData())) {
                return true;
            }
            node = node.getNext();
        }

        return false;
    }

    public int getCount() {
        return this.count;
    }

    public Node<T> getHead() {
        return this.head;
    }

    @Override
    public Iterator<T> iterator() {
        return new SingleLinkedListIterator<>(this);
    }
}
