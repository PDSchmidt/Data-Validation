import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {

    @Test
    void isValidUSCurrencySingleDollar() {
        assertTrue(Solution.isValidUSCurrency("$1.00"));
    }
    @Test
    void isValidUSCurrencyTwoDigitDollar() {
        assertTrue(Solution.isValidUSCurrency("$32.50"));
    }
    @Test
    void isValidUSCurrencyLeadingOneDigit() {
        assertTrue(Solution.isValidUSCurrency("$1,000,000.99"));
    }
    @Test
    void isValidUSCurrencyLeadingThreeDigit() {
        assertTrue(Solution.isValidUSCurrency("$100,999,123,456,789.01"));
    }
    @Test
    void isValidUSCurrency099() {
        assertTrue(Solution.isValidUSCurrency("$0.99"));
    }
    @Test
    void isValidUSCurrency1000() {
        assertTrue(Solution.isValidUSCurrency("$1,234.56"));
    }
    @Test
    void isValidUSCurrencyLeadingTwoDigit() {
        assertTrue(Solution.isValidUSCurrency("$12,123.99"));
    }
    @Test
    void isValidUSCurrencyLessThanAThousandMoreThanOneHundred() {
        assertTrue(Solution.isValidUSCurrency("$123.67"));
    }

    /*------------------------------------------INVALID TESTS---------------------------------------------------------*/

    @Test
    void isInvalidUSCurrencyEmptyString() {
        assertFalse(Solution.isValidUSCurrency(""));
    }
    @Test
    void isInvalidUSCurrencySQLInjection() {
        assertFalse(Solution.isValidUSCurrency("Robert'); DROP TABLE Students;--"));
    }
    @Test
    void isInvalidUSCurrencyNoDollarSymbol() {
        assertFalse(Solution.isValidUSCurrency("1.00"));
    }
    @Test
    void isInvalidUSCurrencyNoComma() {
        assertFalse(Solution.isValidUSCurrency("$1234,00.11"));
    }
    @Test
    void isInvalidUSCurrencyTooManyCentDigits() {
        assertFalse(Solution.isValidUSCurrency("$192.003"));
    }
    @Test
    void isInvalidUSCurrencyNoDecimalButComma() {
        assertFalse(Solution.isValidUSCurrency("$192,45"));
    }
    @Test
    void isInvalidUSCurrencyLetters() {
        assertFalse(Solution.isValidUSCurrency("$lolxD.money"));
    }
    @Test
    void isInvalidUSCurrencyInvalidCharactersNoNumbers() {
        assertFalse(Solution.isValidUSCurrency("%BrokeGiveMeMoney%"));
    }
}