package ch.hslu.ad.sw02.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    @Test
    void add() {
        SingleLinkedList<Integer> testee = new SingleLinkedList<>();
        testee.add(5);
        assertEquals(1, testee.getCount());
        assertEquals(5, testee.iterator().next());
    }

    @Test
    void removeNull() {
        SingleLinkedList<Integer> testee = new SingleLinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> testee.remove(null));
    }
    
    @Test
    void removeExistingElement(){
        SingleLinkedList<Integer> testee = new SingleLinkedList<>();
        testee.add(5);
        testee.add(10);
        testee.remove(5);
        assertEquals(1, testee.getCount());
        assertEquals(10, testee.iterator().next());
    }

    @Test
    void removeFirstElement(){
        SingleLinkedList<Integer> testee = new SingleLinkedList<>();
        testee.add(5);
        testee.add(10);
        testee.remove(10);
        assertEquals(1, testee.getCount());
        assertEquals(5, testee.iterator().next());
    }

    @Test
    void removeSingleElement(){
        SingleLinkedList<Integer> testee = new SingleLinkedList<>();
        testee.add(5);
        testee.remove(5);
        assertEquals(0, testee.getCount());
        assertNull(testee.getHead());
    }

    @Test
    void removeElementInbetween(){
        SingleLinkedList<Integer> testee = new SingleLinkedList<>();
        testee.add(3);
        testee.add(5);
        testee.add(7);
        testee.remove(5);
        int count = 0;
        for (Integer i : testee){
            count++;
        }
        assertEquals(2, count);
    }

    @Test
    void getCountInitial() {
        SingleLinkedList<Integer> testee = new SingleLinkedList<>();
        assertEquals(0, testee.getCount());
    }

    @Test
    void getCountAfterAdding() {
        SingleLinkedList<Integer> testee = new SingleLinkedList<>();
        testee.add(5);
        testee.add(8);
        testee.add(8);
        testee.add(8);
        assertEquals(4, testee.getCount());
    }

    @Test
    void ContainsNegative(){
        SingleLinkedList<Integer> testee = new SingleLinkedList<>();
        testee.add(5);
        testee.add(8);
        testee.add(7);
        assertFalse(testee.contains(10));
    }

    @Test
    void ContainsPositive(){
        SingleLinkedList<Integer> testee = new SingleLinkedList<>();
        testee.add(5);
        testee.add(8);
        testee.add(7);
        assertTrue(testee.contains(8));
    }

    @Test
    void ContainsEmpty(){
        SingleLinkedList<Integer> testee = new SingleLinkedList<>();
        assertFalse(testee.contains(10));
    }


}