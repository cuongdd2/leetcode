package easy;

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class _13Roman2Integer {

  public static void main(String[] args) {
    String s = "MMCDXIV";
    System.out.println(romanToInt(s));//2414
  }

  /**
   * Time complexity: O(n) Space complexity: O(1)
   */
  public static int romanToInt(String s) {
    if (s == null || s.equals("")) {
      return 0;
    }
    int result = 0;
    int last = char2Int(s.charAt(0));
    int current;
    for (int i = 1; i < s.length(); i++) {
      current = char2Int(s.charAt(i));
      if (last < current) {
        result += current - 2 * last;
      } else {
        result += last;
        last = current;
      }
    }
    result += last;
    return result;
  }

  private static int char2Int(char c) {
    switch (c) {
      case 'M':
        return 1000;
      case 'D':
        return 500;
      case 'C':
        return 100;
      case 'L':
        return 50;
      case 'X':
        return 10;
      case 'V':
        return 5;
      case 'I':
        return 1;
      default:
        return 0;
    }
  }

}
