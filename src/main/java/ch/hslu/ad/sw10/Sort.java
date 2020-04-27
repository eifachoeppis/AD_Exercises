package ch.hslu.ad.sw10;

import ch.hslu.ad.sw02.stack.ArrayStack;

import java.util.Arrays;

public final class Sort {
    private Sort() {

    }

    public int[] insertionSort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);

        int elt;
        int j;
        for (int i = 1; i < copy.length; i++) {
            elt = copy[i];
            j = i;
            while ((j > 0) && (copy[j - 1] > elt)) {
                copy[j] = copy[j - 1];
                j--;
            }
            copy[j] = elt;
        }

        return copy;
    }


}
