package leetcode.easy;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1000021));
    }

    public static boolean isPalindrome(int x) {
        return new StringBuilder(String.valueOf(x)).reverse().toString()
                .equals(String.valueOf(x));
    }
}
