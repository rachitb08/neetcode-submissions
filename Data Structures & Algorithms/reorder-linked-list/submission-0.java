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
    public void reorderList(ListNode head) {
        // find the midpoint
        // reverse the second half
        // merge the first and udpated second half

        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l2 = reverse(slow);
        ListNode l1 = head;
        head = merge(l1, l2);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, nextNode = null;

        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            prev.next = l1;
            l1 = l1.next;
            prev = prev.next;
            prev.next = l2;
            l2 = l2.next;
            prev = prev.next;
        }
        return dummy.next;
    }
}
