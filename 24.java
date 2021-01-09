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
    public ListNode swapPairs(ListNode head) {
        ListNode rv = new ListNode(0, head),h=rv;
        ListNode a,b;
        while((a=h.next)!=null && (b=h.next.next)!=null){
            a.next = b.next;
            b.next = a;
            h.next = b;
            h = h.next.next;
        }
        return rv.next;
    }
}