from collections import deque
from typing import Deque

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        q: Deque = deque()

        p = head

        while p is not None:
            q.append(p.val)
            p = p.next
        
        while len(q) > 1:
            if q.popleft() != q.pop():
                return False
            
        return True
