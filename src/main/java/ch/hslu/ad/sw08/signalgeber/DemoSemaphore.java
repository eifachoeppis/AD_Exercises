package ch.hslu.ad.sw08.signalgeber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicLong;

public final class DemoSemaphore {

    private static Logger LOG = LogManager.getLogger(DemoSemaphore.class);

    private DemoSemaphore() {
    }

    public static void main(String[] args) throws InterruptedException{
        Semaphore semaphore = new Semaphore(0, 5);

        Thread thread1 = new Thread(() -> {
            try {
                semaphore.acquire(3);
            } catch (InterruptedException interruptedException) {
                LOG.debug("thread interrupted");
            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            try {
                semaphore.release(5);
            } catch (SemaphoreFullException semaphoreFullException) {
                LOG.debug("thread interrupted");
            }
        }, "thread2");

        Thread thread3 = new Thread(() -> {
            try {
                semaphore.release(5);
            } catch (SemaphoreFullException semaphoreFullException) {
                LOG.debug("thread interrupted");
            }
        }, "thread3");

        thread1.start();
        thread2.start();
        thread2.join();
        thread3.start();
    }
}
