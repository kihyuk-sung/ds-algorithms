# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        l = []

        p = head

        while p is not None:
            l.append(p.val)
            p = p.next
        
        while len(l) > 1:
            if l.pop(0) != l.pop():
                return False
            
        return True
