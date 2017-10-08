package wc53;

/**
 * Given a positive integer, check whether it has alternating bits or not.

 Example 1:
 Input: 5
 Output: True
 Explanation:
 The binary representation of 5 is: 101
 Example 2:
 Input: 7
 Output: False
 Explanation:
 The binary representation of 7 is: 111
 */
public class _693BinaryNumberAlternatingBits {

  public static void main(String[] args) {
    System.out.println(hasAlternatingBits(10));
  }

  static public boolean hasAlternatingBits(int n) {
    String binary = Integer.toBinaryString(n);
    for (int i = 1; i < binary.length(); i++) {
      if (binary.charAt(i) == binary.charAt(i - 1)) return false;
    }
    return true;
  }
}
