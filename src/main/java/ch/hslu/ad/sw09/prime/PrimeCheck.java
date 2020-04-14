/*
 * Copyright 2020 Hochschule Luzern Informatik.
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
package ch.hslu.ad.sw09.prime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 100 grosse Primzahlen produzieren.
 */
public final class PrimeCheck {

    private static final Logger LOG = LogManager.getLogger(PrimeCheck.class);

    /**
     * Privater Konstruktor.
     */
    public PrimeCheck() {
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        final Callable<BigInteger> callable = () -> {
            BigInteger bigInteger;
            do {
                bigInteger = new BigInteger(1024, new Random());
            } while (!bigInteger.isProbablePrime(Integer.MAX_VALUE));

            return bigInteger;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        ArrayList<Future<BigInteger>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            futures.add(executorService.submit(callable));
        }

        int n = 1;
        for (Future<BigInteger> future : futures) {
            try {
                BigInteger bigInteger = future.get();
                LOG.info(n + ": " + bigInteger.toString().substring(0, 20) + "...");
                n++;
            } catch (InterruptedException | ExecutionException e) {
                LOG.info("Thread has been interrupted");
            }
        }

        executorService.shutdown();
    }
}
