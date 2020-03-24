package ch.hslu.ad.sw02.linkedList;

public interface LinkedList<T> extends Iterable<T>{
        void add(T element);
        void remove(T element);
        boolean contains(T element);
}
