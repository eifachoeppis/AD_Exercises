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
package ch.hslu.ad.sw12.quicksort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * Codevorlage zu RecursiveAction für die Sortierung eines int-Arrays.
 */
@SuppressWarnings("serial")
public final class QuicksortTask extends RecursiveAction {

    private static final int THRESHOLD = 150_000_000;
    private final int[] array;
    private final int min;
    private final int max;

    /**
     * Erzeugt einen Array-Sortier Task.
     *
     * @param array Interger-Array.
     */
    public QuicksortTask(int[] array) {
        this(array, 0, array.length - 1);
    }

    private QuicksortTask(final int[] array, final int min, final int max) {
        this.array = array;
        this.min = min;
        this.max = max;
    }

    @Override
    protected void compute() {
        if (max - min < THRESHOLD) {
            Arrays.sort(array, min, max + 1);
        } else {
            int up = min;
            int down = max - 1;
            int separatingElement = array[max];
            boolean allChecked = false;
            do {
                while (array[up] < separatingElement) {
                    up++;
                }
                while (array[down] > separatingElement && down > up) {
                    down--;
                }
                if (down > up) {
                    exchange(up, down);
                    up++;
                    down--;
                } else {
                    allChecked = true;
                }
            } while (!allChecked);
            exchange(up, max);
            ArrayList<RecursiveAction> recursiveActions = new ArrayList<>();
            if (min < up - 1) {
                recursiveActions.add(new QuicksortTask(array, min, up - 1));
            }
            if (up + 1 < max) {
                recursiveActions.add(new QuicksortTask(array, up + 1, max));
            }
            invokeAll(recursiveActions);
        }
    }

    private void exchange(int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
