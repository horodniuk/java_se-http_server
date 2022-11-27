package lecture11_unit_test_mockito.hometask.roman_numbner;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumber {
    private final Map<Character, Integer> romanMap;
    {
      romanMap = new LinkedHashMap<Character, Integer>();
      romanMap.put('I', 1);
      romanMap.put('V', 5);
      romanMap.put('X', 10);
      romanMap.put('L', 50);
      romanMap.put('C', 100);
      romanMap.put('D', 500);
      romanMap.put('M', 1000);
      System.out.println(romanMap);
    };


    public int romanToInt(String s) {
        isValidRomanSymbols(s);
        int result = romanMap.get(s.charAt(s.length() - 1));
        for (int i = 0; i < s.length()-1; i++) {
                if (romanMap.get(s.charAt(i)) >= romanMap.get(s.charAt(i + 1))) {
                    result = result + romanMap.get(s.charAt(i));
                } else {
                    result = result - romanMap.get(s.charAt(i));
                }
            }
        return result;
    }

    public boolean isValidRomanSymbols(String str){
            if (str == null) return false;
            Pattern p = Pattern.compile("^(?=[MDCLXVI])M*D?C{0,4}L?X{0,4}V?I{0,4}$");
            Matcher m = p.matcher(str);
            return m.matches();
    }
};
