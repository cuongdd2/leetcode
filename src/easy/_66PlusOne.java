package easy;

import java.util.Arrays;

/**Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.*/
public class _66PlusOne {

  public static void main(String[] args) {
    int[] arr = new int[]{9,9};
    _66PlusOne me = new _66PlusOne();
    System.out.println(Arrays.toString(me.plusOne(arr)));
  }

  public int[] plusOne(int[] digits) {
    int sum = 1;
    for (int i = digits.length - 1; i > -1; i--) {
      sum += digits[i];
      digits[i] = sum % 10;
      sum /= 10;
      if(sum == 0) return digits;
    }
    int[] result = Arrays.copyOf(digits, digits.length + 1);
    result[0] = sum;
    return result;
  }
}
