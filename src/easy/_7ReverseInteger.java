package easy;

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p>
 * click to show spoilers.
 * <p>
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class _7ReverseInteger {
    public static void main(String[] args) {
        int x = 1234;
        System.out.println(reverse(x) == 4321);
    }

    public static int reverse(int x) {
        int result = 0;
        for (int i = x; i != 0; i /= 10) {
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) return 0;
            result = result * 10 + i % 10;
        }
        return result;
    }
}
