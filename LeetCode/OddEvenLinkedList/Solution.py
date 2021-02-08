# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        odd = odd_cursor = ListNode(None)
        even = even_cursor = ListNode(None)

        cursor = head

        is_eventh = False
        while cursor:
            if is_eventh:
                even_cursor.next = cursor
                even_cursor = even_cursor.next
            else:
                odd_cursor.next = cursor
                odd_cursor = odd_cursor.next
            cursor = cursor.next
            is_eventh = not is_eventh
            
        odd_cursor.next = even.next
        even_cursor.next = None

        return odd.next
