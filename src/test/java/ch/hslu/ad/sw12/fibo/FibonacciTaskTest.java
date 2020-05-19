package ch.hslu.ad.sw12.fibo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTaskTest {

    @Test
    void test_zero(){
        FibonacciTask fibonacciTask = new FibonacciTask(0);
        assertEquals(0, fibonacciTask.invoke());
    }

    @Test
    void test_one(){
        FibonacciTask fibonacciTask = new FibonacciTask(1);
        assertEquals(1, fibonacciTask.invoke());
    }

    @Test
    void test_two(){
        FibonacciTask fibonacciTask = new FibonacciTask(2);
        assertEquals(1, fibonacciTask.invoke());
    }

    @Test
    void test_three(){
        FibonacciTask fibonacciTask = new FibonacciTask(3);
        assertEquals(2, fibonacciTask.invoke());
    }

    @Test
    void test_four(){
        FibonacciTask fibonacciTask = new FibonacciTask(4);
        assertEquals(3, fibonacciTask.invoke());
    }

    @Test
    void test_negative(){
        assertThrows(IllegalArgumentException.class, () -> new FibonacciTask(-3));
    }

    @Test
    void test_17(){
        FibonacciTask fibonacciTask = new FibonacciTask(17);
        assertEquals(1597, fibonacciTask.invoke());
    }

    @Test
    void test_42(){
        FibonacciTask fibonacciTask = new FibonacciTask(42);
        assertEquals(267914296, fibonacciTask.invoke());
    }
}