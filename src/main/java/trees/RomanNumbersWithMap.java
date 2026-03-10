package trees;


import java.util.HashMap;
import java.util.Map;


public class RomanNumbersWithMap {

    /**
     Seven different symbols represent Roman numerals with the following values:

     Symbol	Value
     I	1
     V	5
     X	10
     L	50
     C	100
     D	500
     M	1000
     Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:

     If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
     If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
     Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
     Given an integer, convert it to a Roman numeral.

     Example 1:

     Input: num = 3749

     Output: "MMMDCCXLIX"

     Explanation:

     3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
     700 = DCC as 500 (D) + 100 (C) + 100 (C)
     40 = XL as 10 (X) less of 50 (L)
     9 = IX as 1 (I) less of 10 (X)
     Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
     Example 2:

     Input: num = 58

     Output: "LVIII"

     Explanation:

     50 = L
     8 = VIII
     Example 3:

     Input: num = 1994

     Output: "MCMXCIV"

     Explanation:

     1000 = M
     900 = CM
     90 = XC
     4 = IV


     Constraints:

     1 <= num <= 3999
     */

    static Map<Integer, String> unitMap = new HashMap<>() {{
        put(1, "I");
        put(2, "II");
        put(3, "III");
        put(4, "IV");
        put(5, "V");
        put(6, "VI");
        put(7, "VII");
        put(8, "VIII");
        put(9, "IX");
    }};
    static Map<Integer, String> tensMap = new HashMap<>() {{
        put(1, "X");
        put(2, "XX");
        put(3, "XXX");
        put(4, "XL");
        put(5, "L");
        put(6, "LX");
        put(7, "LXX");
        put(8, "LXXX");
        put(9, "XC");
    }};
    static Map<Integer, String> hundredthsMap = new HashMap<>() {{
        put(1, "C");
        put(2, "CC");
        put(3, "CCC");
        put(4, "CD");
        put(5, "D");
        put(6, "DC");
        put(7, "DCC");
        put(8, "DCCC");
        put(9, "CM");
    }};
    static Map<Integer, String> thousandsMap = new HashMap<>() {{
        put(1, "M");
        put(2, "MM");
        put(3, "MMM");
    }};

    private static String intToRoman(int num) {
        String result = "";
        int unit = num % 10;
        if (unit != 0) result = unitMap.get(unit) + result;
        num = num/10;
        if (num == 0) return result;
        int tens = num % 10;
        if (tens != 0) result = tensMap.get(tens) + result;
        num = num/10;
        if (num == 0) return result;
        int hundredths = num % 10;
        if (hundredths != 0) result = hundredthsMap.get(hundredths) + result;
        num = num/10;
        if (num == 0) return result;
        int thousands = num % 10;
        if (thousands != 0) result = thousandsMap.get(thousands) + result;
        return result;
    }
}

