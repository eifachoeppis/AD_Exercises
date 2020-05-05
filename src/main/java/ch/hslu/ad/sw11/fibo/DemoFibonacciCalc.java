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
package ch.hslu.ad.sw11.fibo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

/**
 * Codevorlage für die Verwendung von RecursiveTask mit einem Fork-Join-Pool.
 */
public final class DemoFibonacciCalc {

    private static final Logger LOG = LogManager.getLogger(DemoFibonacciCalc.class);

    /**
     * Privater Konstruktor.
     */
    private DemoFibonacciCalc() {
    }

    /**
     * Berechnet den Fibonacci Wert für n.
     *
     * @param n für die Fibonacci Berechnung.
     * @return Resultat der Fibonacci Berechnung.
     */
    public static long fiboIterative(final int n) {
        long f = 0;
        long g = 1;
        for (int i = 1; i <= n; i++) {
            f = f + g;
            g = f - g;
        }
        return f;
    }

    /**
     * Berechnet den Fibonacci Wert für n.
     *
     * @param n für die Fibonacci Berechnung.
     * @return Resultat der Fibonacci Berechnung.
     */
    public static long fiboRecursive(final int n) {
        return n > 1 ? fiboRecursive(n - 1) + fiboRecursive(n - 2) : n;
    }

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        long start;
        long end;
        final int n = 42;
        final FibonacciTask task = new FibonacciTask(n);
        LOG.info("fibo(" + n + ") start...");
        start = System.nanoTime();
        long result = task.invoke();
        end = System.nanoTime();
        LOG.info("Conc. recursive = " + result);
        LOG.info("Conc. recursive : " + String.format("%,d", end - start) + " ns.");
        start = System.nanoTime();
        result = fiboIterative(n);
        end = System.nanoTime();
        LOG.info("Func. iterative = " + result);
        LOG.info("Func. iterative : " + String.format("%,d", end - start) + " ns.");
        start = System.nanoTime();
        result = fiboRecursive(n);
        end = System.nanoTime();
        LOG.info("Func. recursive = " + result);
        LOG.info("Func. recursive :  " + String.format("%,d", end - start) + " ns.");
    }
}
