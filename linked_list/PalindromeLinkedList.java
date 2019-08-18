public class PalindromeLinkedList{
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        ListNode p1 = pre;
        ListNode p2 = null;
        if(fast == null){
            p2 = slow;
        } else if(fast.next == null){
            p2 = slow.next;
        }

        while(p1 != null && p2!= null){
            if(p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
