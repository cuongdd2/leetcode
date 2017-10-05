package medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */
public class _2AddTwoNumbers {

  public static void main(String[] args) {
    _2AddTwoNumbers me = new _2AddTwoNumbers();
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);
    System.out.println(l1);
    System.out.println(l2);
    ListNode n = me.addTwoNumbers(l1, l2);
    System.out.println(n);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode node = new ListNode(0);
    ListNode fakeRoot = node;
    int total = 0;
    while (l1 != null || l2 != null) {
      if (l1 != null) {
        total += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        total += l2.val;
        l2 = l2.next;
      }
      node.next = new ListNode(total % 10);
      total /= 10;
      node = node.next;
    }
    if (total > 0) node.next = new ListNode(1);
    return fakeRoot.next;
  }


}

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    ListNode node = this;
    String s = "";
    while (node != null) {
      s += node.val + " - ";
      node = node.next;
    }
    return s;
  }
}