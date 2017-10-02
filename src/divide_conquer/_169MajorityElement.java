package divide_conquer;

/** Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 You may assume that the array is non-empty and the majority element always exist in the array.*/
public class _169MajorityElement {

  public static void main(String[] args) {
    int[] nums = new int[]{2,4,2,2,3,2,2,3,4};
    _169MajorityElement me = new _169MajorityElement();
    System.out.println(me.majorityElement(nums));
  }

  public int majorityElement(int[] nums) {
    int major = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == major) count++;
      else count--;
      if (count == 0) {
        major = nums[i];
        count++;
      }
    }
    return major;
  }

  public int majorityElement2(int[] nums) {
    return nums[quickSelect(nums, 0, nums.length - 1)];
  }

  private int quickSelect(int[] arr, int lo, int hi) {
    int pi = partition(arr, lo, hi);
    int diff = arr.length / 2 + lo - pi - 1;
    if (diff < 0) return pi;
    else return quickSelect(arr, pi + 1, hi);
  }

  private int partition(int[] arr, int lo, int hi) {
    for (int i = lo; i < hi; i++) {
      if (arr[i] == arr[hi]) swap(arr, lo++, i);
    }
    swap(arr, lo, hi);
    return lo;
  }

  private void swap(int[] arr, int from, int to) {
    if (from == to) return;
    int temp = arr[from];
    arr[from] = arr[to];
    arr[to] = temp;
  }

}
