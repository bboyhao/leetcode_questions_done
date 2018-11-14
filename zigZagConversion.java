class Solution {
    public String convert(String s, int numRows) {
        if(s.length()<=numRows) return s;//think about when length of string is less than numOfRows
        if(numRows==1) return s;//think about when numRows is 1
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int period = 2*numRows-2;
        while(i<s.length()){
          sb.append(s.charAt(i));
          i+=period;
        }
        for(i = 1; i<numRows-1;i++){
          int j = i;
          int step = period-2*i;
          while(j<s.length()){
            sb.append(s.charAt(j));
            if(j+step>=s.length())break;
            sb.append(s.charAt(j+step));
            j+=period;
          }
        }
        i = numRows-1;
        while(i<s.length()){
          sb.append(s.charAt(i));
          i+=period;
        }
        return sb.toString();
    }
}
