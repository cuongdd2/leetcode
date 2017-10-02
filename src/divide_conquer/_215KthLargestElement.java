package divide_conquer;

import java.util.Arrays;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class _215KthLargestElement {

  public static void main(String[] args) {
    int N = 20;
    int[] nums = new int[N];
    for (int i = 0; i < N; i++) {
      nums[i] = (int)(Math.random() * 100);
    }
    System.out.println(Arrays.toString(nums));
    System.out.println(findKthLargest(nums, 2));
    System.out.println(Arrays.toString(nums));
  }

  public static int findKthLargest(int[] nums, int k) {
    sortKthLargest(nums, k , 0, nums.length - 1);
    return nums[k - 1];
  }

  public static void sortKthLargest(int[] nums, int k, int lo, int hi) {
    int pi = partition(nums, lo, hi);
    if (pi == k - 1) return;
    if (pi > k - 1) sortKthLargest(nums, k, 0, pi - 1);
    else sortKthLargest(nums, k, pi + 1, hi);
  }

  /** pick pivot (last item) then move greater numbers to left */
  public static int partition(int[] nums, int lo, int hi) {
    for (int i = lo; i < hi; i++) {
      if (nums[i] >= nums[hi]) swap(nums, lo++, i);
    }
    swap(nums, lo, hi);
    return lo;
  }

  private static void swap(int[] arr, int from, int to) {
    if (from == to) return;
    int temp = arr[from];
    arr[from] = arr[to];
    arr[to] = temp;
  }
}
