package ch.hslu.ad.sw03;

public interface BinarySearchTree<T extends Comparable<T>> extends Iterable<T> {
    boolean contains(T element);
    void add(T element);
    void remove(T element);
    int getCount();
}
