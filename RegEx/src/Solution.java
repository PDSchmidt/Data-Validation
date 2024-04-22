import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Class with validation methods for input meeting various criteria by utilizing Regular Expressions.
 *
 * @author Paul Schmidt
 */
public class Solution {

    public static void main(String[] args) {
        String date = "07-20-1992";
        String date2 = "07/20/1992";
        String date3 = "02/29/2024";
        String date4 = "02/29/2023";
        String date5 = "02/30/2023";
        String csz = "Saint Louis, MO 63101";
        String csz2 = "Saint Louis, ZZ 63101";
        System.out.println("Date " + date + " valid?: " + isValidDate(date));
        System.out.println("Date " + date2 + " valid?: " + isValidDate(date2));
        System.out.println("Date " + date3 + " valid?: " + isValidDate(date3));
        System.out.println("Date " + date4 + " valid?: " + isValidDate(date4));
        System.out.println("Date " + date5 + " valid?: " + isValidDate(date5));
        System.out.println("CSZ (" + csz + ") valid?: " + isValidCityStateZip(csz));
        System.out.println("CSZ (" + csz2 + ") valid?: " + isValidCityStateZip(csz2));
        System.out.println(isValidSSN("123-01-0001"));
        System.out.println(isValidPhone("(253) 495 7535"));
        System.out.println("PASSWORD: aA9!bcdefghijk : " + isValidPassword("aA9!bcdefghijk"));
        System.out.println("PASSWORD: ~~aa : " + isValidPassword("~~aa"));
    }

