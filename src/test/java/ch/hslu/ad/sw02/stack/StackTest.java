package ch.hslu.ad.sw02.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testEmptyStack(){
        ArrayStack testee = new ArrayStack(5);
        assertEquals(0, testee.getCount());
    }

    @Test
    void addSingleElement() throws Exception {
        ArrayStack testee = new ArrayStack(5);
        testee.push("sieht schlecht aus");
        assertEquals(1, testee.getCount());
    }

    @Test
    void stackOverflow() throws Exception{
        ArrayStack testee = new ArrayStack(1);
        testee.push("spende");
        assertThrows(Exception.class, () -> testee.push("oh no it is ono"));
    }

    @Test
    void pushAndPop() throws Exception{
        ArrayStack testee = new ArrayStack(1);
        testee.push("123");
        assertEquals("123", testee.pop());
        assertEquals(0, testee.getCount());
    }
}