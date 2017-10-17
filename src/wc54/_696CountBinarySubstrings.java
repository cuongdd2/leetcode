package wc54;

import java.math.BigInteger;

public class _696CountBinarySubstrings {

  public static void main(String[] args) {
    _696CountBinarySubstrings me = new _696CountBinarySubstrings();
    String s = "00110011";
    System.out.println(s);
    System.out.println(me.countBinarySubstrings(s));
  }

  public int countBinarySubstrings(String s) {
    int count = 0;
    
    for (int len = s.length(); len >= 2; len--) {
      if (len % 2 != 0) continue;
      for (int i = 0; i <= s.length() - len; i++) {
        if (isValid(s.substring(i, i + len))) count++;

      }
    }
    return count;
  }

  int count(String s) {
    if (s.length() == 0) return 0;
    int c = 0;
    if (isValid(s)) c++;
    c += count(s.substring(1));
    c += count(s.substring(0, s.length() - 1));
    return c;
  }

  boolean isValid(String s) {
    int fc = 0;
    int sc = 0;
    char f = s.charAt(0);
    for (char c : s.toCharArray()) {
      if (c == f && sc == 0) fc++;
      else if (c != f) sc++;
      else return false;
    }
    return fc == sc;
  }
}
