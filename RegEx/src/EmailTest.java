import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void isValidEMailBasic() {
        assertTrue(Solution.isValidEMail("simple@example.com"));
    }
    @Test
    void isValidEMailPeriodInLocal() {
        assertTrue(Solution.isValidEMail("very.common@example.com"));
    }
    @Test
    void isValidEMailSingleCharLocal() {
        assertTrue(Solution.isValidEMail("x@example.com"));
    }
    @Test
    void isValidEMailHyphensInLocalAndSubDomain() {
        assertTrue(Solution.isValidEMail("long.email-address-with-hyphens@and.subdomains.example.com"));
    }
    @Test
    void isValidEMailSubdomain() {
        assertTrue(Solution.isValidEMail("example@s.example"));
    }
    @Test
    void isValidEMailLocalEndWithHyphen() {
        assertTrue(Solution.isValidEMail("user-@example.org"));
    }
    @Test
    void isValidEMailExclamationInLocal() {
        assertTrue(Solution.isValidEMail("mailhost!username@example.org"));
    }
    @Test
    void isValidEMailForwardSlashInLocal() {
        assertTrue(Solution.isValidEMail("name/surname@example.com"));
    }
/*--------------------------------------------------INVALID TESTS-----------------------------------------------------*/
    @Test
    void isInvalidEMailNoAtSymbol() {
        assertFalse(Solution.isValidEMail("abc.example.com"));
    }
    @Test
    void isInvalidEMailTooManyAtSymbols() {
        assertFalse(Solution.isValidEMail("a@b@c@example.com"));
    }
    @Test
    void isInvalidEMailQuotesInLocal() {
        assertFalse(Solution.isValidEMail("just\"not\"right@example.com"));
    }
    @Test
    void isInvalidEMailBackslashes() {
        assertFalse(Solution.isValidEMail("this\\ still\\\"not\\\\allowed@example.com"));
    }
    @Test
    void isInvalidEMailSpaces() {
        assertFalse(Solution.isValidEMail("this is\"not\\allowed@example.com"));
    }
    @Test
    void isInvalidEMailUnderscoreInDomain() {
        assertFalse(Solution.isValidEMail("i.like.underscores@but_they_are_not_allowed_in_this_part"));
    }
    @Test
    void isInvalidEMailSQLInjection() {
        assertFalse(Solution.isValidEMail("Robert'); DROP TABLE Students;--"));
    }
    @Test
    void isInvalidEMailEmptyString() {
        assertFalse(Solution.isValidEMail(""));
    }
}