    /**
     * --------------------------EXTRA CREDIT ALERT--------------------------------
     * - Followed rules outlined here:
     * - https://en.wikipedia.org/wiki/Social_Security_number
     * - Used parsing and Java for validation of these rules.
     * ----------------------------------------------------------------------------
     * Social Security Number (can be with dashes, whitespace, or no spaces at all)
     * @param input The input as a String to test with the Regular Expression
     * @return True if the input is valid, False otherwise
     */
    protected static boolean isValidSSN(final String input) {
        String regex = "^\\d{3}[ -]?\\d{2}[ -]?\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        boolean result = match.find();
        if (result) {
            String stripped = "";
            for(int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    stripped += input.charAt(i);
                }
            }
            int firstSet = Integer.parseInt(stripped.substring(0, 3));
            int secondSet = Integer.parseInt(stripped.substring(3, 5));
            int thirdSet = Integer.parseInt((stripped.substring(5)));
            //System.out.println(firstSet + " " + secondSet + " " + thirdSet);
            if (secondSet == 0 || thirdSet == 0) {
                result = false;
            }
            if (result && (firstSet == 0 || firstSet > 899 || firstSet == 666)) {
                result = false;
            }
        }
        return result;
    }

    /**
     * ------------------------------------Extra Credit Alert---------------------------------------
     * - If input passes initial regex, parse input for first three digits and test against a list
     * - of valid area codes.
     * ---------------------------------------------------------------------------------------------
     * US Phone number - parentheses are optional, as well as the dash between the last two sections
     * @param input The input as a String to test with the Regular Expression
     * @return True if the input is valid, False otherwise
     */
    protected static boolean isValidPhone(final String input) {
        String regex = "^((\\(?\\d{3}\\)?)[ -]?(\\d{3})[ -]?(\\d{4}))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        boolean result = match.find();
        if (result) {
            ArrayList<Integer> validCodes = new ArrayList<>(List.of(201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 212, 213,
                    214, 215, 216, 217, 218, 219, 220, 224, 225, 226, 227, 228, 229, 231, 234, 236, 239, 240, 242, 246,
                    248, 249, 250, 251, 252, 253, 254, 256, 260, 262, 264, 267, 268, 269, 270, 272, 274, 276, 281, 283,
                    284, 289, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 312, 313, 314, 315, 316, 317, 318, 319,
                    320, 321, 323, 325, 327, 330, 331, 332, 334, 336, 337, 339, 340, 343, 345, 346, 347, 351, 352, 360,
                    361, 364, 365, 380, 385, 386, 387, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 412, 413, 414,
                    415, 416, 417, 418, 419, 423, 424, 425, 430, 431, 432, 434, 435, 437, 438, 440, 441, 442, 443, 447,
                    450, 458, 463, 464, 469, 470, 473, 475, 478, 479, 480, 484, 501, 502, 503, 504, 505, 506, 507, 508,
                    509, 510, 512, 513, 514, 515, 516, 517, 518, 519, 520, 530, 531, 534, 539, 540, 541, 548, 551, 559,
                    561, 562, 563, 564, 567, 570, 571, 573, 574, 575, 579, 580, 581, 585, 586, 587, 601, 602, 603, 604,
                    605, 606, 607, 608, 609, 610, 612, 613, 614, 615, 616, 617, 618, 619, 620, 623, 626, 628, 629, 630,
                    631, 636, 639, 641, 646, 647, 649, 650, 651, 657, 660, 661, 662, 664, 667, 669, 670, 671, 672, 678,
                    680, 681, 682, 684, 701, 702, 703, 704, 705, 706, 707, 708, 709, 712, 713, 714, 715, 716, 717, 718,
                    719, 720, 721, 724, 725, 727, 730, 731, 732, 734, 737, 740, 742, 743, 747, 754, 757, 758, 760, 762,
                    763, 765, 767, 769, 770, 772, 773, 774, 775, 778, 779, 780, 781, 782, 782, 784, 785, 786, 787, 801,
                    802, 803, 804, 805, 806, 807, 808, 809, 810, 812, 813, 814, 815, 816, 817, 818, 819, 825, 828, 829,
                    830, 831, 832, 843, 845, 847, 848, 849, 850, 854, 856, 857, 858, 859, 860, 862, 863, 864, 865, 867,
                    868, 869, 870, 872, 873, 876, 878, 901, 902, 902, 903, 904, 905, 906, 907, 908, 909, 910, 912, 913,
                    914, 915, 916, 917, 918, 919, 920, 925, 928, 929, 930, 931, 934, 936, 937, 938, 939, 940, 941, 947,
                    949, 951, 952, 954, 956, 959, 970, 971, 972, 973, 975, 978, 979, 980, 984, 985, 986, 989));
            String stripped = "";
            for(int i = 0; i < input.length(); i++) {
                if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    stripped += input.charAt(i);
                }
            }
            int areaCode = Integer.parseInt(stripped.substring(0,3));
            //System.out.println(areaCode);
            if (!validCodes.contains(areaCode)) {
                result = false;
            }
        }
        return result;
    }

    /**
     * E-mail address
     * Tried to follow the guidelines for valid/invalid emails here: en.wikipedia.org/wiki/Email_address
     * Did not implement the part about quotes in the Local-part or character number limits...
     * @param input The input as a String to test with the Regular Expression
     * @return True if the input is valid, False otherwise
     */
    protected static boolean isValidEMail(final String input) {
        String regex = "^([\\w!#$%&'*+-/=?^_`{|}~]+[\\.?\\w!#$%&'*+-/=?^_`{|}~]*@(\\w(-?\\w)*)\\.(\\w(-?\\w)*)(\\.(\\w(-?\\w)*))*)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        return match.find();
    }

    /**
     * Name on a class roster, assuming zero or more middle initials - Last name, First name, MI (e.g. Smith, John, L)
     *
     * SUPPORTS NAMES WITH HYPHENS IN THEM, BECAUSE THAT IS A VERY REAL THING
     * @param input The input as a String to test with the Regular Expression
     * @return True if the input is valid, False otherwise
     */
    protected static boolean isValidName(final String input) {
        String regex = "^([A-Za-z-]{2,}, [A-Za-z-]{2,}(, [A-Z]+)?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        return match.find();
    }

    /**
     * Date in MM-DD-YYYY format - separators can be -'s, /'s -- you must make sure months, days, year are valid
     * (this includes leap years)
     *
     * THIS METHOD UTILIZES JAVA'S LOCALDATE CLASS TO TEST IF THE DATE ENTERED IS A VALID DATE OR NOT (AFTER
     * THE REGEX CHECKS TO SEE IF THE INPUT IS IN THE CORRECT FORMAT OF MM = (01-12) DD = (01-31) YYYY = (0000-9999))
     *
     * @param input The input as a String to test with the Regular Expression
     * @return True if the input is valid, False otherwise
     */
    protected static boolean isValidDate(final String input) {
        String regex = "^(((0[1-9])|(1[0-2]))([-/])((0[1-9])|([1-2][\\d])|(3[0-1]))(\\5)(\\d{4}))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        boolean foundMatch = match.find();
        if (foundMatch) {
            try {
                String format = "MM-dd-uuuu";
                if(input.contains("/")) {
                    format = "MM/dd/uuuu";
                }
                DateTimeFormatter setFormat = DateTimeFormatter.ofPattern(format).withResolverStyle(ResolverStyle.STRICT);
                LocalDate tryDate = LocalDate.parse(input, setFormat);
            } catch(DateTimeParseException e) {
                foundMatch = false;
            }
        }
        return foundMatch;
    }

    /**
     * House address - Street number, street name, abbreviation for road, street, boulevard or avenue
     * (full version of those items should also be accepted)
     * @param input The input as a String to test with the Regular Expression
     * @return True if the input is valid, False otherwise
     */
    protected static boolean isValidAddress(final String input) {
        String regex = "^(\\d+ ([NESW]|(NE)|(NW)|(SE)|(SW)) [A-Z][a-z]*([ -][A-Z][a-z]*)* ((St.)|(Street)|(Rd.)|(Road)|(Boulevard)|(Blvd.)|(Avenue)|(Ave.)))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        return match.find();
    }

    /**
     * ---------------------EXTRA CREDIT ALERT-------------------------------
     * City followed by state followed by zip as it should appear on a letter
     * @param input The input as a String to test with the Regular Expression
     * @return True if the input is valid, False otherwise
     */
    protected static boolean isValidCityStateZip(final String input) {
        String regex = "^(([A-Z][a-z]+ ?)+, [A-Z]{2} \\d{5}(-\\d{4})?)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        boolean result = match.find();
        if(result) {
            int indexOfStartAbv = input.indexOf(',') + 2;
            String stateABV = input.substring(indexOfStartAbv, indexOfStartAbv + 2);
            //System.out.println(stateABV);
            ArrayList<String> states = new ArrayList<>(List.of("AL", "AK", "AZ", "AR", "AS", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "GU", "HI", "ID"
                    , "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ"
                    , "NM", "NY", "NC", "ND", "MP", "OH", "OK", "OR", "PA", "PR", "RI", "SC", "SD", "TN", "TX", "TT", "UT", "VT"
                    , "VA", "VI", "WA", "WV", "WI", "WY"));
            if (!states.contains(stateABV)) {
                result = false;
            }
        }
        return result;
    }

    /**
     * Military time (no colons used and leading 0 is included for times under 10)
     * @param input The input as a String to test with the Regular Expression
     * @return True if the input is valid, False otherwise
     */
    protected static boolean isValidMilitaryTime(final String input) {
        String regex = "^((([01]\\d)|(2[0-3]))[0-5]\\d)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        return match.find();
    }

    /**
     * US Currency down to the penny (ex: $123,456,789.23)
     *
     * Because there was only the one example, and it included the $ sign, commas, and a decimal, that
     * is the format the regex is designed for. 4 Digits without a comma? Fail. No dollar sign? Fail.
     * @param input The input as a String to test with the Regular Expression
     * @return True if the input is valid, False otherwise
     */
    protected static boolean isValidUSCurrency(final String input) {
        String regex = "^\\$(\\d{1,3})(,\\d{3})*\\.(\\d{2})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        return match.find();
    }

    /**
     * URL, optionally including http:// or https://, upper and lower case should be accepted
     * @param input The input as a String to test with the Regular Expression
     * @return True if the input is valid, False otherwise
     */
    protected static boolean isValidURL(final String input) {
        String regex = "^(((https?://)|(HTTPS?://))?(www\\.)?([\\w-])+\\.([a-z])+((/[\\w-_.~:@/?&=#%+\\[\\]!$()*,;]+)?)*)$";
        String http = "((https?://)|(HTTPS?://))?"; //optional
        String www = "(www\\.)?"; //also optional
        String domain = "([\\w-])+"; //domain can only have a-zA-Z0-9
        String topLevelDom = "\\.([a-z])+"; //top level dom can be a number of a-z
        String subDirectory = "((/[\\w-_.~:@/?&=#%+\\[\\]!$\\(\\)*,;]+)?)*"; // lots of stuff allowed here
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        return match.find();
    }

    /**
     * A password that contains at least 10 characters and includes at least one upper case character,
     * one lower case character, one digit, one punctuation mark, and does not have more than 3
     * consecutive lower case characters
     * Source for special characters allowed in passwords: https://owasp.org/www-community/password-special-characters
     * Source for punctuation in english language: https://www.lynchburg.edu/academics/writing-center/wilmer-writing-
     * center-online-writing-lab/grammar/a-quick-guide-to-punctuation/#:~:text=The%20standard%20English%20
     * punctuation%20is,punctuation%20that%20is%20commonly%20misused.
     * @param input The input as a String to test with the Regular Expression
     * @return True if the input is valid, False otherwise
     */
    protected static boolean isValidPassword(final String input) {
        String atLeastTen = "(.){10,}";
        String oneOrMoreLower = "(?=.*[a-z])";
        String oneOrMoreUpper = "(?=.*[A-Z])";
        String oneOrMoreDigit = "(?=.*\\d)";
        String oneOrMorePunctuation = "(?=.*[.?!,;:\\-()\\[\\]{}'\"])"; // Per University of Lynchburg
        String notSameLower3TimesInARow = "([a-z])\\1\\1";
//        System.out.println(input + " TEN: " + Pattern.compile(atLeastTen).matcher(input).find());
//        System.out.println(input + " UPPER: " + Pattern.compile(oneOrMoreUpper).matcher(input).find());
//        System.out.println(input + " LOWER: " + Pattern.compile(oneOrMoreLower).matcher(input).find());
//        System.out.println(input + " Digit: " + Pattern.compile(oneOrMoreDigit).matcher(input).find());
//        System.out.println(input + " PUNCTUATION: " + Pattern.compile(oneOrMorePunctuation).matcher(input).find());
//        System.out.println(input + " NOTSAMELOWER: " + !Pattern.compile(notSameLower3TimesInARow).matcher(input).find());

        /* Test with this after the other stuff. If a match is found, reject the whole damn thing. */
        boolean hasTen = Pattern.compile(atLeastTen).matcher(input).find();
        boolean hasUpper = Pattern.compile(oneOrMoreUpper).matcher(input).find();
        boolean hasLower = Pattern.compile(oneOrMoreLower).matcher(input).find();
        boolean hasDigit = Pattern.compile(oneOrMoreDigit).matcher(input).find();
        boolean hasPunctuation =  Pattern.compile(oneOrMorePunctuation).matcher(input).find();
        boolean noThreeConsecutiveLower =  !Pattern.compile(notSameLower3TimesInARow).matcher(input).find();
        return hasTen && hasUpper && hasLower && hasDigit && hasPunctuation && noThreeConsecutiveLower;
    }

    /**
     * All words containing an odd number of alphabetic characters, ending in "ion"
     * @param input The input as a String to test with the Regular Expression
     * @return True if the input is valid, False otherwise
     */
    protected static boolean isValidION(final String input) {
        String regex = "^([a-z|A-Z][a-z|A-Z])*?(ion)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        return match.find();
    }
}
