package wc54;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _697DegreeOfArray {

  public static void main(String[] args) {
    _697DegreeOfArray me = new _697DegreeOfArray();
//    int[] nums = new int[]{1, 2, 2, 3, 1};
    int[] nums = new int[]{1, 2, 2, 3, 1, 4, 2};
//    int[] nums = new int[]{1, 2};
    System.out.println(me.findShortestSubArray(nums));
  }

  public int findShortestSubArray(int[] nums) {
    Map<Integer, Integer> c = new HashMap<>();
    for (int i : nums) {
      if (c.containsKey(i)) {
        c.put(i, c.get(i) + 1);
      } else {
        c.put(i, 1);
      }
    }
    List<Integer> list = new ArrayList<>();
    int hz = 0;
    for (int i : c.keySet()) {
      if (c.get(i) > hz) {
        list = new ArrayList<>();
        list.add(i);
        hz = c.get(i);
      } else if (c.get(i) == hz) {
        list.add(i);
      }
    }
    if (hz == 1) return 1;
    int min = nums.length;

    for (int no : list) {
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == no) {
          int count = 1;
          for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == no) {
              count++;
              if (count == hz) {
                min = Math.min(min, j - i + 1);
                if (min == hz) {
                  return min;
                }
              }
            }
          }
        }
      }
    }
    return min;
  }
}