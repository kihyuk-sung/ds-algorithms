# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        lst = []
        p = head
        while p:
            lst.append(p.val)
            p = p.next
        
        lst.sort()

        p = head
        for val in lst:
            p.val = val
            p = p.next
        return head
