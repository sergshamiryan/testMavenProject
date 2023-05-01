package org.example.junit;

import org.example.junit.DataService;
import org.example.junit.Movie;
import org.example.junit.Ring;
import org.example.junit.TolkienCharacter;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.example.junit.Race.*;
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
        TolkienCharacter fellowshipCharacter = dataService.getFellowshipCharacter("Aragorn");
        assertNotNull(fellowshipCharacter);
    }

    @Test
    void ensureThatFrodoAndGandalfArePartOfTheFellowsip() {

        List<TolkienCharacter> fellowship = dataService.getFellowship();
        TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
        TolkienCharacter gandalf = new TolkienCharacter("Gandalf", 2020, MAIA);

        assertTrue(fellowship.contains(frodo));
        assertTrue(fellowship.contains(gandalf));
    }

    @Test
    void ensureThatOneRingBearerIsPartOfTheFellowship() {

        List<TolkienCharacter> fellowship = dataService.getFellowship();
        // TODO test that at least one ring bearer is part of the fellowship
        Map<Ring, TolkienCharacter> bearers = dataService.getRingBearers();
        TolkienCharacter tolkienCharacter = bearers.get(Ring.oneRing);

        assertTrue(fellowship.contains(tolkienCharacter));
    }

    @Tag("slow")
    @DisplayName("Minimal stress testing: run this test 1000 times to ")
    @RepeatedTest(1000)
    void ensureThatWeCanRetrieveFellowshipMultipleTimes() {
        dataService = new DataService();
        assertNotNull(dataService.getFellowship());
    }

    @Test
    void ensureOrdering() {
        List<TolkienCharacter> fellowship = dataService.getFellowship();
        // ensure that the order of the fellowship is:
        // frodo, sam, merry,pippin, gandalf,legolas,gimli,aragorn,boromir
        assertEquals(fellowship.get(0), dataService.getFellowshipCharacter("Frodo"));
    }

    @Test
    void ensureAge() {
        List<TolkienCharacter> fellowship = dataService.getFellowship();
        // TODO test ensure that all hobbits and men are younger than 100 years
        // TODO also ensure that the elfs, dwars the maia are all older than 100 years
        fellowship.stream()
                .filter((n) -> n.getRace().equals(HOBBIT) || n.getRace().equals(MAN))
                .allMatch((n) -> n.age < 100);
    }

    @Test
    void ensureThatFellowsStayASmallGroup() {
        List<TolkienCharacter> fellowship = dataService.getFellowship();
        assertThrows(IndexOutOfBoundsException.class, () -> fellowship.get(20));
    }

    @Test
    void assertTimout(){
        assertTimeout(Duration.ofMillis(3000),() -> dataService.update());
    }


    @Test
    @DisplayName("Ensure that access to the fellowship throws exception outside the valid range")
    void exceptionTesting() {
        DataService dataService = new DataService();
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> dataService.getFellowship().get(20));
        assertEquals("Index 20 out of bounds for length 9", exception.getMessage());
    }

    @Test
    public void ensureThatAgeMustBeLargerThanZeroViaSetter() {
        TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
        // use assertThrows() rule to check that the message is:
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,() -> frodo.setAge(-1));
        assertEquals("Age is not allowed to be smaller than zero",ex.getMessage());
        // Age is not allowed to be smaller than zero
    }

    @Test
    public void testThatAgeMustBeLargerThanZeroViaConstructor() {
        // use assertThrows() rule to check that an IllegalArgumentException exception is thrown and
        // that the message is:
        // "Age is not allowed to be smaller than zero"
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,() -> new TolkienCharacter("Frodo", -1, HOBBIT));
        assertEquals("Age is not allowed to be smaller than zero",ex.getMessage());
    }

}
