package ch.hslu.ad.sw10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedSizeHeapTest {

    @Test
    void insert_Full_Throws_HeapFullException() throws HeapFullException {
        FixedSizeHeap fixedSizeHeap = new FixedSizeHeap(1);
        fixedSizeHeap.insert(1);
        assertThrows(HeapFullException.class, () -> fixedSizeHeap.insert(2));
    }

    @Test
    void getMax_empty() {
        FixedSizeHeap fixedSizeHeap = new FixedSizeHeap(1);
        assertThrows(HeapEmptyException.class, fixedSizeHeap::getMax);
    }

    @Test
    void insert_getMax_1_element() throws HeapFullException, HeapEmptyException {
        FixedSizeHeap fixedSizeHeap = new FixedSizeHeap(1);
        fixedSizeHeap.insert(5);
        assertEquals(5, fixedSizeHeap.getMax());
    }

    @Test
    void insert_getMax_multiple_times_with_same_elements() throws HeapEmptyException, HeapFullException {
        FixedSizeHeap fixedSizeHeap = new FixedSizeHeap(6);
        fixedSizeHeap.insert(1);
        fixedSizeHeap.insert(3);
        fixedSizeHeap.insert(3);
        fixedSizeHeap.insert(3);
        fixedSizeHeap.insert(7);
        fixedSizeHeap.insert(5);
        assertEquals(7, fixedSizeHeap.getMax());
        assertEquals(5, fixedSizeHeap.getMax());
        assertEquals(3, fixedSizeHeap.getMax());
        assertEquals(3, fixedSizeHeap.getMax());
        assertEquals(3, fixedSizeHeap.getMax());
        assertEquals(1, fixedSizeHeap.getMax());
    }
}