package ch.hslu.ad.sw14.quicksearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSearchTest {

    @Test
    void quickSearch_text_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> QuickSearch.quickSearch(null, "gugus"));
    }

    @Test
    void quickSearch_pattern_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> QuickSearch.quickSearch("gugus", null));
    }

    @Test
    void quickSearch_pattern_bigger_than_text() {
        assertEquals(-1, QuickSearch.quickSearch("123", "gugus"));
    }

    @Test
    void quickSearch_text_empty_notFound() {
        assertEquals(-1, QuickSearch.quickSearch("", "gugus"));
    }

    @Test
    void quickSearch_pattern_empty_zero() {
        assertEquals(0, QuickSearch.quickSearch("gugus", ""));
    }

    @Test
    void quickSearch_text_contains_pattern_success() {
        assertEquals(3, QuickSearch.quickSearch("abcgugusasdf", "gugus"));
    }

    @Test
    void quickSearch_text_not_contains_pattern_notFound() {
        assertEquals(-1, QuickSearch.quickSearch("abc123xyz", "gugus"));
    }

    @Test
    void quickSearchOptimalMismatch_text_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> QuickSearch.quickSearchOptimalMismatch(null, "gugus"));
    }

    @Test
    void quickSearchOptimalMismatch_pattern_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> QuickSearch.quickSearchOptimalMismatch("gugus", null));
    }

    @Test
    void quickSearchOptimalMismatch_pattern_bigger_than_text() {
        assertEquals(-1, QuickSearch.quickSearchOptimalMismatch("123", "gugus"));
    }

    @Test
    void quickSearchOptimalMismatch_text_empty_notFound() {
        assertEquals(-1, QuickSearch.quickSearchOptimalMismatch("", "gugus"));
    }

    @Test
    void quickSearchOptimalMismatch_pattern_empty_zero() {
        assertEquals(0, QuickSearch.quickSearchOptimalMismatch("gugus", ""));
    }

    @Test
    void quickSearchOptimalMismatch_text_contains_pattern_success() {
        assertEquals(3, QuickSearch.quickSearchOptimalMismatch("abcgugusasdf", "gugus"));
    }

    @Test
    void quickSearchOptimalMismatch_text_not_contains_pattern_notFound() {
        assertEquals(-1, QuickSearch.quickSearchOptimalMismatch("abc123xyz", "gugus"));
    }
}