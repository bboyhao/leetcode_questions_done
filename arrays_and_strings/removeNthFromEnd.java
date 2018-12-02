/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while(cur!=null){
            list.add(cur);
            cur = cur.next;
        }
        int size = list.size();
        if(n==size){
            head = head.next;
        }
        else if(n==1){
            ListNode secondLast = list.get(size-2);
            secondLast.next = null;
        }
        else{
            ListNode previous = list.get(size-n-1);
            ListNode next = list.get(size-n+1);
            previous.next = next;
        }
        return head;

    }
}
