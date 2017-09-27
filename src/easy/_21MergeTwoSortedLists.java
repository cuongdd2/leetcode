package easy;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by
 * splicing together the nodes of the first two lists.
 *
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
public class _21MergeTwoSortedLists {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);
    ListNode l2 = new ListNode(5);
    ListNode rs = mergeTwoLists(l1, l2);
    System.out.println(rs);
  }

  public static ListNode mergeSimple(ListNode l1, ListNode l2) {
    ListNode root = null;
    ListNode node = null;
    ListNode next = null;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        next = l1;
        l1 = l1.next;
      } else {
        next = l2;
        l2 = l2.next;
      }
      if (root == null) root = node = next;
      else {
        node.next = next;
        node = next;
      }
    }
    if (l1 != null) next = l1;
    if (l2 != null) next = l2;

    if (node == null) root = next;
    else node.next = next;

    return root;
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }
}

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}
