import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSZTest {

    @Test
    void isValidCityStateZipTacoma() {
        assertTrue(Solution.isValidCityStateZip("Tacoma, WA 98402"));
    }
    @Test
    void isValidCityStateZipSeattle() {
        assertTrue(Solution.isValidCityStateZip("Seattle, WA 98347"));
    }
    @Test
    void isValidCityStateZipTwoWordsCity() {
        assertTrue(Solution.isValidCityStateZip("Saint Louis, MO 63101"));
    }
    @Test
    void isValidCityStateZipAnchorage() {
        assertTrue(Solution.isValidCityStateZip("Anchorage, AK 99501"));
    }
    @Test
    void isValidCityStateZipTwoWordsCity2() {
        assertTrue(Solution.isValidCityStateZip("Beverly Hills, CA 90210"));
    }
    @Test
    void isValidCityStateZipChicago() {
        assertTrue(Solution.isValidCityStateZip("Chicago, IL 60606"));
    }
    @Test
    void isValidCityStateZipThreeWordsCity() {
        assertTrue(Solution.isValidCityStateZip("New York City, NY 10007"));
    }
    @Test
    void isValidCityStateZipPortland() {
        assertTrue(Solution.isValidCityStateZip("Portland, OR 97210"));
    }

    /*----------------------------------------------INVALID TESTS-----------------------------------------------------*/

    @Test
    void isInvalidCityStateZipEmptyString() {
        assertFalse(Solution.isValidCityStateZip(""));
    }
    @Test
    void isInvalidCityStateZipSQLInjection() {
        assertFalse(Solution.isValidCityStateZip("Robert'); DROP TABLE Students;--"));
    }
    @Test
    void isInvalidCityStateZipNoComma() {
        assertFalse(Solution.isValidCityStateZip("Tacoma WA 98402"));
    }
    @Test
    void isInvalidCityStateZipTooManyNumbers() {
        assertFalse(Solution.isValidCityStateZip("Tacoma, WA 984022"));
    }
    @Test
    void isInvalidCityStateZipJustNumbers() {
        assertFalse(Solution.isValidCityStateZip("98402"));
    }
    @Test
    void isInvalidCityStateZipNoZip() {
        assertFalse(Solution.isValidCityStateZip("Tacoma, WA"));
    }
    @Test
    void isInvalidCityStateZipStateNotAbbreviated() {
        assertFalse(Solution.isValidCityStateZip("Tacoma, Washington 98402"));
    }
    @Test
    void isInvalidCityStateZipStateDoesntExist() {
        assertFalse(Solution.isValidCityStateZip("11137 Banana BA"));
    }
}