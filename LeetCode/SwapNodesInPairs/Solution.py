# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:

        if not head or not head.next:
            return head
        
        result = head.next
        cursor = head
        prev = ListNode(0)
        while cursor and cursor.next:
            prev.next = cursor.next
            cursor.next.next, cursor.next = cursor, cursor.next.next
            prev, cursor = cursor, cursor.next
            

        return result
