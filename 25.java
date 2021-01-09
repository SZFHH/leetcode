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
        ListNode rv = new ListNode(0, head),pre=rv,cur=pre.next,h=cur;
        ListNode temp;
        while(isok(pre, k)){
            for(int i=0;i<k;++i){
                temp = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur =temp;
            }
            pre = h;
            pre.next = cur;
            h = cur;
        }
        return rv.next;
    }

    public boolean isok(ListNode pre, int k){
        ListNode cur = pre.next;
        for(int i=0;i<k;++i){
            if(cur==null) return false;
            cur = cur.next;
        }
        return true;
    }
}