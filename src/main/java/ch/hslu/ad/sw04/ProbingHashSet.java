package ch.hslu.ad.sw04;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.Iterator;

public class ProbingHashSet<T> implements HashSet<T>, Iterable<T> {
    private static final int TABLE_SIZE = 10;
    private static final Object TOMBSTONE = new Object();
    private int size;
    private Object[] table = new Object[TABLE_SIZE];

    @Override
    public boolean add(T item) {
        if (item == null){
            throw new IllegalArgumentException("Item must not be null");
        }

        int startIndex = calculateIndex(item.hashCode());
        int index = startIndex;
        do {
            Object element = table[index];
            if (element == null || element == TOMBSTONE){
                table[index] = item;
                size++;
                return true;
            }

            if (element.equals(item)){
                return false;
            }

            index = nextIndex(index);
        } while (index != startIndex);

        // HashSet is full
        return false;
    }

    @Override
    public boolean remove(T item) {
        if (item == null){
            throw new IllegalArgumentException("Item must not be null");
        }

        int startIndex = calculateIndex(item.hashCode());
        int index = startIndex;
        do {
            Object element = table[index];
            if (item.equals(element)){
                table[index] = TOMBSTONE;
                size--;
                return true;
            }

            if (element == null){
                return false;
            }

            index = nextIndex(index);
        } while (index != startIndex);

        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    private int calculateIndex(int hashCode){
        return hashCode % TABLE_SIZE;
    }

    private boolean contains(int index){
        return table[index] != null;
    }

    private int nextIndex(int index){
        index++;
        if (index == TABLE_SIZE){
            index = 0;
        }

        return index;
    }

    @Override
    public String toString() {
        return "SimpleHashSet{" +
                "size=" + size +
                ", table=" + Arrays.toString(table) +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                while(this.index < TABLE_SIZE){
                    if (table[this.index] != null && table[this.index] != TOMBSTONE){
                        return  true;
                    }
                    this.index++;
                }
                return false;
            }

            @Override
            public T next() {
                return (T) table[index++];
            }
        };
    }
}
