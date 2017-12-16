from utils import *


def deleteDuplicates(head):
    """
    :type head: ListNode
    :rtype: ListNode
    """
    node = head
    while node and node.next:
        if node.val == node.next.val:
            node.next = node.next.next
        else:
            node = node.next

    return head


def test():
    head = init(10, True)
    printList(head)
    deleteDuplicates(head)
    printList(head)


test()
