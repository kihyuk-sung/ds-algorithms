class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def LinkedListToNum(self, l1: ListNode) -> int:
        num = 0
        mul = 1

        head = l1

        while head:
            num += mul * head.val
            head = head.next
            mul *= 10
        
        return num


    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        a = self.LinkedListToNum(l1)
        b = self.LinkedListToNum(l2)
        
        result = a + b

        head = cursor = ListNode(0)
        while result:
            cursor.next = ListNode(result % 10)
            result //= 10
            cursor = cursor.next

        if not head.next:
            return head
        else:
            return head.next
