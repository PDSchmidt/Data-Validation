import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {

    @Test
    void isValidPhoneParensSpaceDash() {
        assertTrue(Solution.isValidPhone("(253) 456-7890"));
    }
    @Test
    void isValidPhoneNoParensSpaces() {
        assertTrue(Solution.isValidPhone("253 456 7890"));
    }
    @Test
    void isValidPhoneNoDelimiters() {
        assertTrue(Solution.isValidPhone("2534567890"));
    }
    @Test
    void isValidPhoneParensOneSpace() {
        assertTrue(Solution.isValidPhone("(253)456 7890"));
    }
    @Test
    void isValidPhoneParensOneDash() {
        assertTrue(Solution.isValidPhone("(253)456-7890"));
    }
    @Test
    void isValidPhoneParensNoSpaceDash() {
        assertTrue(Solution.isValidPhone("(253)4567890"));
    }
    @Test
    void isValidPhoneNoParensOneDash() {
        assertTrue(Solution.isValidPhone("253456-7890"));
    }
    @Test
    void isValidPhoneNoParensOneDashOneSpace() {
        assertTrue(Solution.isValidPhone("253-890 9898"));
    }

    /*-----------------------------------------INVALID TESTS----------------------------------------------------------*/

    @Test
    void isInvalidPhoneEmptyString() {
        assertFalse(Solution.isValidPhone(""));
    }
    @Test
    void isInvalidPhoneLetters() {
        assertFalse(Solution.isValidPhone("a(253)-456-7890b"));
    }
    @Test
    void isInvalidPhoneInvalidChars() {
        assertFalse(Solution.isValidPhone("(253)!!!1234"));
    }
    @Test
    void isInvalidPhoneNotEnoughNumbers() {
        assertFalse(Solution.isValidPhone("351"));
    }
    @Test
    void isInvalidPhoneTooManyNumbers() {
        assertFalse(Solution.isValidPhone("(253)456-78900"));
    }
    @Test
    void isInvalidPhoneSQLInjection() {
        assertFalse(Solution.isValidPhone("Robert'); DROP TABLE Students;--"));
    }
    @Test
    void isInvalidPhoneSpacesInvalidAreaCode() {
        assertFalse(Solution.isValidPhone("1235555555"));
    }
    @Test
    void isInvalidPhoneUnderscores() {
        assertFalse(Solution.isValidPhone("253_456_7890"));
    }
}