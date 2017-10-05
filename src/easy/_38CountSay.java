package easy;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.

 Example 1:

 Input: 1
 Output: "1"
 Example 2:

 Input: 4
 Output: "1211"
 * */
public class _38CountSay {

  public static void main(String[] args) {
    _38CountSay me = new _38CountSay();
    System.out.println(me.countAndSay(5));
  }

  public String countAndSay(int n) {
    String s = "";
    for (int i = 1; i <= n; i++) {
      if (i == 1) s = "1";
      else {
        char c = s.charAt(0);
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int j = 1; j < s.length(); j++) {
          if (c != s.charAt(j)) {
            result.append(count).append(c);
            count = 1;
            c = s.charAt(j);
          } else count++;
        }
        s = result.append(count).append(c).toString();
      }
    }
    return s;
  }
}
