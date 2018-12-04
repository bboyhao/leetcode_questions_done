/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null) return head;
        int length = 0;
        ListNode h = head;
        while(h != null){h = h.next;length+=1;}
        h = head;
        int loop = length / k;
        ListNode first = head;
        ListNode second = first.next;
        ListNode tmp = null;
        ListNode previous_h = null;
        for(int j = 0; j<loop; j+=1){
            for(int i = 0; i < k-1; i+=1){
                 tmp = second.next;
                 second.next = first;
                 first = second;
                 second = tmp;
            }
            if(j==0) head = first;
            else previous_h.next = first;
            h.next = second;
            if(second == null) return head;
            previous_h = h;
            h = second;
            first = second;
            second = first.next;
        }
        return head;
    }
}
