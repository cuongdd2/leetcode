public class Prob1 {

  public static void main(String[] args) {
    Prob1 me = new Prob1();
    int A = 102;
    int B = 6;
    System.out.println(me.solution(A, B));
  }

  public int solution(int A, int B) {
    long zip = 0;
    long a = reverse(A);
    long b = reverse(B);
    while (a > 0 && b > 0) {
      zip = zip * 10 + a % 10;
      a /= 10;

      zip = zip * 10 + b % 10;
      b /= 10;
    }
    while (a > 0) {
      zip = zip * 10 + a % 10;
      a /= 10;
    }
    while (b > 0) {
      zip = zip * 10 + b % 10;
      b /= 10;
    }
    return zip > 100000000 ? -1 : (int)zip;
  }

  long reverse(int a) {
    long rev = 0;
    while (a > 0) {
      rev = rev * 10 + a % 10;
      a /= 10;
    }
    return rev;
  }

}
