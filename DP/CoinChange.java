public class CoinChange{
    //top-down solution
    public int coinChange(int[] coins, int amount){
        if(amount <= 0) return -1;
        return coinChange(coins, amount, new int[amount]);
    }

    public int coinChange(int[] coins, int remain, int[] dp){
        if(remain < 0) return -1;
        if(remain == 0) return 0;
        if(dp[remain-1] != 0) return dp[remain-1];
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = coinChange(coins, remain-coin, dp);
            if(res >= 0){
                min = Math.min(res+1, min);
            }
        }
        dp[remain-1] = (min == Integer.MAX_VALUE)?-1:min;
        return dp[remain-1];
    }

    //bottom-up solution
    public int coinChange2(int[] coins, int amount){
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        for(int i = 1;i<dp.length;i++){
            dp[i] = 1000;
        }
        for(int i = 1; i<=amount; i+=1){
            for(int coin : coins){
                if(i<coin){
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount] == 1000?-1:dp[amount];
    }
}
