import java.util.Hashtable;

public class LRUCache{
    private int count;
    private int capacity;
    private Hashtable<Integer, ListNode> hTable;
    private DoubleLinkedList l;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        this.hTable = new Hashtable<>();
        this.l = new DoubleLinkedList();
    }

    public int get(int key) {
        ListNode n = hTable.getOrDefault(key, null);
        if(n == null) {
            return -1;
        }
        this.l.removeNode(n);
        this.l.addNode(n);
        return n.val;
    }

    public void put(int key, int value) {
        if(hTable.containsKey(key)){
            ListNode n = hTable.get(key);
            n.val = value;
            l.removeNode(n);
            l.addNode(n);
        }else{
            ListNode n = new ListNode(key, value);
            hTable.put(key, n);
            l.addNode(n);
            this.count += 1;
            if (this.count > this.capacity){
                hTable.remove(l.removeLast());
                this.count -= 1;
            }
        }
        for(int k:hTable.keySet()){
            System.out.printf("%d --> %d\n", k, hTable.get(k).val);
        }
        System.out.println();
    }

    private class ListNode{
        int key;
        int val;
        ListNode next;
        ListNode prev;
        public ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private class DoubleLinkedList{
        private ListNode head;
        private ListNode tail;

        public DoubleLinkedList(){
            head = new ListNode(0,0);
            tail = head;
            head.prev = null;
            head.next = null;
        }

        public void printList(){
            ListNode tmp = head;
            while(tmp != null){
                System.out.printf("(%d, %d)-->", tmp.key, tmp.val);
                tmp = tmp.next;
            }
            System.out.println();
        }

        public ListNode removeNode(ListNode n){
            ListNode before = n.prev;
            ListNode after = n.next;
            before.next = after;
            if(after != null){
                after.prev = before;
            }else{
                this.tail = before;
            }
            printList();
            return n;
        }


        public void addNode(ListNode n){
            ListNode second = this.head.next;
            this.head.next = n;
            n.prev = head;
            n.next = second;
            if(second != null) {
                second.prev = n;
            }else{
                this.tail = n;
            }
            printList();
        }

        public int removeLast(){
            ListNode tmp = removeNode(this.tail);
            printList();
            return tmp.key;
        }
    }
}
