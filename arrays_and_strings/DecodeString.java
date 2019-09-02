public class DecodeString{
    //not easy to implement
    public String decodeString(String s) {
        int len = s.length();
        StringBuilder sb =  new StringBuilder();
        int idx = 0;
        while (idx < len){
            char c = s.charAt(idx);
            if (Character.isDigit(c)){
                int cnt = c - '0';
                while(idx < len-1 && Character.isDigit(s.charAt(idx+1))){
                    cnt = cnt*10 + (s.charAt(++idx) - '0');
                }
                int l = 1;
                String cur = "";
                for(int idx2 = idx+2; idx2 < len; idx2++){
                    char c2 = s.charAt(idx2);
                    if (c2 == '[') l++;
                    if (c2 == ']') l--;
                    if (l == 0){
                        cur = decodeString(s.substring(idx+2, idx2));
                        idx = idx2;
                        break;
                    }
                }
                for(int k = 0; k < cnt; k++){
                    sb.append(cur);
                }
            }
            else{
                sb.append(c);
            }
            idx++;
        }
        return sb.toString();
    }
}
