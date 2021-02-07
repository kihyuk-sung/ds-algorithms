# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        cursor = head
        while cursor and cursor.next:
            cursor.val, cursor.next.val = cursor.next.val, cursor.val
            cursor = cursor.next.next

        return head