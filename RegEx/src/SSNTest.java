import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SSNTest {

    @Test
    void isValidSSNDashes() {
        assertTrue(Solution.isValidSSN("123-45-6789"));
    }
    @Test
    void isValidSSNSpaces() {
        assertTrue(Solution.isValidSSN("123 45 6789"));
    }
    @Test
    void isValidSSNDashAndSpace() {
        assertTrue(Solution.isValidSSN("123-45 6789"));
    }
    @Test
    void isValidSSNSpaceAndDash() {
        assertTrue(Solution.isValidSSN("123 45-6789"));
    }
    @Test
    void isValidSSNOneDash() {
        assertTrue(Solution.isValidSSN("12345-6789"));
    }
    @Test
    void isValidSSNOneDash2() {
        assertTrue(Solution.isValidSSN("123-456789"));
    }
    @Test
    void isValidSSNOneSpace() {
        assertTrue(Solution.isValidSSN("12345 6789"));
    }
    @Test
    void isValidSSNOneSpace2() {
        assertTrue(Solution.isValidSSN("123 456789"));
    }
    @Test
    void isValidSSNNoDelimiters() {
        assertTrue(Solution.isValidSSN("123456789"));
    }

    /*--------------------------------------------INVALID TESTS-------------------------------------------------------*/
    @Test
    void isInvalidSSNZeros() {
        assertFalse(Solution.isValidSSN("123-00-1234"));
    }
    @Test
    void isInvalidSSNZeros2() {
        assertFalse(Solution.isValidSSN("123-01-0000"));
    }
    @Test
    void isInvalidSSNElDiablo() {
        assertFalse(Solution.isValidSSN("666-12-1234"));
    }
    @Test
    void isInvalidSSNLetters() {
        assertFalse(Solution.isValidSSN("Abcdefghij"));
    }
    @Test
    void isInvalidSSNTooManyNumbers() {
        assertFalse(Solution.isValidSSN("123456789012"));
    }
    @Test
    void isInvalidSSNTooFewNumbers() {
        assertFalse(Solution.isValidSSN("123-4-566"));
    }
    @Test
    void isInvalidSSNZeros3() {
        assertFalse(Solution.isValidSSN("000-12-1234"));
    }
    @Test
    void isInvalidSSNSQLInjection() {
        assertFalse(Solution.isValidSSN("Robert'); DROP TABLE Students;--"));
    }
}