package ch.hslu.ad.sw01;

import java.util.Objects;

public final class Allocation implements Comparable<Allocation> {
    public int getAddress() {
        return address;
    }

    private final int address;

    public int getSize() {
        return size;
    }

    private final int size;

    public Allocation(int address, int size){
        this.address = address;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allocation that = (Allocation) o;
        return address == that.address &&
                size == that.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, size);
    }

    @Override
    public int compareTo(Allocation allocation) {
        return Integer.compare(this.address, allocation.address);
    }
}
