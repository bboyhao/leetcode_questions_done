public class MaximalSquare{
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = row > 0 ? matrix[0].length : 0;
        int[] dp = new int[col + 1];

        int prev = 0;
        int maxLength = 0;
        for(int i = 1; i<=row;i++){
            for(int j = 1;j<=col;j++){
                int tmp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(Math.min(dp[j-1], prev), dp[j]) + 1;
                    maxLength = Math.max(dp[j], maxLength);
                }else{
                    dp[j] = 0;
                }
                prev = tmp;
            }
        }
        return maxLength * maxLength;
    } 
}
