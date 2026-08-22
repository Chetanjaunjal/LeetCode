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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergelist = new ListNode(-1);
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode mergetemp = mergelist;
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                mergetemp.next = temp1;
                mergetemp = mergetemp.next; 
                temp1 = temp1.next;   
            }else{
                mergetemp.next = temp2;
                mergetemp = mergetemp.next;
                temp2 = temp2.next;
            }        
        }
        while(temp1 != null){
            mergetemp.next = temp1;
            mergetemp = mergetemp.next;
            temp1 = temp1.next;

        } 
        while(temp2 != null){
            mergetemp.next = temp2;
            mergetemp = mergetemp.next;
            temp2 = temp2.next;
        }
        mergetemp.next = null;
        return mergelist.next;
    }
}