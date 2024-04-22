import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void isValidAddressStreet() {
        assertTrue(Solution.isValidAddress("1111 NE Main Street"));
    }
    @Test
    void isValidAddressSt() {
        assertTrue(Solution.isValidAddress("1111 N Main St."));
    }
    @Test
    void isValidAddressBoulevard() {
        assertTrue(Solution.isValidAddress("1010 E Banana Boulevard"));
    }
    @Test
    void isValidAddressBlvd() {
        assertTrue(Solution.isValidAddress("1010 E Banana Blvd."));
    }
    @Test
    void isValidAddressAvenue() {
        assertTrue(Solution.isValidAddress("4222 S Nottingham Avenue"));
    }
    @Test
    void isValidAddressAve() {
        assertTrue(Solution.isValidAddress("4222 N Southingham Ave."));
    }
    @Test
    void isValidAddressRoad() {
        assertTrue(Solution.isValidAddress("12 W North Road"));
    }
    @Test
    void isValidAddressRd() {
        assertTrue(Solution.isValidAddress("12334 S East Rd."));
    }

    /*--------------------------------------------INVALID TESTS-------------------------------------------------------*/

    @Test
    void isInvalidAddressNoNumber() {
        assertFalse(Solution.isValidAddress("N ForgotNumber Avenue"));
    }
    @Test
    void isInvalidAddressEmptyString() {
        assertFalse(Solution.isValidAddress(""));
    }
    @Test
    void isInvalidAddressSQLInjection() {
        assertFalse(Solution.isValidAddress("Robert'); DROP TABLE Students;--"));
    }
    @Test
    void isInvalidAddressNoCardinal() {
        assertFalse(Solution.isValidAddress("1010 No Cardinal Rd."));
    }
    @Test
    void isInvalidAddressNoSuffix() {
        assertFalse(Solution.isValidAddress("1212 W ForgotSuffix"));
    }
    @Test
    void TooManyCardinal() {
        assertFalse(Solution.isValidAddress("1010 NESW Center St."));
    }
    @Test
    void isInvalidAddressNoDelimiters() {
        assertFalse(Solution.isValidAddress("1010DontKnowWhereToStopStreet"));
    }
    @Test
    void isInvalidAddressNotEvenRemotelyCloseFormat() {
        assertFalse(Solution.isValidAddress("?!!!!!???? Not even an address-???>>"));
    }
}