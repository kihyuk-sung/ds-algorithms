from typing import List

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if len(lists) == 0:
            return None

        result = result_cursor = ListNode(None)

        compare: List[ListNode] = []

        for node in lists:
            if node:
                compare.append(node)
        
        while compare:
            min = compare[0].val
            idx = 0

            for i, cur in enumerate(compare):
                if min > cur.val:
                    min = cur.val
                    idx = i
                
            cursor = compare.pop(idx)
            result_cursor.next = cursor

            if cursor.next:
                compare.append(cursor.next)

            result_cursor = result_cursor.next

        return result.next
