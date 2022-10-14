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
        ListNode p = head;
        int n = 0;
        while (p!=null) {
            n++;
            p = p.next;
        }
        int[] res = new int[n/2];
        p = head;
        int j = 0;
        int max = -1;
        while (p!=null) {
            if (j<n/2) {
                res[j] = p.val;
            }
            else {
                res[n-j-1] += p.val;
                if (res[n-j-1]>max) {
                    max = res[n-j-1];
                }
            }
            p = p.next;
            j++;
        }
        return max;

    }
}