public class LinkedListCycle2{
    public ListNode detectCycle(ListNode head){
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        do{
            fast = fast.next;
            if(fast == null) return null;
            fast = fast.next;
            if(fast == null) return null;
            slow = slow.next;
        }while(fast != slow);
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
