package RemoveDuplicatesFromSortedList;

//Definition for singly-linked list.

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = null;
        if (head != null) {
            pointer = head.next;
        } else {
            return head;
        }
        ListNode prev = head;
        boolean checkDuplicates = false;
        int val = 200;
        while (pointer != null) {
            if (prev.val == pointer.val) {
                // delete
                prev.next = pointer.next;
                pointer.next = null;
                pointer = prev;
            }
            prev = pointer;
            pointer = pointer.next;
        }
        return head;
    }
}