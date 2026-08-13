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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddnode = new ListNode(0);
        ListNode evennode = new ListNode(0);
        ListNode odd = oddnode;
        ListNode even = evennode;
        int cnt = 0;
        ListNode temp = head; 
        while(temp != null){
            if(cnt % 2 != 0){
                odd.next = temp;
                odd = odd.next;
            } else {
                even.next = temp;
                even = even.next;
            }
            cnt++;
            temp = temp.next;
        }
        even.next = oddnode.next;
        odd.next = null;

        return evennode.next;
    }
}