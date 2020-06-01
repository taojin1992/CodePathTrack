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
    // before checking answer
    public ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddHead = head, evenHead = head.next;
        ListNode oddCur = oddHead, evenCur = evenHead;
        while (oddCur != null && evenCur != null && oddCur.next != null && evenCur.next != null) {
            oddCur.next = oddCur.next.next;
            evenCur.next = evenCur.next.next;
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        oddCur.next = evenHead;
        return oddHead;
    }
    
    // optimize
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode oddHead = head, evenHead = head.next;
        ListNode oddCur = oddHead, evenCur = evenHead;
        while (evenCur != null && evenCur.next != null) {
            oddCur.next = oddCur.next.next;
            evenCur.next = evenCur.next.next;
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        oddCur.next = evenHead;
        return oddHead;
    }
}
