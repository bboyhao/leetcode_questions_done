import java.util.*;

public class SlidingWindowMaximum{
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null||k<=1) return nums;
        int length = nums.length;
        int[] result = new int[length-k+1];
        int index = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0;i<length;i++){
            while(!dq.isEmpty() && dq.peek() <= i-k){
                dq.poll();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }

            dq.offer(i);
            if(i >= k-1){
                result[index++] = nums[dq.peek()];
            }
        }
        return result;
    }
}
