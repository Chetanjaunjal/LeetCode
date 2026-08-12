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
    public ListNode rotateRight(ListNode head, int k) {
       if(head == null || head.next == null) return head;
        int length = 0;
        ListNode temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        if(k == 0) return head;
        k = k % length;
       
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i<k; i++){
            fast = fast.next;
        }
      if(fast == null) return head;

      while(fast.next != null){
        fast = fast.next;
        slow = slow.next;
      }

      fast.next = head;
      head = slow.next;
      slow.next = null;
      return head;
    }
}