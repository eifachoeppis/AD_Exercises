package ch.hslu.ad.sw01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemorySimpleTest {

    @Test
    void TestSimpleAllocation(){
        Memory testee = new MemorySimple(1024);
        Allocation allocation = testee.malloc(100);
        assertEquals(100, allocation.getSize());
    }

    @Test
    void TestNotEnoughMemory(){
        Memory testee = new MemorySimple(1024);
        Allocation allocation = testee.malloc(1025);
        assertNull(allocation);
    }

    @Test
    void TestMultipleAllocations(){
        Memory testee = new MemorySimple(1024);
        testee.malloc(10);
        Allocation allocation = testee.malloc(50);
        assertEquals(10, allocation.getAddress());
    }

    @Test
    void TestMultipleAllocationsWithFree(){
        Memory testee = new MemorySimple(10);
        Allocation allocation = testee.malloc(7);
        testee.free(allocation);
        Allocation toTest = testee.malloc(8);
        assertEquals(0, toTest.getAddress());
    }
}