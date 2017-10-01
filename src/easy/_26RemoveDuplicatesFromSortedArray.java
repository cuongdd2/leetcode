package easy;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 */
public class _26RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {
    int[] nums = new int[] {1,1,2,3,4,5,5,6,6,7,7,7};
    System.out.println(dualIndex(nums));
    System.out.println(Arrays.toString(nums));
  }

  public static int removeDuplicates(int[] nums) {
    int dup = 0;
    if (nums.length < 1) return nums.length;
    int last = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == last) {
        dup++;
      } else {
        last = nums[i];
        nums[i - dup] = nums[i];
      }
    }
    return nums.length - dup;
  }

  public static int dualIndex(int[] nums) {
    if (nums.length == 0) return 0;
    int newIndex = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[newIndex]) {
        newIndex++;
        nums[newIndex] = nums[i];
      }
    }
    return newIndex + 1; // length = index + 1
  }
}
