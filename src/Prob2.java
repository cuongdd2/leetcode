import java.util.ArrayList;

public class Prob2 {

  public static void main(String[] args) {
    Prob2 me = new Prob2();
    int[] a = new int[] {1, 2, 4, 5, 7, 29, 30};
    System.out.println(me.minimumCost(a));
    System.out.println(me.solution(0, 0, 7, 1));
  }

  public String solution(int A, int B, int C, int D) {
    int[] a = new int[]{A, B, C, D};
    ArrayList<Integer> possible = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        for (int k = 0; k < 4; k++) {
          for (int l = 0; l < 4; l++) {
            if (i != j && i != k && i != l && j != k && j != l && k != l) {
              possible.add(a[i] * 1000 + a[j] * 100 + a[k] * 10 + a[l]);
            }
          }
        }
      }
    }

    for (int h = 23; h >= 0; h--) {
      for (int m = 59; m >= 0; m--) {
        if (possible.contains(h * 100 + m)) {
          return String.format("%02d:%02d", h, m);
        }
      }
    }
    return "NOT POSSIBLE";
  }

  int minimumCost(int[] A) {
    int n = A.length;
    int[] dp = new int[n + 1];
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      dp[i] = dp[i - 1] + 2;
      int j = i - 1;
      while (j >= 1 && A[j - 1] >= A[i - 1] - 6) {
        j--;
      }
      dp[i] = Math.min(dp[i], dp[j] + 7);
    }

    return Math.min(dp[n], 25);
  }


}
