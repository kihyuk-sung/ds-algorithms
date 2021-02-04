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
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        left = l1
        right = l2

        merged = ListNode()
        if not left:
            return right
        elif not right:
            return left
        
        cursor = merged
        while left and right:
            if left.val > right.val:
                cursor.next = right
                right = right.next
            else:
                cursor.next = left
                left = left.next
            cursor = cursor.next
            
        if left:
            cursor.next = left
        elif  right:
            cursor.next = right

        return merged.next