class Solution {
    public int longestValidParentheses(String s) {
        //dynamic programming
        char[] charArray = s.toCharArray();
        int[] dp = new int[charArray.length];
        int max = 0;
        for (int i = 1;i<charArray.length;i+=1){
            char tmp = charArray[i];
            if (tmp == '(') continue;
            if (charArray[i-1] == '('){
                int pre = i>2?dp[i-2]:0;
                dp[i] = pre + 2;
            } else{
                int index = i - dp[i-1] -1;
                if (index >= 0 && charArray[index] =='('){
                    int pre = index-1>0?dp[index-1]:0;
                    dp[i] = pre + dp[i-1] +2;
                }
            }
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    //really smart solution with O(1) space complexity
    public int longestValidParentheses2(String s){
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
