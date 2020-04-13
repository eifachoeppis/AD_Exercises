/*
 * Copyright 2020 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw08.pferderennen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Latch implements Synch {

    private static final Logger LOG = LogManager.getLogger(Latch.class);

    private final Object LOCK = new Object();
    private boolean hasStarted = false;
    private final int totalParticipants;
    private int participants = 0;

    public Latch(int totalParticipants){
        if (totalParticipants < 0){
            throw new IllegalArgumentException("totalParticipants must be a positive number");
        }

        this.totalParticipants = totalParticipants;
    }

    @Override
    public void acquire() throws InterruptedException {
        synchronized (this.LOCK){
            this.participants++;
            if (this.participants >= this.totalParticipants && !this.hasStarted){
                this.LOCK.notifyAll();
            }

            while (!this.hasStarted){
                this.LOCK.wait();
            }
        }
    }

    @Override
    public void release() throws InterruptedException {
        synchronized (this.LOCK){
            while(this.participants < this.totalParticipants){
                this.LOCK.wait();
            }

            LOG.info("Start...");
            this.hasStarted = true;
            this.LOCK.notifyAll();
        }
    }
}
