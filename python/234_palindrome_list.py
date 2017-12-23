def isPalindrome(head):
    """
    :type head: ListNode
    :rtype: bool
    """
    if not head:
        return True

    slow = fast = head
    while fast and fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next
    head_rev = None
    mid = slow.next
    while mid:
        temp = mid.next
        mid.next = head_rev
        head_rev = mid
        mid = temp
    while head and head_rev and head != head_rev:
        if head.val != head_rev.val:
            return False
        head = head.next
        head_rev = head_rev.next
    return True


from utils import *

head = fromStr("")
printList(head)
s = isPalindrome(head)
print(s)
