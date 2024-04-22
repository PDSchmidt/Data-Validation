import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MilitaryTest {

    @Test
    void isValidMilitaryTimeOHundred() {
        assertTrue(Solution.isValidMilitaryTime("0000"));
    }
    @Test
    void isValidMilitaryTime2359() {
        assertTrue(Solution.isValidMilitaryTime("2359"));
    }
    @Test
    void isValidMilitaryTime1200() {
        assertTrue(Solution.isValidMilitaryTime("1200"));
    }
    @Test
    void isValidMilitaryTime0059() {
        assertTrue(Solution.isValidMilitaryTime("0059"));
    }
    @Test
    void isValidMilitaryTime0800() {
        assertTrue(Solution.isValidMilitaryTime("0800"));
    }
    @Test
    void isValidMilitaryTime1111() {
        assertTrue(Solution.isValidMilitaryTime("1111"));
    }
    @Test
    void isValidMilitaryTime1630() {
        assertTrue(Solution.isValidMilitaryTime("1630"));
    }
    @Test
    void isValidMilitaryTime1700OClockSomewhere() {
        assertTrue(Solution.isValidMilitaryTime("1700"));
    }

    /*------------------------------------------INVALID TESTS---------------------------------------------------------*/

    @Test
    void isInvalidMilitaryTimeEmptyString() {
        assertFalse(Solution.isValidMilitaryTime(""));
    }
    @Test
    void isInvalidMilitaryTimeSQLInjection() {
        assertFalse(Solution.isValidMilitaryTime("Robert'); DROP TABLE Students;--"));
    }
    @Test
    void isInvalidMilitaryTimeColon() {
        assertFalse(Solution.isValidMilitaryTime("12:00"));
    }
    @Test
    void isInvalidMilitaryTimeMinuteTooHigh() {
        assertFalse(Solution.isValidMilitaryTime("0060"));
    }
    @Test
    void isInvalidMilitaryTimeHourTooHigh() {
        assertFalse(Solution.isValidMilitaryTime("2500"));
    }
    @Test
    void isInvalidMilitaryTime2400SameAs0000() {
        assertFalse(Solution.isValidMilitaryTime("2400"));
    }
    @Test
    void isInvalidMilitaryTimeAMTackedOn() {
        assertFalse(Solution.isValidMilitaryTime("0100am"));
    }
    @Test
    void isInvalidMilitaryTimeNoLeadingZero() {
        assertFalse(Solution.isValidMilitaryTime("159"));
    }
}