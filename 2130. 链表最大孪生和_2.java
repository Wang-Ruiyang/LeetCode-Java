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
    public int pairSum(ListNode head) {
        Deque<Integer> dq = new LinkedList<Integer>();
        ListNode p = head;
        while (p!=null) {
            dq.addLast(p.val);
            p = p.next;
        }
        int max = -1;
        while (!dq.isEmpty()) {
            max = Math.max(max, dq.pollFirst()+dq.pollLast());
        }
        return max;
    }
}