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
    // before optimization
    public ListNode addTwoNumbers1 (ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null && cur2 != null) {          
            cur.next = new ListNode((cur1.val + cur2.val + carry) % 10);
            carry = (cur1.val + cur2.val + carry) / 10;
            cur1 = cur1.next;
            cur2 = cur2.next;
            cur = cur.next;            
        }
        while (cur1 != null) {           
            cur.next = new ListNode((cur1.val + carry) % 10);
            carry = (cur1.val + carry) / 10;
            cur1 = cur1.next;
            cur = cur.next;            
        }
        while (cur2 != null) {            
            cur.next = new ListNode((cur2.val + carry) % 10);
            carry = (cur2.val + carry) / 10;
            cur2 = cur2.next;
            cur = cur.next;          
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
    
    
    public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null || cur2 != null) { 
            int x = (cur1 != null) ? cur1.val : 0;
            int y = (cur2 != null) ? cur2.val : 0;
            cur.next = new ListNode((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
            if (cur1 != null) cur1 = cur1.next;
            if (cur2 != null) cur2 = cur2.next;
            cur = cur.next;            
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
    
}
