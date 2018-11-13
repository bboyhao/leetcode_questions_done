/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
    	ListNode start = new ListNode(0);
    	ListNode cur;
    	ListNode first;
    	ListNode second;
    	ListNode next;

    	cur = start;
    	start.next = head;
    	while(cur.next != null){
    		first = cur.next;
    		if(first.next == null) break;
    		second = first.next;
    		next = second.next;
    		cur.next = second;
    		second.next = first;
    		first.next = next;
    		cur = next;
    	}
    	return start.next;
    }
}