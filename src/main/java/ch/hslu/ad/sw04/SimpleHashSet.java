package ch.hslu.ad.sw04;

import java.util.Arrays;

public class SimpleHashSet<T> implements HashSet<T> {
    private static final int TABLE_SIZE = 10;
    private int size;
    private Object[] table = new Object[TABLE_SIZE];

    @Override
    public boolean add(T item) {
        if (item == null){
            throw new IllegalArgumentException("Item must not be null");
        }

        int index = calculateIndex(item.hashCode());
        if (size < TABLE_SIZE && !this.contains(index)){
            table[index] = item;
            size++;
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(T item) {
        if (item == null){
            throw new IllegalArgumentException("Item must not be null");
        }

        int index = calculateIndex(item.hashCode());
        if (this.contains(index)){
            table[index] = null;
            size--;
            return true;
        }

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

    @Override
    public String toString() {
        return "SimpleHashSet{" +
                "size=" + size +
                ", table=" + Arrays.toString(table) +
                '}';
    }
}
