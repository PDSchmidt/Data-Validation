import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void isValidNameStandard() {
        assertTrue(Solution.isValidName("Last, First, M"));
    }
    @Test
    void isValidNameNoMiddle() {
        assertTrue(Solution.isValidName("Last, First"));
    }
    @Test
    void isValidNameTwoMiddle() {
        assertTrue(Solution.isValidName("Last, First, MI"));
    }
    @Test
    void isValidNameHyphenInLast() {
        assertTrue(Solution.isValidName("Last-Last, First"));
    }
    @Test
    void isValidNameHyphenInBoth() {
        assertTrue(Solution.isValidName("Last-Last, First-First"));
    }
    @Test
    void isValidNameHyphenInFirstOnly() {
        assertTrue(Solution.isValidName("Last, First-Last, M"));
    }
    @Test
    void isValidNameTwoCapitalsInLast() {
        assertTrue(Solution.isValidName("McLast, First"));
    }
    @Test
    void isValidNameTwoCapitalsInFirst() {
        assertTrue(Solution.isValidName("Last, McFirst, M"));
    }

    /*-------------------------------------------INVALID TESTS--------------------------------------------------------*/

    @Test
    void isInvalidNameEmptyString() {
        assertFalse(Solution.isValidName(""));
    }
    @Test
    void isInvalidNameSQLInjection() {
        assertFalse(Solution.isValidName("Robert'); DROP TABLE Students;--"));
    }
    @Test
    void isInvalidNameSymbols() {
        assertFalse(Solution.isValidName("Las4$, NO(( ()L"));
    }
    @Test
    void isInvalidNameNoCommas() {
        assertFalse(Solution.isValidName("Last First Middle"));
    }
    @Test
    void isInvalidNameOnlyHyphens() {
        assertFalse(Solution.isValidName("Last-First-Middle"));
    }
    @Test
    void isInvalidNameOneCharEach() {
        assertFalse(Solution.isValidName("L, F, M"));
    }
    @Test
    void isInvalidNameUnderscores() {
        assertFalse(Solution.isValidName("Last_First_MI"));
    }
    @Test
    void isInvalidNameNoCap() {
        assertFalse(Solution.isValidName("last, first, m"));
    }
}