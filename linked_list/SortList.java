public class SortList{
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, slow = head, fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode first = sortList(head);
        ListNode second = sortList(slow);

        ListNode result = merge(first, second);
        return result;
    }

    public ListNode merge(ListNode first, ListNode second){
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while(first != null && second != null){
            if(first.val>second.val){
                cur.next = first;
                cur = cur.next;
                first = first.next;
            } else {
                cur.next = second;
                cur = cur.next;
                second = second.next;
            }
        }
        if(first == null){
            cur.next = second;
        } else{
            cur.next = first;
        }
        return result.next;
    }
}
