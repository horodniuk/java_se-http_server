package hh.task13;

import java.util.HashMap;
import java.util.Map;

/**
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII,
 * which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 * Example
 * MCMXCIV -> 3 (III)
 * LVIII -> 58 (L = 50, V= 5, III = 3)
 * MCMXCIV -> 1994 (M = 1000, CM = 900, XC = 90 and IV = 4)
 */


public class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> roman = new HashMap<String, Integer>();

        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);

        int dumRes = roman.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 1; i >= 0; i--) {

            if (roman.get(s.charAt(i)) >= roman.get(s.charAt(i + 1))) {
                dumRes = dumRes + roman.get(s.charAt(i));
            } else {
                dumRes = dumRes - roman.get(s.charAt(i));
            }
        }
        return dumRes;
    }
}
