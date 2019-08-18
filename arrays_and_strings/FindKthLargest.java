import java.util.*;

public class FindKthLargest{
    //整个array 排序，找出第k大的数
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    //use the idea of quick sort
    public int findKthLargest2(int[] nums, int k){
        return selectKthLargest(nums, 0, nums.length-1, k);
    }

    private int selectKthLargest(int[] nums, int low, int high, int k){
        int pivot = low;
        for(int i = low; i<high; i+=1){
            if(nums[i] <= nums[high]){
                swap(nums, pivot++, i);
            }
        }
        swap(nums, pivot, high);

        int count = high - pivot +1;
        if(count == k) return nums[pivot];
        else if(count > k) {
            return selectKthLargest(nums, pivot + 1, high, k);
        } else{
            return selectKthLargest(nums, low, pivot - 1, k - count);
        }
    }

    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
