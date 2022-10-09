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
    public int numComponents(ListNode head, int[] nums) {
        HashMap<Integer,Boolean> hash = new HashMap<Integer,Boolean>();
        for (int num : nums) {
            hash.put(num,true);
        }
        ListNode p = head;
        int sum = 0;
        boolean isInPiece = false;
        while (p!=null) {
            if (hash.containsKey(p.val)) {
                isInPiece = true;
            }
            else {
                if (isInPiece) {
                    sum++;
                    isInPiece = false;
                }
            }
            p = p.next;
        }
        if (isInPiece) {
            sum++;
        }
        return sum;
    }
}