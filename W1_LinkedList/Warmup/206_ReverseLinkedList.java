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
    // iterative 
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    
    // recursive
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        return reverse(head, null);
    }
    
    // tail recursion space O(1)
    private ListNode reverse(ListNode cur, ListNode pre) {
        if (cur.next == null) {
            cur.next = pre;
            return cur;
        }
        ListNode nextNode = cur.next;
        cur.next = pre;
        return reverse(nextNode, cur);
    }
}
