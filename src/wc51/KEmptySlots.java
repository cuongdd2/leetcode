package wc51;

/**
 * There is a garden with N slots. In each slot, there is a flower. The N flowers will bloom one by one in N days.
 * In each day, there will be exactly one flower blooming and it will be in the status of blooming since then.

 Given an array flowers consists of number from 1 to N.
 Each number in the array represents the place where the flower will open in that day.

 For example, flowers[i] = x means that the unique flower that blooms at day i will be at position x,
 where i and x will be in the range from 1 to N.

 Also given an integer k, you need to output in which day there exists two flowers in the status of blooming,
 and also the number of flowers between them is k and these flowers are not blooming.

 If there isn't such day, output -1.

 Example 1:
 Input:
 flowers: [6,5,8,9,7,1,10,2,3,4]
 k: 2
 Output: 8
 Note:
 The given array will be in the range [1, 20000].
 * */
public class KEmptySlots {
    public static void main(String[] args) {
        int[] flowers = {6,5,8,9,7,1,10,2,3,4};// expected: 8
        int k = 2;
        System.out.println(kEmptySlots(flowers, k));
    }

    public static int kEmptySlots(int[] flowers, int k) {
        final int N = flowers.length;
        boolean[] bloomed = new boolean[N];
        for (int i = 0; i < N - k; i++) {
            // bloom day < N - k because we need next k day > bloom day
            int day = i + 1;
            int pot = flowers[i];
            bloomed[pot - 1] = true;
            int index = pot + k;
            if (index < N && bloomed[index]) {
                boolean found = true;
                for (int j = pot; j < index; j++) {
                    if (bloomed[j]) {
                        found = false;
                        break;
                    }
                }
                if (found) return day;
            }
            index = pot - k - 2;
            if (index >= 0 && bloomed[index]) {
                boolean found = true;
                for (int j = index + 1; j < pot - 1; j++) {
                    if (bloomed[j]) {
                        found = false;
                        break;
                    }
                }
                if (found) return day;
            }
        }
        return -1;
    }
}
