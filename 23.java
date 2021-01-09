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
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode o1, ListNode o2){
                return o1.val-o2.val;
            }
        });
        ListNode rv = new ListNode(),h=rv;
        for(ListNode l:lists){
            if(l==null) continue;
            q.add(l);
        }
        while(!q.isEmpty()){
            ListNode l = q.poll();
            if(l.next!=null){
                q.add(l.next);
            }
            h.next = l;
            h = h.next; 
        }
        return rv.next;
    }
}