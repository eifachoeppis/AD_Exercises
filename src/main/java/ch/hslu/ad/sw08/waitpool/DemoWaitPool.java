package ch.hslu.ad.sw08.waitpool;

public class DemoWaitPool {

    private static final Object LOCK = new Object();

    private DemoWaitPool() {
    }

    public static void main(final String args[]) throws InterruptedException {
        final MyTask waiter = new MyTask(LOCK);
        new Thread(waiter).start();
        Thread.sleep(1000);

        synchronized (LOCK){
            LOCK.notify();
        }
    }
}
