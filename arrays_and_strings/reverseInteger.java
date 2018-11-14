class Solution {
    public int reverse(int x) {
        long n = (long) Math.abs(x);
        long result = 0;
        while(n>0){
            result*=10;
            result+=n%10;
            n/=10;
        }
        if(x<0) result=0-result;
        if(result>Math.pow(2,31)-1||result<Math.pow(-2,31))return 0;
        return (int)result;
    }
}