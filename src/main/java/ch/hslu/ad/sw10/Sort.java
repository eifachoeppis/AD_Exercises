package ch.hslu.ad.sw10;

import ch.hslu.ad.sw02.stack.ArrayStack;

import java.util.Arrays;

public final class Sort {
    private Sort() {

    }

    public static int[] insertionSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }

        int[] copy = Arrays.copyOf(array, array.length);

        int element;
        int j;
        for (int i = 1; i < copy.length; i++) {
            element = copy[i];
            j = i;
            while ((j > 0) && (copy[j - 1] > element)) {
                copy[j] = copy[j - 1];
                j--;
            }
            copy[j] = element;
        }

        return copy;
    }

    public static int[] selectionSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }

        int[] copy = Arrays.copyOf(array, array.length);

        int element;
        int j;
        int index;
        for (int i = 0; i < copy.length; i++) {
            element = copy[i];
            index = i;
            for (j = i + 1; j < copy.length; j++) {
                if (copy[j] < element) {
                    element = copy[j];
                    index = j;
                }
            }
            copy[index] = copy[i];
            copy[i] = element;
        }

        return copy;
    }

    public static int[] bubbleSort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }

        int[] copy = Arrays.copyOf(array, array.length);

        int j;
        int element;
        for (int i = 1; i < copy.length; i++) {
            for (j = 1; j <= copy.length - i; j++) {
                if (copy[j] < copy[j - 1]) {
                    element = copy[j];
                    copy[j] = copy[j - 1];
                    copy[j - 1] = element;
                }
            }
        }

        return copy;
    }

    public static int[] bubbleSort2(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }

        int[] copy = Arrays.copyOf(array, array.length);

        int j;
        int element;
        boolean swapped = false;
        for (int i = 1; i < copy.length; i++) {
            for (j = 1; j <= copy.length - i; j++) {
                if (copy[j] < copy[j - 1]) {
                    element = copy[j];
                    copy[j] = copy[j - 1];
                    copy[j - 1] = element;
                    swapped = true;
                }
            }

            if (!swapped) {
                return copy;
            }
        }

        return copy;
    }

    public static char[] quickSort(char[] array){
        if (array == null){
            throw new IllegalArgumentException("Array must not be null");
        }

        char[] copy = Arrays.copyOf(array, array.length);
        if (copy.length > 1){
            quickSort(copy, 0, copy.length - 1);
        }

        return copy;
    }

    public static int[] quickSort(int[] array){
        if (array == null){
            throw new IllegalArgumentException("Array must not be null");
        }

        int[] copy = Arrays.copyOf(array, array.length);
        if (copy.length > 1){
            quickSort(copy, 0, copy.length - 1);
        }

        return copy;
    }

    private static void quickSort(final char[] arrayToSort, final int left, final int right) {
        int up = left;
        int down = right - 1;
        char separatingElement = arrayToSort[right];
        boolean allChecked = false;
        do {
            while (arrayToSort[up] < separatingElement) {
                up++;
            }
            while (arrayToSort[down] > separatingElement && down > up) {
                down--;
            }
            if (down > up) {
                exchange(arrayToSort, up, down);
                up++;
                down--;
            } else {
                allChecked = true;
            }
        } while (!allChecked);
        exchange(arrayToSort, up, right);
        if (left < up - 1) {
            quickSort(arrayToSort, left, up - 1);
        }
        if (up + 1 < right) {
            quickSort(arrayToSort, up + 1, right);
        }
    }

    private static void quickSort(final int[] arrayToSort, final int left, final int right) {
        int up = left;
        int down = right - 1;
        int separatingElement = arrayToSort[right];
        boolean allChecked = false;
        do {
            while (arrayToSort[up] < separatingElement) {
                up++;
            }
            while (arrayToSort[down] > separatingElement && down > up) {
                down--;
            }
            if (down > up) {
                exchange(arrayToSort, up, down);
                up++;
                down--;
            } else {
                allChecked = true;
            }
        } while (!allChecked);
        exchange(arrayToSort, up, right);
        if (left < up - 1) {
            quickSort(arrayToSort, left, up - 1);
        }
        if (up + 1 < right) {
            quickSort(arrayToSort, up + 1, right);
        }
    }

    private static void exchange(final char[] arrayToSort, final int firstIndex, final int secondIndex) {
        char temp;
        temp = arrayToSort[firstIndex];
        arrayToSort[firstIndex] = arrayToSort[secondIndex];
        arrayToSort[secondIndex] = temp;
    }

    private static void exchange(final int[] arrayToSort, final int firstIndex, final int secondIndex) {
        int temp;
        temp = arrayToSort[firstIndex];
        arrayToSort[firstIndex] = arrayToSort[secondIndex];
        arrayToSort[secondIndex] = temp;
    }
}
