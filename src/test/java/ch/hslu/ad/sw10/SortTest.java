package ch.hslu.ad.sw10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    void insertionSortNull() {
        assertThrows(IllegalArgumentException.class, () -> Sort.insertionSort(null));
    }

    @Test
    void insertionSortEmpty() {
        int[] result = Sort.insertionSort(new int[0]);
        assertArrayEquals(new int[0], result);
    }

    @Test
    void insertionSortOneElement() {
        int[] result = Sort.insertionSort(new int[]{5});
        assertArrayEquals(new int[]{5}, result);
    }

    @Test
    void insertionSortTwoElements() {
        int[] result = Sort.insertionSort(new int[]{5, 3});
        assertArrayEquals(new int[]{3, 5}, result);
    }

    @Test
    void insertionSort() {
        int[] start = new int[]{9, 1, 7, 7, 8, 5};
        int[] expexted = new int[]{1, 5, 7, 7, 8, 9};
        int[] result = Sort.insertionSort(start);

        assertArrayEquals(expexted, result);
    }

    @Test
    void insertionSortAlreadySorted() {
        int[] start = new int[]{1, 4, 5};
        int[] expexted = new int[]{1, 4, 5};
        int[] result = Sort.insertionSort(start);

        assertArrayEquals(expexted, result);
    }

    @Test
    void insertionSortReverseOrder() {
        int[] start = new int[]{5, 4, 1};
        int[] expexted = new int[]{1, 4, 5};
        int[] result = Sort.insertionSort(start);

        assertArrayEquals(expexted, result);
    }

    @Test
    void selectionSortNull() {
        assertThrows(IllegalArgumentException.class, () -> Sort.selectionSort(null));
    }

    @Test
    void selectionSortEmpty() {
        int[] result = Sort.selectionSort(new int[0]);
        assertArrayEquals(new int[0], result);
    }

    @Test
    void selectionSortOneElement() {
        int[] result = Sort.selectionSort(new int[]{5});
        assertArrayEquals(new int[]{5}, result);
    }

    @Test
    void selectionSortTwoElements() {
        int[] result = Sort.selectionSort(new int[]{5, 3});
        assertArrayEquals(new int[]{3, 5}, result);
    }

    @Test
    void selectionSort() {
        int[] start = new int[]{9, 1, 7, 7, 8, 5};
        int[] expexted = new int[]{1, 5, 7, 7, 8, 9};
        int[] result = Sort.selectionSort(start);

        assertArrayEquals(expexted, result);
    }

    @Test
    void selectionSortAlreadySorted() {
        int[] start = new int[]{1, 4, 5};
        int[] expexted = new int[]{1, 4, 5};
        int[] result = Sort.selectionSort(start);

        assertArrayEquals(expexted, result);
    }

    @Test
    void selectionSortReverseOrder() {
        int[] start = new int[]{5, 4, 1};
        int[] expexted = new int[]{1, 4, 5};
        int[] result = Sort.selectionSort(start);

        assertArrayEquals(expexted, result);
    }

    @Test
    void bubbleSortNull() {
        assertThrows(IllegalArgumentException.class, () -> Sort.bubbleSort(null));
    }

    @Test
    void bubbleSortEmpty() {
        int[] result = Sort.bubbleSort(new int[0]);
        assertArrayEquals(new int[0], result);
    }

    @Test
    void bubbleSortOneElement() {
        int[] result = Sort.bubbleSort(new int[]{5});
        assertArrayEquals(new int[]{5}, result);
    }

    @Test
    void bubbleSortTwoElements() {
        int[] result = Sort.bubbleSort(new int[]{5, 3});
        assertArrayEquals(new int[]{3, 5}, result);
    }

    @Test
    void bubbleSort() {
        int[] start = new int[]{9, 1, 7, 7, 8, 5};
        int[] expexted = new int[]{1, 5, 7, 7, 8, 9};
        int[] result = Sort.bubbleSort(start);

        assertArrayEquals(expexted, result);
    }

    @Test
    void bubbleSortAlreadySorted() {
        int[] start = new int[]{1, 4, 5};
        int[] expexted = new int[]{1, 4, 5};
        int[] result = Sort.bubbleSort(start);

        assertArrayEquals(expexted, result);
    }

    @Test
    void bubbleSortReverseOrder() {
        int[] start = new int[]{5, 4, 1};
        int[] expexted = new int[]{1, 4, 5};
        int[] result = Sort.bubbleSort(start);

        assertArrayEquals(expexted, result);
    }

    @Test
    void bubbleSort2Null() {
        assertThrows(IllegalArgumentException.class, () -> Sort.bubbleSort2(null));
    }

    @Test
    void bubbleSort2Empty() {
        int[] result = Sort.bubbleSort2(new int[0]);
        assertArrayEquals(new int[0], result);
    }

    @Test
    void bubbleSort2OneElement() {
        int[] result = Sort.bubbleSort2(new int[]{5});
        assertArrayEquals(new int[]{5}, result);
    }

    @Test
    void bubbleSort2TwoElements() {
        int[] result = Sort.bubbleSort2(new int[]{5, 3});
        assertArrayEquals(new int[]{3, 5}, result);
    }

    @Test
    void bubbleSort2() {
        int[] start = new int[]{9, 1, 7, 7, 8, 5};
        int[] expexted = new int[]{1, 5, 7, 7, 8, 9};
        int[] result = Sort.bubbleSort2(start);

        assertArrayEquals(expexted, result);
    }

    @Test
    void bubbleSort2AlreadySorted() {
        int[] start = new int[]{1, 4, 5};
        int[] expexted = new int[]{1, 4, 5};
        int[] result = Sort.bubbleSort2(start);

        assertArrayEquals(expexted, result);
    }

    @Test
    void bubbleSort2ReverseOrder() {
        int[] start = new int[]{5, 4, 1};
        int[] expexted = new int[]{1, 4, 5};
        int[] result = Sort.bubbleSort2(start);

        assertArrayEquals(expexted, result);
    }
}