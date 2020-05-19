package ch.hslu.ad.sw13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordProblemTest {

    @Test
    void isWordLanguage_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> WordProblem.isWordLanguage(null));
    }

    @Test
    void isWordLanguage_empty_false() {
        assertFalse(WordProblem.isWordLanguage(""));
    }

    @Test
    void isWordLanguage_0_true() {
        assertTrue(WordProblem.isWordLanguage("0"));
    }

    @Test
    void isWordLanguage_010_true() {
        assertTrue(WordProblem.isWordLanguage("010"));
    }

    @Test
    void isWordLanguage_0101110_true() {
        assertTrue(WordProblem.isWordLanguage("0101110"));
    }

    @Test
    void isWordLanguage_0101010_true() {
        assertTrue(WordProblem.isWordLanguage("0101010"));
    }

    @Test
    void isWordLanguage_1_false() {
        assertFalse(WordProblem.isWordLanguage("1"));
    }

    @Test
    void isWordLanguage_01111010_false() {
        assertFalse(WordProblem.isWordLanguage("01111010"));
    }

    @Test
    void isWordLanguage_111111_false() {
        assertFalse(WordProblem.isWordLanguage("111111"));
    }

    @Test
    void isWordLanguage_0011001100_false() {
        assertFalse(WordProblem.isWordLanguage("0011001100"));
    }

    @Test
    void isWordLanguage_123_false() {
        assertFalse(WordProblem.isWordLanguage("123"));
    }

}