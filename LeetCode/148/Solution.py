# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        if not (head and head.next):
            return head
        half, slow, fast = None, head, head
        while fast and fast.next:
            half, slow, fast = slow, slow.next, fast.next.next
        half.next = None

        l1 = self.sortList(head)
        l2 = self.sortList(slow)
        return self.merge(l1, l2)
        
    def merge(self, l1: ListNode, l2: ListNode) -> ListNode:
        result_ptr = result = ListNode()
        while l1 and l2:
            if l1.val < l2.val:
                result_ptr.next = l1
                l1 = l1.next
            else:
                result_ptr.next = l2
                l2 = l2.next
            result_ptr = result_ptr.next
        result_ptr.next = l1 or l2
        return result.next
