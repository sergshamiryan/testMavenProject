package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.Race.HOBBIT;
import static org.junit.jupiter.api.Assertions.*;

public class DataServiceTest {

    DataService dataService;

    @BeforeEach
    void initializeDataService() {
        dataService = new DataService();
    }

    @Test
    void ensureThatInitializationOfTolkeinCharactorsWorks() {
        TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
        // TODO check that age is 33
        assertEquals(frodo.age, 33, "Frodo should be 33");
        // TODO check that name is "Frodo"
        assertEquals(frodo.getName(), "Frodo", "Frodos charachter has wrong name");
        // TODO check that name is not "Frodon"
        assertNotEquals(frodo.getName(), "frodon", "Frodos name should not be Frodon");
    }

    @Test
    void ensureThatEqualsWorksForCharaters() {
        Object jake = new TolkienCharacter("Jake", 43, HOBBIT);
        Object jakeClone = new TolkienCharacter("Jake", 12, HOBBIT);
        Object sameJake = jake;
        // jake is equal to sameJake
        assertEquals(jake, sameJake, "Not equal Jake");
        // jake is not equal to jakeClone
        assertNotEquals(jake, jakeClone, "Jake is equal to JakeClone");
    }

    @Test
    void checkInheritance() {
        TolkienCharacter tolkienCharacter = dataService.getFellowship().get(0);
        // TODO check that tolkienCharacter.getClass is not a movie class
        assertFalse(Movie.class.isAssignableFrom(tolkienCharacter.getClass()));
    }

    @Test
    void ensureFellowShipCharacterAccessByNameReturnsNullForUnknownCharacter() {
        // TODO imlement a check that dataService.getFellowshipCharacter returns null for an
        TolkienCharacter fellowshipCharacter = dataService.getFellowshipCharacter("Lars");
        assertNull(fellowshipCharacter);
    }

    @Test
    void ensureFellowShipCharacterAccessByNameWorksGivenCorrectNameIsGiven() {
        // TODO imlement a check that dataService.getFellowshipCharacter returns a fellow for an
        // existing felllow, e.g. "Frodo"
        assertNotNull(dataService.getFellowshipCharacter("Frodo"));
    }


}
