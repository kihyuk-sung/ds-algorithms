# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def insert(self, head: ListNode, node: ListNode):
        cur = head.next
        prev = head
        val = node.val
        while cur:
            if cur.val > val:
                node.next = cur
                prev.next = node
                return
            prev, cur = cur, cur.next
        prev.next = node
        return

    def insertionSortList(self, head: ListNode) -> ListNode:
        if not head:
            return head
        sentinel = ListNode(None)

        cur = head
        while cur:
            next = cur.next
            cur.next = None
            self.insert(sentinel, cur)
            cur = next

        return sentinel.next
