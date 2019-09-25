public class CountAndSay{
    public String countAndSay(int n){
        String result = "1";
        while(n-1>0){
            int cur = 0;
            StringBuilder sb = new StringBuilder();
            while(cur<result.length()){
                int count = 1;
                char c = result.charAt(cur);
                while(cur+1 < result.length() &&
                        result.charAt(cur) == result.charAt(cur+1)){
                    count += 1;
                    cur += 1;
                }
                sb.append(count);
                sb.append(c);
                cur+=1;
            }
            result = sb.toString();
            n--;
        }
        return result;
    }
}
