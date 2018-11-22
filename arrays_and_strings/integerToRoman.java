class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> m = new HashMap<>();
        m.put(1,"I");
        m.put(5,"V");
        m.put(10,"X");
        m.put(50,"L");
        m.put(100,"C");
        m.put(500,"D");
        m.put(1000,"M");
        int time = 1000;
        while(time>1){
            int half=time/2;
            int r1=num/time;
            for(int i = 0;i<r1;i++)sb.append(m.get(time));
            if(num%time>=0.9*time){
                sb.append(m.get(time/10));
                sb.append(m.get(time));
                num=num-r1*time-time/10*9;
            }
            else{
                num-=r1*time;
            }
            int r2=num/half;
            for(int i = 0;i<r2;i++)sb.append(m.get(half));
            if(num%half>=0.8*half){
                sb.append(m.get(half/5));
                sb.append(m.get(half));
                num=num-r2*half-half/5*4;
            }
            else{
                num=num-r2*half;
            }
            time/=10;
        }
        for(int i = 0;i<num%5;i++)sb.append(m.get(1));
        return sb.toString();
    }

    public String intToRoman2(int num){
        String[] a = {"", "M", "MM", "MMM"};
        String[] b = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] c = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] d = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return a[num/1000]+b[num%1000/100]+c[num%100/10]+d[num%10];
    }
}
