package ch.hslu.ad.sw10;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public final class DemoSort {

    private DemoSort() {

    }

    private static final int SIZE = 100_000;
    private static final int ITERATIONS = 10;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] sorted = initializeSorted();
        int[] reverseSorted = initializeReverseSorted();
        int[] random = initializeRandom();

        System.out.println("insertionSort, sorted: " + measure(sorted, Sort::insertionSort) + "ms.");
        System.out.println("insertionSort, reverseSorted: " + measure(reverseSorted, Sort::insertionSort) + "ms.");
        System.out.println("insertionSort, random: " + measure(random, Sort::insertionSort) + "ms.");
        System.out.println("selectionSort, sorted: " + measure(sorted, Sort::selectionSort) + "ms.");
        System.out.println("selectionSort, reverseSorted: " + measure(reverseSorted, Sort::selectionSort) + "ms.");
        System.out.println("selectionSort, random: " + measure(random, Sort::selectionSort) + "ms.");
        System.out.println("bubbleSort, sorted: " + measure(sorted, Sort::bubbleSort) + "ms.");
        System.out.println("bubbleSort, reverseSorted: " + measure(reverseSorted, Sort::bubbleSort) + "ms.");
        System.out.println("bubbleSort, random: " + measure(random, Sort::bubbleSort) + "ms.");
        System.out.println("bubbleSort2, sorted: " + measure(sorted, Sort::bubbleSort2) + "ms.");
        System.out.println("bubbleSort2, reverseSorted: " + measure(reverseSorted, Sort::bubbleSort2) + "ms.");
        System.out.println("bubbleSort2, random: " + measure(random, Sort::bubbleSort2) + "ms.");
    }

    private static double measure(int[] numbers, Function<int[], int[]> sortFunction){
        ArrayList<Long> measurements = new ArrayList<>();

        for (int i=0;i<ITERATIONS;i++){
            long start = System.currentTimeMillis();
            int[] sorted = sortFunction.apply(numbers);
            long end = System.currentTimeMillis();
            measurements.add(end - start);
        }

        return measurements.stream().mapToLong(m -> m).average().orElse(-1);
    }

    private static int[] initializeSorted() {
        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }

    private static int[] initializeReverseSorted() {
        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[SIZE - i - 1] = i + 1;
        }
        return numbers;
    }

    private static int[] initializeRandom(){
        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = RANDOM.nextInt();
        }
        return numbers;
    }
}
