public class UniqueBST{
    public int numTrees(int n){
        int[] dp = new int[n+1];

        dp[0] = 1;

        for (int i = 1;i<=n;i+=1){
            int sum = 0;
            for (int j = i; j<=i; j+=1){
                sum += dp[j-1] * dp[i-j];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
