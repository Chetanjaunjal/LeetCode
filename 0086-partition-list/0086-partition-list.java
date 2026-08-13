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
    public ListNode partition(ListNode head, int x) {
        ListNode lessnode = new ListNode(0);
        ListNode greatnode = new ListNode(0);
        ListNode tl = lessnode;
        ListNode tg = greatnode;
        ListNode temp = head;
        while(temp != null){
            if(temp.val < x){
                tl.next = temp;
                tl = tl.next;
            } else {
                tg.next = temp;
                tg = tg.next;
            }
            temp = temp.next;
        }
        tl.next = greatnode.next;
        tg.next = null;

        return lessnode.next;
    }
}