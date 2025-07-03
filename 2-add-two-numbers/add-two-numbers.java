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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dummy = new ListNode(0);
       ListNode temp =dummy;
       int carry =0;
       while(l1 != null || l2 !=null){
               int sum =0;
        if (l1 != null) sum += l1.val;
        if (l2 != null) sum += l2.val;
        sum += carry;
        temp.next = new ListNode(sum % 10);
        temp = temp.next;
       if (l1 != null) l1 = l1.next;
        if (l2 != null) l2 = l2.next;
        carry = sum/10;
        }
        if (carry > 0) {
    temp.next = new ListNode(carry);
}
     return dummy.next ;

       }
}

    