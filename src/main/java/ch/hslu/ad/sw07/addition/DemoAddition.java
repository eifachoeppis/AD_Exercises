package ch.hslu.ad.sw07.addition;

import java.util.ArrayList;
import java.util.List;

public final class DemoAddition {

    private DemoAddition() {
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(new AdditionTask(0, 2), "Thread " + 0));
        threads.add(new Thread(new AdditionTask(0, 1000000), "Thread " + 1));
        threads.add(new Thread(new AdditionTask(69, 666), "Thread " + 2));
        threads.add(new Thread(new AdditionTask(3, 42), "Thread " + 3));
        threads.add(new Thread(new AdditionTask(10000000, 20000000), "Thread " + 4));
        threads.add(new Thread(new AdditionTask(5000, 10000), "Thread " + 5));

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException interruptedException) {
            System.exit(420);
        }

        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
