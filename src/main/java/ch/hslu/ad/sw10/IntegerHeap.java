package ch.hslu.ad.sw10;

public interface IntegerHeap {
    void insert(int element) throws HeapFullException;
    int getMax() throws HeapEmptyException;
}
