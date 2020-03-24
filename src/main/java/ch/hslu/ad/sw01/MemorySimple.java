package ch.hslu.ad.sw01;

import java.util.*;

public class MemorySimple implements Memory{

    private final int size;
    private final Set<Allocation> usedSpace = new HashSet<>();
    private final TreeSet<Allocation> partitions = new TreeSet<>();

    public MemorySimple(int size){
        this.size = size;
        partitions.add(new Allocation(0, size));
    }

    @Override
    public Allocation malloc(int size) {
        Allocation allocation = null;
        Optional<Allocation> emptyAllocation = partitions.stream().filter(a -> !usedSpace.contains(a) && a.getSize() >= size).findFirst();
        if (emptyAllocation.isPresent()){
            partitions.remove(emptyAllocation.get());
            allocation = new Allocation(emptyAllocation.get().getAddress(), size);
            if (emptyAllocation.get().getSize() > size){
                partitions.add(new Allocation(allocation.getAddress() + size, emptyAllocation.get().getSize() - size));
            }
            usedSpace.add(allocation);
            partitions.add(allocation);
        }

        return allocation;
    }

    @Override
    public void free(Allocation allocation) {
        int address = allocation.getAddress();
        int size = allocation.getSize();
        if (usedSpace.remove(allocation)){
            partitions.remove(allocation);
            Allocation nextAllocation = partitions.ceiling(allocation);
            if (nextAllocation != null && !usedSpace.contains(nextAllocation)){
                size += nextAllocation.getSize();
            }
            Allocation previousAllocation = partitions.floor(allocation);
            if (previousAllocation != null && !usedSpace.contains(previousAllocation)){
                size += previousAllocation.getSize();
                address -= previousAllocation.getSize();
            }
            partitions.add(new Allocation(address, size));
        }
    }
}
