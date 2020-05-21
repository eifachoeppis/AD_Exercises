package ch.hslu.ad.sw14.quicksearch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class QuickSearch {

    private static final Logger LOG = LogManager.getLogger(QuickSearch.class);

    private QuickSearch() {

    }

    public static int quickSearch(final String text, final String pattern) {
        if (text == null) {
            throw new IllegalArgumentException("Text must not be null.");
        }
        if (pattern == null) {
            throw new IllegalArgumentException("Pattern must not be null.");
        }
        if (text.equals("")) {
            return -1;
        }
        if (pattern.equals("")) {
            return 0;
        }

        final int n = text.length();
        final int m = pattern.length();
        final int range = 256;
        final int[] shift = new int[range];

        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }
        for (int i = 0; i < m; i++) {
            shift[pattern.charAt(i)] = m - i;
        }

        int i = 0;
        int j = 0;
        do {
            if (text.charAt(i + j) == pattern.charAt(j)) {
                j++;
            } else {
                if ((i + m) < n) {
                    i += shift[text.charAt(i + m)];
                    j = 0;
                } else {
                    break;
                }
            }
        } while ((j < m) && ((i + m) <= n));

        if (j == m) {
            return i;
        } else {
            return -1;
        }
    }

    public static int quickSearchOptimalMismatch(final String text, final String pattern) {
        if (text == null) {
            throw new IllegalArgumentException("Text must not be null.");
        }
        if (pattern == null) {
            throw new IllegalArgumentException("Pattern must not be null.");
        }
        if (text.equals("")) {
            return -1;
        }
        if (pattern.equals("")) {
            return 0;
        }

        final int n = text.length();
        final int m = pattern.length();
        final int range = 256;
        final int[] shift = new int[range];
        final char[] optimalMismatchTable = pattern.toCharArray();
        // LOG.info("initial table: " + Arrays.toString(optimalMismatchTable));
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        }
        for (int i = 0; i < m; i++) {
            shift[pattern.charAt(i)] = m - i;
        }

        int i = 0;
        int j = 0;
        do {
            if (text.charAt(i + j) == optimalMismatchTable[j]) {
                j++;
            } else {
                if ((i + m) < n) {
                    if (j > 0 && optimalMismatchTable[j - 1] != optimalMismatchTable[j]) {
                        char temp = optimalMismatchTable[j - 1];
                        optimalMismatchTable[j - 1] = optimalMismatchTable[j];
                        optimalMismatchTable[j] = temp;
                        // LOG.info("table changed: " + Arrays.toString(optimalMismatchTable));
                    }
                    i += shift[text.charAt(i + m)];
                    j = 0;
                } else {
                    break;
                }
            }
        } while ((j < m) && ((i + m) <= n));

        if (j == m) {
            return i;
        } else {
            return -1;
        }
    }
}
