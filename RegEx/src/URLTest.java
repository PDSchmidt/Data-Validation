import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URLTest {

    @Test
    void isValidURLhttps() {
        assertTrue(Solution.isValidURL("https://www.google.com"));
    }
    @Test
    void isValidURLhttp() {
        assertTrue(Solution.isValidURL("http://www.google.com"));
    }
    @Test
    void isValidURLnohttp() {
        assertTrue(Solution.isValidURL("www.google.com"));
    }
    @Test
    void isValidURLNohttpNowww() {
        assertTrue(Solution.isValidURL("google.com"));
    }
    @Test
    void isValidURLHTTPS() {
        assertTrue(Solution.isValidURL("HTTPS://www.google.com"));
    }
    @Test
    void isValidURLHTTP() {
        assertTrue(Solution.isValidURL("HTTP://www.google.com"));
    }
    @Test
    void isValidURLhttpsNowww() {
        assertTrue(Solution.isValidURL("https://google.com"));
    }
    @Test
    void isValidURLGithub() {
        assertTrue(Solution.isValidURL("https://github.com/PDSchmidt"));
    }

    /*-------------------------------------------INVALID TESTS--------------------------------------------------------*/

    @Test
    void isInvalidURLSQLInjection() {
        assertFalse(Solution.isValidURL("Robert'); DROP TABLE Students;--"));
    }
    @Test
    void isInvalidURLEmptyString() {
        assertFalse(Solution.isValidURL(""));
    }
    @Test
    void isInvalidURLNumberInSubdomain() {
        assertFalse(Solution.isValidURL("google.c0m"));
    }
    @Test
    void isInvalidURLJustGoogle() {
        assertFalse(Solution.isValidURL("google"));
    }
    @Test
    void isInvalidURLNoDomain() {
        assertFalse(Solution.isValidURL("https://www."));
    }
    @Test
    void isInvalidURLNoDomain2() {
        assertFalse(Solution.isValidURL(".com/whoopsForgotTheDomain"));
    }
    @Test
    void isInvalidURLOnlyExtras() {
        assertFalse(Solution.isValidURL("/ForgotToTypeWhereI’mTryingToGo"));
    }
    @Test
    void isInvalidURLTooManyS() {
        assertFalse(Solution.isValidURL("httpss://www.google.com"));
    }
}