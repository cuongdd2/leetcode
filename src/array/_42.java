package array;

public class _42 {

  public static void main(String[] args) {
    _42 me = new _42();
    int[] arr = new int[]{6, 4, 2, 0, 3, 2, 0, 3, 1, 4, 5, 3, 2, 7, 5, 3, 0, 1, 2, 1, 3, 4, 6, 8, 1,
        3};
    System.out.println(me.trap(arr));
  }

  public int trap(int[] A) {
    int left = 0, right = A.length - 1, result = 0, plank = 0;
    while (left <= right) {
      plank = Math.max(Math.min(A[left], A[right]), plank);
      result += plank - (A[left] >= A[right] ? A[right--] : A[left++]);
    }
    return result;
  }
}
