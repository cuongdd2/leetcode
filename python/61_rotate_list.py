class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


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


def printList(head):
    while head:
        print(head.val, end="--")
        head = head.next
    print("NULL")


def test():
    head = node = ListNode(0)
    for i in range(1, 5):
        node.next = ListNode(i)
        node = node.next
    printList(head)
    head = rotateRight(head, 2)
    printList(head)


test()
