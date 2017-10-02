package divide_conquer;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    int N = 18;
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = (int)(Math.random() * N);
    }
    System.out.println(Arrays.toString(arr));
    sort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  /** get a pivot index, sort left and right of pivot */
  public static void sort(int[] arr, int li, int hi) {
    if (li >= hi) return;
    int pi = partition(arr, li, hi);
    sort(arr, li, pi - 1);
    sort(arr, pi + 1, hi);
  }

  /** pick a pivot (last item) and move all smaller to left, then move pivot to middle  */
  public static int partition(int[] arr, int li, int hi) {
    for (int i = li; i < hi; i++) if (arr[i] <= arr[hi]) swap(arr, li++, i);
    swap(arr, li, hi);
    return li;
  }

  private static void swap(int[] arr, int from, int to) {
    if (from == to) return;
    int temp = arr[from];
    arr[from] = arr[to];
    arr[to] = temp;
  }

}
