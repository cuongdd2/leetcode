package wc50;

import java.util.Stack;

/**
 Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

 Example 1:
 Input: "aba"
 Output: True
 Example 2:
 Input: "abca"
 Output: True
 Explanation: You could delete the character 'c'.
 Note:
 The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class _680ValidPalindromeII {

    public static void main(String[] args) {
        System.out.println(validPalindrome("atbbga"));
    }

    public static boolean validPalindrome(String s) {
        for (int left = -1, right = s.length(); ++left < --right;) {
            if (s.charAt(left) != s.charAt(right)) return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
        }
        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) if (s.charAt(left++) != s.charAt(right--)) return false;
        return true;
    }
}
