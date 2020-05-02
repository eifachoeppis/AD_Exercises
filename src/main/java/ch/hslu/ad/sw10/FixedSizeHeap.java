package ch.hslu.ad.sw10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FixedSizeHeap implements IntegerHeap {

    private final int[] table;
    private final int size;
    private int count;

    public FixedSizeHeap(final int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be at least 1.");
        }

        this.size = size;
        this.table = new int[size];
        this.count = 0;
    }

    @Override
    public void insert(int element) throws HeapFullException {
        if (this.count == this.size) {
            throw new HeapFullException();
        }

        this.table[count] = element;
        bubbleUp(this.count);
        this.count++;
    }

    @Override
    public int getMax() throws HeapEmptyException {
        if (this.count == 0) {
            throw new HeapEmptyException();
        }
        int maxElement = this.table[0];
        this.count--;
        this.table[0] = this.table[this.count];
        sinkDown(this.count);
        return maxElement;
    }

    private void sinkDown(int index) {
        List<Integer> path = getPath(index);
        for (int i = 1; i < path.size(); i++) {
            if (this.table[path.get(i - 1)] < this.table[path.get(i)]) {
                exchange(this.table, path.get(i - 1), path.get(i));
            } else {
                return;
            }
        }
    }

    private void bubbleUp(int index) {
        if (index != 0) {
            int parentIndex = getIndexOfParent(index);
            if (this.table[index] > this.table[parentIndex]) {
                exchange(this.table, index, parentIndex);
                this.bubbleUp(parentIndex);
            }
        }
    }

    private List<Integer> getPath(int index) {
        List<Integer> indexes = new ArrayList<>();
        while (index > 0) {
            indexes.add(index);
            index = getIndexOfParent(index);
        }
        indexes.add(0);
        Collections.reverse(indexes);
        return indexes;
    }

    private static void exchange(final int[] array, int firstIndex, int secondIndex) {
        int temp;
        temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int getIndexOfParent(int index) {
        return (index - 1) / 2;
    }
}
