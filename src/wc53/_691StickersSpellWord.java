package wc53;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * We are given N different types of stickers. Each sticker has a lowercase English word on it.

 You would like to spell out the given target string by cutting individual letters from your collection of stickers and rearranging them.

 You can use each sticker more than once if you want, and you have infinite quantities of each sticker.

 What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.

 Example 1:

 Input:

 ["with", "example", "science"], "thehat"
 Output:

 3
 Explanation:

 We can use 2 "with" stickers, and 1 "example" sticker.
 After cutting and rearrange the letters of those stickers, we can form the target "thehat".
 Also, this is the minimum number of stickers necessary to form the target string.
 Example 2:

 Input:

 ["notice", "possible"], "basicbasic"
 Output:

 -1
 Explanation:

 We can't form the target "basicbasic" from cutting letters from the given stickers.
 Note:

 stickers has length in the range [1, 50].
 stickers consists of lowercase English words (without apostrophes).
 target has length in the range [1, 15], and consists of lowercase English letters.
 In all test cases, all words were chosen randomly from the 1000 most common US English words,
 and the target was chosen as a concatenation of two random words.
 The time limit may be more challenging than usual.
 It is expected that a 50 sticker test case can be solved within 35ms on average.
 * */
public class _691StickersSpellWord {

  public static void main(String[] args) {
    _691StickersSpellWord me = new _691StickersSpellWord();
    String[] sticker = new String[]{"with", "example", "science"};
    String target = "thehat";
    System.out.println(me.minStickers(sticker, target));
  }

  public int minStickers(String[] stickers, String target) {
    int[] alphabet = new int[26];
    for (char c : target.toCharArray()) {
      alphabet[c - 97]++;
    }
    int[][] map = new int[stickers.length][26];
    for (int i = 0; i < stickers.length; i++) {
      for (char c : stickers[i].toCharArray()) {
        map[i][c - 97]++;
      }
    }

    List<Integer> words = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      if (alphabet[i] > 0) {
        boolean found = false;
        int min = 100;
        for (int j = 0; j < stickers.length; j++) {
          if (map[j][i] > 0) {
            found = true;
            min = Math.min(min, Math.max(1, alphabet[i]/map[j][i]));
          }
        }
        if (!found) return -1;
        else words.add(min);
      }
    }

    for (int i = 0; i < stickers.length; i++) {

    }

    return words.stream().mapToInt(value -> value).sum();
  }

  int compare(int[] target, int[] dict) {
    int sum = 0;
    for (int i = 0; i < 26; i++) {
      if (target[i] > 0) {
        sum += Math.max(0, target[i] - dict[i]);
      }
    }
    return sum;
  }
}
