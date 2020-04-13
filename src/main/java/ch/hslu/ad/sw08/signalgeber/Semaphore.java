package ch.hslu.ad.sw08.signalgeber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.plaf.basic.BasicTreeUI;

public final class Semaphore {

    private static final Logger LOG = LogManager.getLogger(Semaphore.class);

    private final Object lock = new Object();
    private final int limit;
    private int permits;
    private int numberOfWaitingThreads;

    public Semaphore(){
        this(0, Runtime.getRuntime().availableProcessors() + 1);
    }

    public Semaphore(final int permits, final int limit) throws IllegalArgumentException{
        if (permits < 0) {
            throw new IllegalArgumentException("Permits must be a positive number.");
        }
        if (limit < 1){
            throw new IllegalArgumentException("Limit must be greater or equals to 1.");
        }
        if (permits > limit){
            throw  new IllegalArgumentException("Permits must not be greater than limit.");
        }

        this.permits = permits;
        this.limit = limit;
        this.numberOfWaitingThreads = 0;
    }

    public void acquire(int permits) throws InterruptedException{
        synchronized (this.lock){
            LOG.info("Thread " + Thread.currentThread().getName() + ": acquire " + permits);
            while(this.permits < permits){
                LOG.info("Thread " + Thread.currentThread().getName() + ": waiting " + permits);
                numberOfWaitingThreads++;
                this.lock.wait();
                numberOfWaitingThreads--;
            }

            LOG.info("Thread " + Thread.currentThread().getName() + ": acquired " + permits);
            this.permits -= permits;
        }
    }

    public void release(int permits) throws SemaphoreFullException{
        synchronized (this.lock){
            LOG.info("Thread " + Thread.currentThread().getName() + ": release " + permits);
            if (this.permits + permits > this.limit){
                LOG.info("Thread " + Thread.currentThread().getName() + ": semaphore full cannot release " + permits);
                throw new SemaphoreFullException();
            }

            LOG.info("Thread " + Thread.currentThread().getName() + ": released " + permits);
            this.permits += permits;

            if (numberOfWaitingThreads > 0){
                this.lock.notifyAll();
            }
        }
    }
}
