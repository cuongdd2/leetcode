class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def init(n, rnd=False):
    import random
    head = node = ListNode(0)
    x = 1
    for i in range(1, n):
        x = int(random.random() + x + 0.5) if rnd else i
        node.next = ListNode(x)
        node = node.next
    return head


def printList(head):
    while head:
        print(head.val, end="--")
        head = head.next
    print("NULL")
