package wc51;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits.
 * There is no limit on how many times a digit can be reused.

 You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

 Input: "23:59"
 Output: "22:22"
 Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22.
 It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 *
 * */
public class NextClosestTime {
    public static String nextClosestTime(String time) {
        String[] arr = time.split(":");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        int[] digits = new int[time.length() - 1];
        int index = 0;
        for (char c : time.toCharArray()) {
            if (c == ':') continue;
            int i = (int)c - 48;
            digits[index++] = i;
        }
        List<Integer> validHours = new ArrayList<>();
        List<Integer> validMins = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int number = digits[i] * 10 + digits[j];
                if (number < 24) validHours.add(number);
                if (number < 60) validMins.add(number);
            }
        }
        validHours.sort(Comparator.naturalOrder());
        validMins.sort(Comparator.naturalOrder());
        // min < new < 60 ->
        for (int newMin : validMins) {
            if (newMin > min) return format(hour, newMin);
        }
        // hour < new < 24 -> add new < min
        for (int newHour : validHours) {
            if (newHour > hour) {
                for (int newMin : validMins) {
                    if (newMin <= min) return format(newHour, newMin);
                }
            }
        }
        // new < hour -> new < min
        for (int newHour: validHours) {
            if (newHour <= hour) {
                for (int newMin : validMins) {
                    if (newMin <= min) return format(newHour, newMin);
                }
            }
        }

        return "23:59";
    }
    private static String format(int h, int m) {
        String strHour = h < 10 ? ("0" + h) : ("" + h);
        String strMin = m < 10 ? ("0" + m) : ("" + m);
        return strHour + ":" + strMin;
    }

    public static void main(String[] args) {
        System.out.println(nextClosestTime("23:59"));
        System.out.println(nextClosestTime("23:59").equals("22:22"));
    }
}
