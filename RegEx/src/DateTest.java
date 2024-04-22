import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void isValidDateStandard() {
        assertTrue(Solution.isValidDate("07-24-1990"));
    }
    @Test
    void isValidDateLowYear() {
        assertTrue(Solution.isValidDate("01-31-0001"));
    }
    @Test
    void isValidDateLeapYear() {
        assertTrue(Solution.isValidDate("02-29-2024"));
    }
    @Test
    void isValidDateNonLeapYear() {
        assertTrue(Solution.isValidDate("02-28-2023"));
    }
    @Test
    void isValidDateMaxYear() {
        assertTrue(Solution.isValidDate("12/30/9999"));
    }
    @Test
    void isValidDateSlashes() {
        assertTrue(Solution.isValidDate("02/28/2024"));
    }
    @Test
    void isValidDateSlashesLeapYear() {
        assertTrue(Solution.isValidDate("02/29/2024"));
    }
    @Test
    void isValidDateSlashesRandom() {
        assertTrue(Solution.isValidDate("07/31/5678"));
    }

    /*--------------------------------------------INVALID TESTS-------------------------------------------------------*/

    @Test
    void isInvalidDateEmptyString() {
        assertFalse(Solution.isValidDate(""));
    }
    @Test
    void isInvalidDateSQLInjection() {
        assertFalse(Solution.isValidDate("Robert'); DROP TABLE Students;--"));
    }
    @Test
    void isInvalidDateNotLeapYearSlashes() {
        assertFalse(Solution.isValidDate("02/29/2023"));
    }
    @Test
    void isInvalidDateNotLeapYearDashes() {
        assertFalse(Solution.isValidDate("02-29-2023"));
    }
    @Test
    void isInvalidDateNoDelimiters() {
        assertFalse(Solution.isValidDate("02201999"));
    }
    @Test
    void isInvalidDateTooManyNumbers() {
        assertFalse(Solution.isValidDate("0022020000"));
    }
    @Test
    void isInvalidDateInvalidSymbolUnderscore() {
        assertFalse(Solution.isValidDate("02_20_1999"));
    }
    @Test
    void isInvalidDateDayMonthNotInRange() {
        assertFalse(Solution.isValidDate("20/32/1998"));
    }
}