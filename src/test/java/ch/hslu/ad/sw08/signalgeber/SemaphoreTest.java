package ch.hslu.ad.sw08.signalgeber;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class SemaphoreTest {

    @Test
    void permitsSmallerThanZero() {
        assertThrows(IllegalArgumentException.class, () -> new Semaphore(-1, 10));
    }

    @Test
    void limitSmallerThanOne() {
        assertThrows(IllegalArgumentException.class, () -> new Semaphore(3, 0));
    }

    @Test
    void permitsGreaterThanLimit() {
        assertThrows(IllegalArgumentException.class, () -> new Semaphore(5, 3));
    }

    @Test
    void acquireAvailable() {
        Semaphore semaphore = new Semaphore(5, 5);
        try {
            semaphore.acquire(3);
        } catch (InterruptedException interruptedException) {
            fail("Thread has been interrupted.");
        }

    }

    @Test
    void releaseLessThanLimit() {
        Semaphore semaphore = new Semaphore(0, 5);
        try {
            semaphore.release(3);
        } catch (SemaphoreFullException semaphoreFullException) {
            fail("Should not have thrown SemaphoreFullException");
        }
    }

    @Test
    void releaseMoreThanLimit() {
        Semaphore semaphore = new Semaphore(0, 3);
        assertThrows(SemaphoreFullException.class, () -> semaphore.release(4));
    }
}