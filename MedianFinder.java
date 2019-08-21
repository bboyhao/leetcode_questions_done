import java.util.*;

public class MedianFinder{
    // use two heaps: one minimising heap and one maximising heap
    private PriorityQueue<Integer> pq1;
    private PriorityQueue<Integer> pq2;
    private boolean isEven = true;

    /** initialize your data structure here. */
    public MedianFinder() {
        pq1 = new PriorityQueue<>(Collections.reverseOrder());
        pq2 = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(isEven){
            pq2.offer(num);
            pq1.offer(pq2.poll());
        }else{
            pq1.offer(num);
            pq2.offer(pq1.poll());
        }
        isEven = !isEven;
    }

    public double findMedian() {
        if(isEven){
            return (pq1.poll()+pq2.poll()) / 2.0;
        }
        return (double) pq1.poll();
    }
}
