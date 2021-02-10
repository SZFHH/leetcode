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

 /**
  * 自底向上
  * 自顶向下也可以
  */
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        int cnt = 0;
        for(ListNode t = head; t!=null; t = t.next){
            cnt++;
        }
        for(int len = 1; len < cnt; len<<=1) {
            ListNode cur = dummy.next, prev = dummy;
            while(cur!=null) {
                ListNode h1 = cur;
                for(int i=1; i<len && cur!=null; ++i) {
                    cur = cur.next;
                }
                ListNode temp=null;
                if(cur!=null) {
                    temp = cur.next;
                    cur.next = null;
                }
                cur = temp;
                ListNode h2 = cur;
                temp = null;
                for(int i=1; i<len && cur!=null; ++i) {
                    cur = cur.next;
                }
                if(cur!=null) {
                    temp = cur.next;
                    cur.next = null;
                }
                prev.next = merge(h1, h2);
                while(prev.next!=null) {
                    prev=prev.next;
                }
                cur = temp;

            }
        }
        return dummy.next;
    }
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(l1 !=null && l2!=null) {
            if(l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1!=null) {
            cur.next = l1;
        }
        if(l2!=null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}



    