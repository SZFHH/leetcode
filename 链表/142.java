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
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode f1 = head, f2 = head;
        while(f2 != null) {
            f1 = f1.next;
            if(f2.next!=null) {
                f2 = f2.next.next;
            } else {
                return null;
            }
            if(f1==f2) {
                ListNode f3 = head;
                while(f3!=f1) {
                    f1 = f1.next;
                    f3 = f3.next;
                }
                return f3;
            }
        }
        return null;
    }
}