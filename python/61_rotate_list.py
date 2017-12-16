from utils import *


def rotateRight(head, k):
    """
    :type head: ListNode
    :type k: int
    :rtype: ListNode
    """
    if head == None:
        return head
    A = [head]
    while head.next:
        head = head.next
        A.append(head)
    head.next = A[0]
    n = len(A)
    head = A[n - k % n - 1].next
    A[n - k % n - 1].next = None

    return head


def test():
    head = init(5)
    printList(head)
    head = rotateRight(head, 2)
    printList(head)


test()
