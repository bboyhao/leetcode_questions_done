class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;
        if(divisor == -1) return -dividend;
        if(dividend == 0 ) return 0;
        if((dividend>0 && dividend<divisor) ||(dividend<0 && dividend>divisor)) return 0;
        boolean sign = (dividend>0)^(divisor>0)? false : true;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long bb = b;
        long multiple = 1;
        long result = 0;
        while(b<=a){
            b=b<<1;
            multiple=multiple<<1;
        }
        b=b>>1;
        multiple=multiple>>1;
        while(a>=bb){
            a-=b;
            result+=multiple;
            if(a<bb) break;
            while(a<=b){
                b=b>>1;
                multiple=multiple>>1;
            }
        }
        return sign?(int)result:(int)-result;
    }
}
