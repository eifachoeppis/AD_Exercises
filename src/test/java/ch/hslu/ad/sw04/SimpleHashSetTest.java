package ch.hslu.ad.sw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashSetTest {

    @Test
    void addNull(){
        SimpleHashSet<Integer> testee = new SimpleHashSet<>();
        assertThrows(IllegalArgumentException.class, () -> testee.add(null));
    }

    @Test
    void removeNull(){
        SimpleHashSet<Integer> testee = new SimpleHashSet<>();
        assertThrows(IllegalArgumentException.class, () -> testee.add(null));
    }

    @Test
    void addToFullTable(){
        SimpleHashSet<Integer> testee = new SimpleHashSet<>();
        testee.add(0);
        testee.add(1);
        testee.add(2);
        testee.add(3);
        testee.add(4);
        testee.add(5);
        testee.add(6);
        testee.add(7);
        testee.add(8);
        testee.add(9);
        assertFalse(testee.add(10));
        assertEquals(10, testee.size());
    }

    @Test
    void emptySet(){
        SimpleHashSet<Integer> testee = new SimpleHashSet<>();
        assertEquals(0, testee.size());
    }

    @Test
    void size(){
        SimpleHashSet<Integer> testee = new SimpleHashSet<>();
        testee.add(1);
        testee.add(2);
        testee.add(50);
        assertEquals(3, testee.size());
    }

    @Test
    void addNewItem() {
        SimpleHashSet<Integer> testee = new SimpleHashSet<>();
        testee.add(1);
        assertEquals(1, testee.size());
    }

    @Test
    void addExistingItem(){
        SimpleHashSet<Integer> testee = new SimpleHashSet<>();
        testee.add(1);
        assertFalse(testee.add(1));
        assertEquals(1, testee.size());
    }

    @Test
    void addAndRemove(){
        SimpleHashSet<Integer> testee = new SimpleHashSet<>();
        testee.add(1);
        testee.add(2);
        testee.add(3);
        testee.remove(2);
        assertEquals(2, testee.size());
    }

    @Test
    void removeItemThatIsNotInTable() {
        SimpleHashSet<Integer> testee = new SimpleHashSet<>();
        assertFalse(testee.remove(5));
    }
}