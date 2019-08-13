import java.util.Arrays;

public class MaximumProductSubarray{
    //Time Complexity: O(N), Space Complexity: O(1)
    public int maxProduct(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int max = nums[0], min = nums[0], result = nums[0];
        for(int i = 1; i<nums.length; i++){
            int tmp = max;
            max = Math.max(Math.max(nums[i]*max, nums[i]*min), nums[i]);
            min = Math.min(Math.min(nums[i]*tmp, nums[i]*min), nums[i]);
            result = max>result?max:result;
        }
        return result;
    }
}
