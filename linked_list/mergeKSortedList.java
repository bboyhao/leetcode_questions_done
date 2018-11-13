/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        int end = lists.length - 1;
        while(end > 0){
        	int begin =0;
        	while(begin < end){
        		lists[begin] = mergeTwoLists(lists[begin], lists[end]);
        		end--;
        		begin++;
        	}
        }
        return lists[0];

    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
    	ListNode head = new ListNode(0);
        ListNode cur = head;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val || l1.val == l2.val)
            {
                cur.next = l1;
                l1 = l1.next;
            }
            else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null)
        {
            cur.next = l2;
        }
        else
        {
            cur.next = l1;
        }
        return head.next;
    }
}