/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        // assume B is longer
        if (lenA > lenB) { // don't put lenA >= lenB, otherwise, always loop
            return getIntersectionNode(headB, headA);
        }
        int diff = lenB - lenA;
        ListNode curA = headA, curB = headB;
        for (int i = 0; i < diff; i++) {
            curB = curB.next;
        }
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
