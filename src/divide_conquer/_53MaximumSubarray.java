package divide_conquer;


import java.util.Arrays;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the
 * largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the
 * largest sum = 6.
 */
public class _53MaximumSubarray {

  private static int[] sums;
  private static int[] nums;
  private static int N;
  private static long t;

  public static void main(String[] args) {
//    nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
    nums = new int[]{-84, -87, -78, -16, -94, -36, -87, -93, -50, -22, -63, -28, -91, -60, -64, -27,
        -41, -27, -73, -37, -12, -69, -68, -30, -83, -31, -63, -24, -68, -36, -30, -3, -23, -59,
        -70, -68, -94, -57, -12, -43, -30, -74, -22, -20, -85, -38, -99, -25, -16, -71, -14, -27,
        -92, -81, -57, -74, -63, -71, -97, -82, -6, -26, -85, -28, -37, -6, -47, -30, -14, -58, -25,
        -96, -83, -46, -15, -68, -35, -65, -44, -51, -88, -9, -77, -79, -89, -85, -4, -52, -55,
        -100, -33, -61, -77, -69, -40, -13, -27, -87, -95, -40};
    N = nums.length;
    t = System.currentTimeMillis();
    sums = new int[N * N];
    Arrays.fill(sums, Integer.MIN_VALUE);
    System.out.println(solutionDP(nums));
    long now = System.currentTimeMillis();
//    System.out.println(now - t);
  }

  /**
    Loop through all elements once
    Sum, and keep track of the greatest sum
    If the sum < 0, reset to 0
   */
  public static int solutionDP(int[] nums) {
    int sum = 0, max = nums[0];
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      max = Math.max(sum, max);
      sum = Math.max(sum, 0);
    }
    return max;
  }

  /**
   * Must loop through all elements once O(n)
   4 pointers - 2 left, 2 right
   2 pointers move through all elements until they collide (function is done)
   2 pointers keep track of where the maxSubarray indices are
   Keep track of sum for left and right, if the sum < 0, move the index pointers
   ^ Returns the maxSubarray, not the sum
   * @param nums int array, un-sorted order
   * @return max sub array sum
   */

  public static int solutionDAC(int[] nums) {
    return -1;
  }
}
