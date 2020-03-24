package ch.hslu.ad.sw02.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueRingBufferTest {

    @Test
    void emptyDequeue() {
        QueueRingBuffer testee = new QueueRingBuffer();
        assertThrows(Exception.class, () -> testee.dequeue());
    }

    @Test
    void queueSingleItem() throws Exception {
        QueueRingBuffer testee = new QueueRingBuffer();
        testee.queue('a');
        assertEquals(1, testee.getCount());
    }

    @Test
    void queueAndDequeue() throws Exception {
        QueueRingBuffer testee = new QueueRingBuffer();
        testee.queue('x');
        char x = testee.dequeue();
        assertEquals(0, testee.getCount());
        assertEquals('x', x);
    }

    @Test
    void queueEightTimes() throws Exception {
        QueueRingBuffer testee = new QueueRingBuffer();
        for (int i = 0; i < 8; i++) {
            testee.queue('v');
        }
        assertEquals(8, testee.getCount());
    }

    @Test
    void queueOverflow() throws Exception {
        QueueRingBuffer testee = new QueueRingBuffer();
        for (int i = 0; i < 8; i++) {
            testee.queue('v');
        }
        assertThrows(Exception.class, () -> testee.queue('j'));
    }

    @Test
    void queueAndDequeueMoreThanSize() throws Exception{
        QueueRingBuffer testee = new QueueRingBuffer();
        for (int i = 0; i < 8; i++) {
            testee.queue('v');
        }
        testee.dequeue();
        testee.dequeue();
        testee.queue('u');
        assertEquals(7, testee.getCount());
    }
}