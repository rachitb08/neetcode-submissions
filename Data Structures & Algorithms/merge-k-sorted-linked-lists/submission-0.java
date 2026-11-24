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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }
            curr.next = node;
            curr = curr.next;
        }
        return dummy.next;
    }
}
