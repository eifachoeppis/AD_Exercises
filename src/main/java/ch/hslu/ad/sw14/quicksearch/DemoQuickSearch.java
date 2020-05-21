package ch.hslu.ad.sw14.quicksearch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

public class DemoQuickSearch {

    private static final Logger LOG = LogManager.getLogger(DemoQuickSearch.class);
    private static final int ITERATIONS = 10;
    private static final Random random = new Random();

    private DemoQuickSearch() {

    }

    public static void main(String[] args) throws IOException {
        final Path pathGugus = Path.of("c:", "temp", "gugus.txt");
        final Path pathRandom = Path.of("c:", "temp", "random.txt");
        createGugusFile(pathGugus);
        createRandomFile(pathRandom);

        final String gugusText = Files.readString(pathGugus);
        double average = measure(() -> QuickSearch.quickSearch(gugusText, "gugus"));
        LOG.info("gugus quickSearch: found in " + String.format("%,.2f", average) + " ms.");
        average = measure(() -> QuickSearch.quickSearchOptimalMismatch(gugusText, "gugus"));
        LOG.info("gugus optimalMismatch: found in " + String.format("%,.2f", average) + " ms.");

        String randomText = Files.readString(pathRandom);
        average = measure(() -> QuickSearch.quickSearch(randomText, "gugus"));
        LOG.info("random quickSearch: found in " + String.format("%,.2f", average) + " ms.");
        average = measure(() -> QuickSearch.quickSearchOptimalMismatch(randomText, "gugus"));
        LOG.info("random optimalMismatch: found in " + String.format("%,.2f", average) + " ms.");
    }

    private static double measure(Runnable operation) {
        ArrayList<Long> measurements = new ArrayList<>();

        for (int i = 0; i < ITERATIONS; i++) {
            long start = System.nanoTime();
            operation.run();
            long end = System.nanoTime();
            measurements.add((end - start) / 1_000_000);
        }

        return measurements.stream()
                .mapToLong(m -> m)
                .average()
                .orElse(-1);
    }

    private static void createGugusFile(Path path) throws IOException {
        Files.write(path, "gugu".repeat(100000000).getBytes());
    }

    private static void createRandomFile(Path path) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100000000 * 3; i++) {
            builder.append((char) random.nextInt(256));
        }
        Files.write(path, builder.toString().getBytes());
    }
}
