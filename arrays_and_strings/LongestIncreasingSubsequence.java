public class LongestIncreasingSubsequence{
    //brute force solution. Time complexity is O(2^n)
    public int lengthOfLIS(int[] nums) {
        return lengthofLIS(nums, Integer.MIN_VALUE, 0);
    }

    public int lengthofLIS(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[curpos] > prev) {
            taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
        }
        int nottaken = lengthofLIS(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }

    //DP solution. Time Comeplecity is O(n^2)
    public int lengthOfLIS2(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = dp[0];
        for(int i = 1; i<nums.length; i++){
            int maxSeq = 0;
            for(int j = 0; j<i; j++){
                if(nums[i] > nums[j]) {
                    maxSeq = Math.max(dp[j], maxSeq);
                }
            }
            dp[i] = maxSeq + 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    //DP with binary search. Time complexity is O(nlg(n))
    //smart!
    public int lengthOfLIS3(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }


}
