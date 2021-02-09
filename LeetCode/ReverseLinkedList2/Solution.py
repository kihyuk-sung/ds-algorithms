# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        idx = 1
        cursor = head
        prev = ListNode(None)
        reverse_tail = None
        reverse_head = None
        while cursor:
            next = cursor.next
            if idx == m:
                reverse_tail = cursor
                reverse_head = prev
            if m < idx and idx <= n:
                cursor.next = prev

            if idx == n:
                reverse_tail.next = next
                reverse_head.next = cursor

            prev = cursor
            cursor = next
            idx += 1

        if m == 1:
            return reverse_head.next

        return head
