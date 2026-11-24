/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // check whether k nodes exist
        ListNode curr = head;
        for (int i=0;i<k;i++) {
            if (curr == null) {
                return head;
            }
            curr = curr.next;
        }
        // reverse current k nodes
        ListNode prev = null; 
        curr = head;
        for (int i=0;i<k;i++) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // recursively reverse remaining list
        head.next = reverseKGroup(curr, k);
        // Return new head of reversed group
        return prev;
    }
}
