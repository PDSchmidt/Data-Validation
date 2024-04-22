import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    void isValidPassword() {
        assertTrue(Solution.isValidPassword("!Abcd12345"));
    }
    @Test
    void isValidPassword2() {
        assertTrue(Solution.isValidPassword("BananaF0ster?"));
    }
    @Test
    void isValidPasswordLeetSpeak() {
        assertTrue(Solution.isValidPassword("L33tSp3aking."));
    }
    @Test
    void isValidPasswordLongerThanTen() {
        assertTrue(Solution.isValidPassword("ValidPassword123!"));
    }
    @Test
    void isValidPasswordManyPunctuation() {
        assertTrue(Solution.isValidPassword("123aB123!!!!!!!"));
    }
    @Test
    void isValidPasswordUWT() {
        assertTrue(Solution.isValidPassword("UWTac0ma!skewlBEANS"));
    }
    @Test
    void isValidPasswordEveryPunctuation() {
        assertTrue(Solution.isValidPassword(".?!.;:-[]{}’”123abcDEF"));
    }
    @Test
    void isValidPasswordSurroundedWithBrackets() {
        assertTrue(Solution.isValidPassword("{w0wSuchSecur3}"));
    }

    /*------------------------------------------------INVALID TESTS---------------------------------------------------*/

    @Test
    void isInvalidPasswordSQLInjection() {
        assertFalse(Solution.isValidPassword("Robert'); DROP TABLE Students;--"));
    }
    @Test
    void isInvalidPasswordEmptyString() {
        assertFalse(Solution.isValidPassword(""));
    }
    @Test
    void isInvalidPasswordShortLowerCaseA() {
        assertFalse(Solution.isValidPassword("aaa"));
    }
    @Test
    void isInvalidPasswordSimilarToValidButNoPunctuation() {
        assertFalse(Solution.isValidPassword("ValidPassword123"));
    }
    @Test
    void isInvalidPasswordNoLowerCase() {
        assertFalse(Solution.isValidPassword("AB123!!!!!YESSS"));
    }
    @Test
    void isInvalidPasswordThreeLowerCaseIdenticalInARow() {
        assertFalse(Solution.isValidPassword("AlmostValllid!123"));
    }
    @Test
    void isInvalidPasswordNoSpacesAllowed() {
        assertFalse(Solution.isValidPassword("No Spaces Allowed"));
    }
    @Test
    void isInvalidPasswordPassword() {
        assertFalse(Solution.isValidPassword("password"));
    }
}