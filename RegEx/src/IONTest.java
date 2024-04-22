import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IONTest {

    @Test
    void isValidIONJustion() {
        assertTrue(Solution.isValidION("ion"));
    }
    @Test
    void isValidIONaxion() {
        assertTrue(Solution.isValidION("axion"));
    }
    @Test
    void isValidIONscion() {
        assertTrue(Solution.isValidION("scion"));
    }
    @Test
    void isValidIONonion() {
        assertTrue(Solution.isValidION("onion"));
    }
    @Test
    void isValidIONLongerWord() {
        assertTrue(Solution.isValidION("devastation"));
    }
    @Test
    void isValidIONLongishWord() {
        assertTrue(Solution.isValidION("alation"));
    }
    @Test
    void isValidIONAnotherWord() {
        assertTrue(Solution.isValidION("oddwordsion"));
    }
    @Test
    void isValidIONMadeUpLongWord() {
        assertTrue(Solution.isValidION("abababababababababababion"));
    }

    /*------------------------------------------INVALID TESTS---------------------------------------------------------*/

    @Test
    void isInvalidIONSQLInjection() {
        assertFalse(Solution.isValidION("Robert'); DROP TABLE Students;--"));
    }
    @Test
    void isInvalidIONEmptyString() {
        assertFalse(Solution.isValidION(""));
    }
    @Test
    void isInvalidIONEvenWord() {
        assertFalse(Solution.isValidION("action"));
    }
    @Test
    void isInvalidIONNumbers() {
        assertFalse(Solution.isValidION("1ion1"));
    }
    @Test
    void isInvalidIONPunctuation() {
        assertFalse(Solution.isValidION("!!ion"));
    }
    @Test
    void isInvalidIONDoesntEndInion() {
        assertFalse(Solution.isValidION("lions"));
    }
    @Test
    void isInvalidIONStartsWithIon() {
        assertFalse(Solution.isValidION("ionic"));
    }
    @Test
    void isInvalidIONSpaceInWord() {
        assertFalse(Solution.isValidION("On ion"));
    }
}