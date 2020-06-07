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
    private int getLen(ListNode head) {
        if (head == null) return 0;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if (k < 0 || head == null) return null;
        int val = k % getLen(head);
        if (val == 0) return head;
        ListNode cur = head;
        ListNode fast = head;
        for (int i = 0; i < val; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            cur = cur.next;
            fast = fast.next;
        }
        ListNode temp = cur.next;
        cur.next = fast.next;
        fast.next = head;
        head = temp;
        return head;
    }
}
