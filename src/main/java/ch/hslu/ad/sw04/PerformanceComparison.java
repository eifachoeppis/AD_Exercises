package ch.hslu.ad.sw04;

import ch.hslu.ad.sw02.stack.ArrayStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.IntStream;

public class PerformanceComparison {
    static final int TEST_OBJECTS = 10000000;
    static final int ITERATIONS = 10;

    static String[] testData(int size) {
        return IntStream.range(0, size)
                .mapToObj((i) -> "String" + i)
                .toArray(count -> new String[count]);
    }

    public static void main(String[] args) throws Exception{
        long start = System.currentTimeMillis();
        String[] sampleData = testData(TEST_OBJECTS);
        long stop = System.currentTimeMillis();
        //System.out.println(stop - start);
        //    100'000         10'000'000
        // 0. run: 62         0. run: 1593
        // 1. run: 62         1. run: 1469
        // 2. run: 93         2. run: 1578
        // 3. run: 78         3. run: 1437
        // 4. run: 78         4. run: 1469
        // 5. run: 78         5. run: 1562
        // 6. run: 62         6. run: 1359
        // 7. run: 78         7. run: 1547
        // 8. run: 78         8. run: 1609
        // 9. run: 79         9. run: 1406

        for (int i = 0; i < ITERATIONS; i++){
            Stack<String> stack = new Stack<>();
            stack.ensureCapacity(TEST_OBJECTS);

            start = System.currentTimeMillis();
            for (String s : sampleData) {
                stack.push(s);
            }
            stop = System.currentTimeMillis();
            System.out.println(stop - start);
        }
        //    100'000         10'000'000
        // 0. run: 16         0. run: 188
        // 1. run: 16         1. run: 156
        // 2. run: 16         2. run: 156
        // 3. run: 0          3. run: 203
        // 4. run: 15         4. run: 140
        // 5. run: 16         5. run: 172
        // 6. run: 0          6. run: 156
        // 7. run: 16         7. run: 172
        // 8. run: 16         8. run: 156
        // 9. run: 15         9. run: 156

//        for (int i = 0; i < ITERATIONS; i++){
//            ArrayStack arrayStack = new ArrayStack(TEST_OBJECTS);
//
//            start = System.currentTimeMillis();
//            for (String s : sampleData) {
//                arrayStack.push(s);
//            }
//            stop = System.currentTimeMillis();
//            System.out.println(stop - start);
//        }
        //    100'000         10'000'000
        // 0. run: 0          0. run: 172
        // 1. run: 0          1. run: 171
        // 2. run: 0          2. run: 141
        // 3. run: 0          3. run: 125
        // 4. run: 16         4. run: 141
        // 5. run: 0          5. run: 140
        // 6. run: 0          6. run: 141
        // 7. run: 15         7. run: 125
        // 8. run: 16         8. run: 156
        // 9. run: 0          9. run: 125


//        for(int i = 0; i < ITERATIONS; i++){
//            Deque<String> deque = new ArrayDeque<>();
//            start = System.currentTimeMillis();
//            for (String s : sampleData){
//                deque.push(s);
//            }
//            stop = System.currentTimeMillis();
//            System.out.println(stop - start);
//        }
        //    100'000         10'000'000
        // 0. run: 0          0. run: 359
        // 1. run: 16         1. run: 344
        // 2. run: 0          2. run: 750
        // 3. run: 16         3. run: 594
        // 4. run: 0          4. run: 687
        // 5. run: 0          5. run: 375
        // 6. run: 0          6. run: 360
        // 7. run: 15         7. run: 421
        // 8. run: 0          8. run: 422
        // 9. run: 0          9. run: 485
    }
}
