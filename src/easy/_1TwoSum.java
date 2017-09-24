package easy;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].*/
public class _1TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(hashSum(nums, target)));
    }


    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return new int[2];
    }
    
    private static int[] hashSum(int[] nums, int target) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        int key;
        Integer value;
        for (int i = 0; i < nums.length; i++) {
            key = nums[i];
            value = table.get(key);
            if (value == null) table.put(target - key, i);
            else return new int[]{i, value};
        }
        return new int[2];
    }
 }
