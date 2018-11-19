class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int tmp = x;
        int a = 0;
        while(tmp>0){
            a = a * 10 + tmp%10;
            tmp/=10;
        }
        if(a==x) return true;
        return false;
    }
}
