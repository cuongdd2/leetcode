package easy;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings
 */
public class _14LongestCommonPrefix {

  public static void main(String[] args) {
    _14LongestCommonPrefix o = new _14LongestCommonPrefix();
    String[] strs = new String[]{};
    System.out.println(o.longestCommonPrefix(strs));
  }

  public String longestCommonPrefix(String[] strs) {
    String prefix = "";
    for (String s : strs) {
      if (s == null || s.equals("")) return "";
      if (prefix.equals("")) prefix = s;
      else {
        prefix = commonPrefix(prefix, s);
        if (prefix.equals("")) return prefix;
      }
    }
    return prefix;
  }

  private String commonPrefix(String s1, String s2) {
    String prefix = "";
    int len = Math.min(s1.length(), s2.length());
    for (int i = 0; i < len; i++) {
      if (s1.charAt(i) == s2.charAt(i)) prefix += s1.charAt(i);
      else break;
    }
    return prefix;
  }

}
