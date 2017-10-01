package hard;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the array after merge from two sorted arrays . The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]
 merge_array = [1, 2, 3]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]
 merge_array = [1, 2, 3, 4]

 The median is (2 + 3)/2 = 2.5
 */
public class _4Median2SortedArrays {

  public static void main(String[] args) {
    int[] nums1 = new int[] {};
    int[] nums2 = new int[] {1};
    _4Median2SortedArrays o = new _4Median2SortedArrays();
    System.out.println(o.findMedianSortedArrays(nums1, nums2));
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length == 0) return median(nums2);
    if (nums2.length == 0) return median(nums1);
    return (median(nums1) + median(nums2))/2;
  }

  private double median(int[] arr) {
    int n = arr.length;
    if (n == 0) return 0;
    if (n % 2 == 1) return (double)arr[n/2];
    else return (double)(arr[n/2 - 1] + arr[n/2])/2;
  }
}
