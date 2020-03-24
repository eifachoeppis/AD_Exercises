package ch.hslu.ad.sw01;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class AllocationTest {

    @Test
    void compareGreaterTest(){
        Allocation testee = new Allocation(1, 5);
        Allocation second = new Allocation(0, 5);
        assertEquals(1, testee.compareTo(second));
    }

    @Test
    void compareSmallerTest(){
        Allocation testee = new Allocation(0, 5);
        Allocation second = new Allocation(1, 5);
        assertEquals(-1, testee.compareTo(second));
    }

    @Test
    void compareEqualsTest(){
        Allocation testee = new Allocation(0, 5);
        Allocation second = new Allocation(0, 5);
        assertEquals(0, testee.compareTo(second));
    }

    @Test
    void equalsContract(){
        EqualsVerifier.forClass(Allocation.class).verify();
    }
}