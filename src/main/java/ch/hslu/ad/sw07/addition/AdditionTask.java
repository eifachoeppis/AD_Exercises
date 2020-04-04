package ch.hslu.ad.sw07.addition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class AdditionTask implements Runnable {

    private static final Logger LOG = LogManager.getLogger(AdditionTask.class);
    private final int start;
    private final int end;

    public AdditionTask(int start, int end){
        if (start > end){
            throw new IllegalArgumentException("start must not be greater than end");
        }

        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        int sum = 0;
        int counter = start;

        while (counter <= end && !thread.isInterrupted()){
            sum += counter;
            counter++;
            try {
                Thread.sleep(15);
            } catch (InterruptedException interruptedException){
                thread.interrupt();
            }
        }

        if (counter > end){
            LOG.info(thread.getName() + ": SUM = " + sum);
        } else {
            LOG.info(thread.getName() + ": interrupted.");
        }
    }
}
