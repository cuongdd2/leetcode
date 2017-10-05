package easy;

import java.util.Objects;

/**
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class _28ImplementStr {


  public int strStr(String haystack, String needle) {
    if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
    return haystack.indexOf(needle);
  }
}
