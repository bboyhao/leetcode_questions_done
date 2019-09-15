public class TargetSum{
    //Need to study this question
    //DFS solution
    //Time: O(2^n) Space: O(n) -> depth of recurstion tree
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0) return 0;
        return dfs(nums, 0, S, 0);
    }

    public int dfs(int[] nums, int i, int sum, int curSum){
        if(i == nums.length){
            if(curSum == sum) return 1;
            else return 0;
        }
        return dfs(nums, i+1, sum, curSum + nums[i]) +
            dfs(nums, i+1, sum, curSum - nums[i]);
    }

    public int findTargetSumWays2(int[] nums, int S) {

        // 看了discussion才有了思路
        // convert this to subset sum problem
        // sumP + sumQ = sum(nums)
        // sumP - sumQ = target
        // ==>
        // sumP = (sum(nums) + target) / 2 背包的size得出

        // 2-d, 因为这是无放回的抢，所以需要时2d
        // dp[i][k] 背包size is k,from first i elemetns, 装满背包能有多少种可能

        // dp[i][k] = SUM(dp[i-1][k], dp[i-1][k-nums[i]])
        // dp[0][0] = 1;

        // memory limit exceed, need to optimize space now
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum + S) % 2 == 1 || sum < S ) return 0; // not possible
        int size = (sum + S) / 2;
        int[] dp = new int[size+1];
        dp[0] = 1;

        // bag size
        for (int i = 1; i < nums.length + 1; i++) {
            // which item to rob
            for (int j = size; j >= 0; j--) {
                // dp[j] += dp[j];
                if (j - nums[i - 1] >= 0) {
                    dp[j] += dp[j - nums[i - 1]];
                }
            }
        }
        return dp[size];

    }

}
