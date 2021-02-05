# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        cursor = head
        prev = None

        while cursor:
            cursor, prev, prev.next = cursor.next, cursor, prev

        return prev
