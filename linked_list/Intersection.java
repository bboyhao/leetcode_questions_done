public class Intersection{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode first = headA;
        int count1 = 0;
        while(first != null){
            count1++;
            first = first.next;
        }

        ListNode second = headB;
        int count2 = 0;
        while(second != null){
            count2++;
            second = second.next;
        }
        if(count1 > count2){
            for(int i = 0;i<count1-count2; i++){
                headA = headA.next;
            }
        }else if(count2 > count1){
            for(int i = 0;i<count2-count1; i++){
                headB = headB.next;
            }
        }
        while(headA!=null && headB!=null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
