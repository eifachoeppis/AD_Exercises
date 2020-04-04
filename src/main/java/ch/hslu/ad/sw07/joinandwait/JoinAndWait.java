package ch.hslu.ad.sw07.joinandwait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class JoinAndWait extends Thread {

    private static final Logger LOG = LogManager.getLogger(JoinAndWait.class);
    private final int sleepTime;
    private final Thread waitFor;

    public JoinAndWait(String name, int sleepTime, Thread waitFor) {
        super(name);
        if (sleepTime < 0) {
            throw new IllegalArgumentException("The parameter 'sleepTime' must be bigger than 0.");
        }

        this.sleepTime = sleepTime;
        this.waitFor = waitFor;
    }

    @Override
    public void run() {
        try {
            if (this.waitFor != null) {
                LOG.info(this.getName() + " waits for: " + waitFor.getName());
                waitFor.join();
            } else {
                LOG.info(this.getName() + " doesn't have to wait.");
            }

            LOG.info(this.getName() + " sleeps for " + this.sleepTime);
            Thread.sleep(this.sleepTime);
        } catch (InterruptedException interruptedException) {
            LOG.info(this.getName() + " has been interrupted.");
        }
    }
}
