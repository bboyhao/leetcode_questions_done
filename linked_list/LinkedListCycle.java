public class LinkedListCycle{
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            if(fast == null) break;
            slow = slow.next;
            if(fast.val == slow.val){
                return true;
            }
            
        }
        return false;
    }
}
