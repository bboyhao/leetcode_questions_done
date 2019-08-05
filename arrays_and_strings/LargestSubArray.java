public class LargestSubArray{
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1;i<nums.length; i+=1){
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
