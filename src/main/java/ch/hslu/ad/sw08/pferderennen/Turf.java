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

import java.util.ArrayList;

public final class Turf {

    private static final Logger LOG = LogManager.getLogger(Turf.class);

    private Turf() {
    }

    public static void main(final String[] args) throws InterruptedException{
        final int participants = 5;

        final Synch starterBox = new Latch(participants);
        final ArrayList<Thread> threads = new ArrayList<>();
        Thread thread;
        for (int i = 1; i <= participants; i++) {
            thread = new Thread(new RaceHorse(starterBox), "Horse " + i);
            threads.add(thread);
            thread.start();
        }

        starterBox.release();
        Thread.sleep(10);
        Interrupt(threads);
    }

    private static void Interrupt(Iterable<Thread> threads){
        for (Thread thread : threads){
            thread.interrupt();
        }
    }
}
