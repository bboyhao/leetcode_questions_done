import java.util.*;

public class FindUnsortedSubarray{
    //sort first and then compare
    //Time: O(nlog(n)) Space: O(n)
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            copy[i] = nums[i];
        }
        Arrays.sort(copy);
        int start = 0;
        int end = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != copy[i]){
                start = i;
                break;
            }
        }
        for(int i = nums.length-1; i>=0; i--){
            if(nums[i] != copy[i]){
                end = i;
                break;
            }
        }
        if(end == start) return 0;
        return end - start + 1;
    }

    //Time: O(n) Space: O(1)
    public int findUnsortedSubarray2(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] < nums[i-1]){
                flag = true;
            }
            if(flag){
                min = Math.min(min, nums[i]);
            }
        }
        flag = false;
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i] > nums[i+1]) {
                flag = true;
            }
            if(flag){
                max = Math.max(max, nums[i]);
            }
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i<nums.length; i++){
            if(min < nums[i]){
                start = i;
                break;
            }
        }
        for(int i = nums.length -1; i>=0; i--){
            if(max > nums[i]){
                end = i;
                break;
            }
        }
        return start == end?0:end-start+1;
    }
}
