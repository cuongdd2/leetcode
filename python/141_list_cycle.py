def hasCycle(head):
    """
    :type head: ListNode
    :rtype: bool
    """
    slow, fast = head, head
    while fast and fast.next:
        slow, fast = slow.next, fast.next.next
        if slow is fast:
            return True
    return False


def hasCycle2(head):

    return False


from utils import *


def test():
    head = init(4)
    head.next.next.next.next = head.next
    printList(head)
    c = hasCycle(head)
    print(c)


test()
