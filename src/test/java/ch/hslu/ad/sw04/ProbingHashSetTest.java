package ch.hslu.ad.sw04;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ProbingHashSetTest {

    @Test
    void addNull(){
        ProbingHashSet<Integer> testee = new ProbingHashSet<>();
        assertThrows(IllegalArgumentException.class, () -> testee.add(null));
    }

    @Test
    void removeNull(){
        ProbingHashSet<Integer> testee = new ProbingHashSet<>();
        assertThrows(IllegalArgumentException.class, () -> testee.add(null));
    }

    @Test
    void addToFullTable(){
        ProbingHashSet<Integer> testee = new ProbingHashSet<>();
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
        ProbingHashSet<Integer> testee = new ProbingHashSet<>();
        assertEquals(0, testee.size());
    }

    @Test
    void size(){
        ProbingHashSet<Integer> testee = new ProbingHashSet<>();
        testee.add(1);
        testee.add(2);
        testee.add(50);
        assertEquals(3, testee.size());
    }

    @Test
    void addNewItem() {
        ProbingHashSet<Integer> testee = new ProbingHashSet<>();
        testee.add(1);
        assertEquals(1, testee.size());
    }

    @Test
    void addExistingItem(){
        ProbingHashSet<Integer> testee = new ProbingHashSet<>();
        testee.add(1);
        assertFalse(testee.add(1));
        assertEquals(1, testee.size());
    }

    @Test
    void addAndRemove(){
        ProbingHashSet<Integer> testee = new ProbingHashSet<>();
        testee.add(1);
        testee.add(2);
        testee.add(3);
        testee.remove(2);
        assertEquals(2, testee.size());
    }

    @Test
    void removeItemThatIsNotInTable() {
        ProbingHashSet<Integer> testee = new ProbingHashSet<>();
        assertFalse(testee.remove(5));
    }

    @Test
    void collision() {
        ProbingHashSet<Integer> testee = new ProbingHashSet<>();
        testee.add(1);
        testee.add(11);
        testee.add(21);
        assertEquals(3, testee.size());
    }

    @Test
    void probing(){
        ProbingHashSet<Integer> testee = new ProbingHashSet<>();
        testee.add(1);
        testee.add(11);
        testee.add(21);
        testee.remove(11);
        testee.remove(1);
        testee.remove(21);
        assertEquals(0, testee.size());
    }

    @Test
    void iterator(){
        ProbingHashSet<Integer> testee = new ProbingHashSet<>();
        testee.add(0);
        testee.add(4);
        testee.add(9);

        Iterator<Integer> iterator = testee.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(0, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(9, iterator.next());
        assertFalse(iterator.hasNext());
    }
}