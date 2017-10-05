package divide_conquer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**Given a string of numbers and operators, return all possible results from computing all
 * the different possible ways to group numbers and operators. The valid operators are +, - and *.

 Example 1
 Input: "2-1-1".

 ((2-1)-1) = 0
 (2-(1-1)) = 2
 Output: [0, 2]

 Example 2
 Input: "2*3-4*5"

 (2*(3-(4*5))) = -34
 ((2*3)-(4*5)) = -14
 ((2*(3-4))*5) = -10
 (2*((3-4)*5)) = -10
 (((2*3)-4)*5) = 10
 Output: [-34, -14, -10, -10, 10]*/
public class _241DifferentWays2AddParentheses {

  public static void main(String[] args) {
    _241DifferentWays2AddParentheses me = new _241DifferentWays2AddParentheses();
    System.out.println(me.diffWaysToCompute("2*3-4*5"));
  }

  public List<Integer> diffWaysToCompute(String input) {
    List<Integer> result = new ArrayList<>();


    return result;
  }

  private int parition(char[] arr, int lo, int hi) {
    return -1;
  }

  private int compute(char[] arr) {
    Stack<Character> stack = new Stack<>();
    String currNumber = "";
    int left, right;
    char operater;
    for (int i = 0; i < arr.length; i++) {
      switch (arr[i]) {
        case '*':
        case '+':
        case '-':
          operater = arr[i];

          default:
            currNumber += arr[i];

      }
    }
    return 0;
  }

  private boolean isPair(char c1, char c2) {
    return c1 == '(' && c2 == ')';
  }
}
