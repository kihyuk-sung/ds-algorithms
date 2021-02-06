# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        l1_cursor = l1
        l2_cursor = l2

        l1_prev = None
        l2_prev = None

        carry = 0

        while l1_cursor and l2_cursor:
            l1_cursor.val += l2_cursor.val + carry
            carry = l1_cursor.val // 10
            l1_cursor.val %= 10

            l1_prev = l1_cursor
            l2_prev = l2_cursor

            l1_cursor = l1_cursor.next
            l2_cursor = l2_cursor.next

        if not l1_cursor:
            l1_prev.next = l2_prev.next
            l1_cursor = l2_prev.next
        
        while l1_cursor:
            l1_cursor.val += carry
            carry = l1_cursor.val // 10
            l1_cursor.val %= 10

            l1_prev = l1_cursor

            l1_cursor = l1_cursor.next

        if carry > 0:
            l1_prev.next = ListNode(carry)
        
        return l1
