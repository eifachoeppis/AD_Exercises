package ch.hslu.ad.sw08.signalgeber;

import java.util.concurrent.atomic.AtomicLong;

public final class DemoSemaphore {

    private DemoSemaphore() {
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0, 5);

        Thread thread1 = new Thread(() -> {
            try {
                semaphore.acquire(3);
            } catch (InterruptedException interruptedException) {
                return;
            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            try {
                semaphore.release(5);
            } catch (SemaphoreFullException semaphoreFullException) {
                return;
            }
        }, "thread2");

        Thread thread3 = new Thread(() -> {
            try {
                semaphore.release(5);
            } catch (SemaphoreFullException semaphoreFullException) {
                return;
            }
        }, "thread3");

        thread1.start();
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException interruptedException) {
            return;
        }
        thread3.start();
    }
}
