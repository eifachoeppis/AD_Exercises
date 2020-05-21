package ch.hslu.ad.sw14.kmp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class KmpAlgorithmus {

    private static final Logger LOG = LogManager.getLogger(KmpAlgorithmus.class);

    private KmpAlgorithmus() {

    }

    private static int[] initNext(final String pattern) {
        final int m = pattern.length();
        final int[] next = new int[m];
        int i = 0;
        int j = -1;
        next[0] = -1;
        do {
            if ((j == -1) || (pattern.charAt(i) == pattern.charAt(j))) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        } while (i < (m - 1));
        return next;
    }

    public static int kmpSearch(final String text, final String pattern) {
        final int n = text.length();
        final int m = pattern.length();
        int i = 0;
        int j = 0;
        int[] next = initNext(pattern);
        LOG.info(Arrays.toString(next));
        do {
            if ((j == -1) || (text.charAt(i) == pattern.charAt(j))) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        } while ((j < m) && (i < n));
        if (j == m) {
            return (i - m);
        } else {
            return -1;
        }
    }
}
