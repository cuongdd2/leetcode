package easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class _20ValidParentheses {

  public static void main(String[] args) {
    String s = "(){}[]{()}[([()])]";
    System.out.println(isValid(s));
  }

  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (stack.empty()) stack.push(c);
      else {
        if (inPair(stack.peek(), c)) stack.pop();
        else stack.push(c);
      }
    }
    return stack.empty();
  }

  private static boolean inPair(char c1, char c2) {
    return (c1 == '(' && c2 == ')')
        || (c1 == '[' && c2 == ']')
        || (c1 == '{' && c2 == '}');
  }
}
