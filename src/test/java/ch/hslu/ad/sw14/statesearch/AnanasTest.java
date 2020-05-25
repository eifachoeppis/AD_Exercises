package ch.hslu.ad.sw14.statesearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnanasTest {

    @Test
    void search_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> Ananas.stateSearch(null));
    }

    @Test
    void search_empty_not_found() {
        assertEquals(-1, Ananas.stateSearch(""));
    }

    @Test
    void search_without_ANANAS_not_found() {
        assertEquals(-1, Ananas.stateSearch("gugusgugus"));
    }

    @Test
    void search_shorter_than_ANANAS_not_found() {
        assertEquals(-1, Ananas.stateSearch("123"));
    }

    @Test
    void search_only_ANANAS_found() {
        assertEquals(0, Ananas.stateSearch("ANANAS"));
    }

    @Test
    void search_middle_ANANAS_found() {
        assertEquals(4, Ananas.stateSearch("0123ANANASxyz"));
    }

    @Test
    void search_end_ANANAS_found() {
        assertEquals(4, Ananas.stateSearch("0123ANANAS"));
    }

    @Test
    void search_ANANA_not_found() {
        assertEquals(-1, Ananas.stateSearch("0123ANANAxyz"));
    }
}