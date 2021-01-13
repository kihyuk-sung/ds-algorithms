package LinkedListCycle;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fastRunner = null;
        ListNode slowRunner = null;

        if (head != null) {
            slowRunner = head;
            fastRunner = head;
        } else {
            return false;
        }

        boolean isMatch = false;
        while (!isMatch) {
            fastRunner = fastRunner.next;
            if (fastRunner != null) {
                fastRunner = fastRunner.next;
                if (fastRunner == null) {
                    return false;
                }
            } else {
                return false;
            }
            slowRunner = slowRunner.next;
            if (slowRunner == fastRunner) {
                isMatch = true;
            }
        }
        return true;
    }
}